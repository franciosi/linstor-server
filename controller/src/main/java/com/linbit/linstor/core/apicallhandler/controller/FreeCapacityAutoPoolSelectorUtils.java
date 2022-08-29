package com.linbit.linstor.core.apicallhandler.controller;

import com.linbit.ImplementationError;
import com.linbit.linstor.api.ApiCallRcImpl;
import com.linbit.linstor.api.ApiConsts;
import com.linbit.linstor.core.apicallhandler.response.ApiRcException;
import com.linbit.linstor.core.identifier.StorPoolName;
import com.linbit.linstor.core.objects.Node;
import com.linbit.linstor.core.objects.StorPool;
import com.linbit.linstor.propscon.InvalidKeyException;
import com.linbit.linstor.security.AccessContext;
import com.linbit.linstor.security.AccessDeniedException;

import java.util.Map;
import java.util.Optional;

public class FreeCapacityAutoPoolSelectorUtils
{
    public static final double DEFAULT_MAX_OVERSUBSCRIPTION_RATIO = 20.;

    /**
     * Returns whether the given storage pool is usable in terms of capacity and provisioning type.
     * If the free capacity is unknown, an empty Optional is returned.
     */
    public static Optional<Boolean> isStorPoolUsable(
        long rscSize,
        Map<StorPool.Key, Long> freeCapacities,
        boolean includeThin,
        StorPoolName storPoolName,
        Node node,
        AccessContext apiCtx
    )
    {
        StorPool storPool = getStorPoolPrivileged(apiCtx, node, storPoolName);

        Optional<Boolean> usable;
        if (storPool.getDeviceProviderKind().usesThinProvisioning() && !includeThin)
        {
            usable = Optional.of(false);
        }
        else
        {
            usable = getFreeCapacityCurrentEstimationPrivileged(
                apiCtx,
                freeCapacities,
                storPool
            ).map(freeCapacity -> freeCapacity >= rscSize);
        }
        return usable;
    }

    public static Optional<Long> getFreeCapacityCurrentEstimationPrivileged(
        AccessContext accCtx,
        Map<StorPool.Key, Long> thinFreeCapacities,
        StorPool storPool
    )
    {
        long reservedCapacity = getReservedCapacityPrivileged(accCtx, storPool);

        Long freeCapacityOverride = thinFreeCapacities == null ?
            null :
            thinFreeCapacities.get(new StorPool.Key(storPool));

        Optional<Long> freeCapacity = freeCapacityOverride != null ?
            Optional.of(freeCapacityOverride) :
            getFreeSpaceLastUpdatedPrivileged(accCtx, storPool);

        Optional<Long> usableCapacity = freeCapacity.map(
            capacity ->
            {
                final long ret;
                boolean thinPool = storPool.getDeviceProviderKind().usesThinProvisioning();
                if (thinPool && capacity != Long.MAX_VALUE)
                {
                    long oversubscriptionCapacity = (long) (capacity * getMaxOversubscriptionRatio(accCtx, storPool));
                    if (oversubscriptionCapacity < capacity)
                    {
                        // overflow
                        ret = Long.MAX_VALUE;
                    }
                    else
                    {
                        ret = oversubscriptionCapacity;
                    }
                }
                else
                {
                    ret = capacity;
                }
                return ret;
            }
        );
        return usableCapacity.map(capacity ->
        {
            final long ret;
            if (reservedCapacity < 0 && -reservedCapacity > Long.MAX_VALUE - capacity)
            {
                /*
                 * we cannot check for overflow with:
                 * c - r > M
                 * if r is negative, since (c - r) would go beyond M, missing the point of the check
                 * -r > M - c
                 * should not have this problem
                 */
                ret = Long.MAX_VALUE; // prevent overflow
            }
            else
            {
                ret = capacity - reservedCapacity;
            }
            return ret;
        });
    }

    private static StorPool getStorPoolPrivileged(AccessContext accCtx, Node node, StorPoolName storPoolName)
    {
        StorPool storPool;
        try
        {
            storPool = node.getStorPool(accCtx, storPoolName);
        }
        catch (AccessDeniedException exc)
        {
            throw new ImplementationError(exc);
        }
        return storPool;
    }

    private static long getReservedCapacityPrivileged(AccessContext accCtx, StorPool storPool)
    {
        long reservedCapacity;
        try
        {
            reservedCapacity = storPool.getFreeSpaceTracker().getReservedCapacity(accCtx);
        }
        catch (AccessDeniedException exc)
        {
            throw new ImplementationError(exc);
        }
        return reservedCapacity;
    }

    private static Optional<Long> getFreeSpaceLastUpdatedPrivileged(AccessContext accCtx, StorPool storPool)
    {
        Optional<Long> freeSpaceLastUpdated;
        try
        {
            freeSpaceLastUpdated = storPool.getFreeSpaceTracker().getFreeCapacityLastUpdated(accCtx);
        }
        catch (AccessDeniedException exc)
        {
            throw new ImplementationError(exc);
        }
        return freeSpaceLastUpdated;
    }

    private static double getMaxOversubscriptionRatio(AccessContext accCtx, StorPool storPool)
    {
        String maxOversubscriptionRatioRaw = getMaxOversubscriptionRatioRaw(accCtx, storPool);
        double maxOversubscriptionRatio;
        if (maxOversubscriptionRatioRaw == null)
        {
            maxOversubscriptionRatio = DEFAULT_MAX_OVERSUBSCRIPTION_RATIO;
        }
        else
        {
            try
            {
                maxOversubscriptionRatio = Double.valueOf(maxOversubscriptionRatioRaw);
            }
            catch (NumberFormatException exc)
            {
                throw new ApiRcException(ApiCallRcImpl.simpleEntry(
                    ApiConsts.FAIL_INVLD_PROP,
                    "Invalid value for max oversubscription ratio '" + maxOversubscriptionRatioRaw + "'"
                ));
            }
        }
        return maxOversubscriptionRatio;
    }

    private static String getMaxOversubscriptionRatioRaw(AccessContext accCtx, StorPool storPool)
    {
        String maxOversubscriptionRatioRaw;
        try
        {
            maxOversubscriptionRatioRaw = storPool.getDefinition(accCtx).getProps(accCtx)
                .getProp(ApiConsts.KEY_STOR_POOL_DFN_MAX_OVERSUBSCRIPTION_RATIO);
        }
        catch (InvalidKeyException | AccessDeniedException exc)
        {
            throw new ImplementationError(exc);
        }
        return maxOversubscriptionRatioRaw;
    }

    private FreeCapacityAutoPoolSelectorUtils()
    {
    }
}
