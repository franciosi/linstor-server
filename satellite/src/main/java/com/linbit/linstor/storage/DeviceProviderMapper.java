package com.linbit.linstor.storage;

import com.linbit.ImplementationError;
import com.linbit.linstor.StorPool;
import com.linbit.linstor.storage.kinds.DeviceProviderKind;
import com.linbit.linstor.storage.layer.provider.DeviceProvider;
import com.linbit.linstor.storage.layer.provider.diskless.DrbdDisklessProvider;
import com.linbit.linstor.storage.layer.provider.lvm.LvmProvider;
import com.linbit.linstor.storage.layer.provider.lvm.LvmThinProvider;
import com.linbit.linstor.storage.layer.provider.swordfish.SwordfishInitiatorProvider;
import com.linbit.linstor.storage.layer.provider.swordfish.SwordfishTargetProvider;
import com.linbit.linstor.storage.layer.provider.zfs.ZfsProvider;
import com.linbit.linstor.storage.layer.provider.zfs.ZfsThinProvider;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;

@Singleton
public class DeviceProviderMapper
{
    private final LvmProvider lvmProvider;
    private final LvmThinProvider lvmThinProvider;
    private final ZfsProvider zfsProvider;
    private final ZfsThinProvider zfsThinProvider;
    private final SwordfishTargetProvider sfTargetProvider;
    private final SwordfishInitiatorProvider sfInitProvider;
    private final DrbdDisklessProvider disklessProvider;
    private final List<DeviceProvider> driverList;

    @Inject
    public DeviceProviderMapper(
        LvmProvider lvmProviderRef,
        LvmThinProvider lvmThinProviderRef,
        ZfsProvider zfsProviderRef,
        ZfsThinProvider zfsThinProviderRef,
        SwordfishTargetProvider sfTargetProviderRef,
        SwordfishInitiatorProvider sfInitProviderRef,
        DrbdDisklessProvider disklessProviderRef
    )
    {
        lvmProvider = lvmProviderRef;
        lvmThinProvider = lvmThinProviderRef;
        zfsProvider = zfsProviderRef;
        zfsThinProvider = zfsThinProviderRef;
        sfTargetProvider = sfTargetProviderRef;
        sfInitProvider = sfInitProviderRef;
        disklessProvider = disklessProviderRef;

        driverList = Arrays.asList(
            lvmProvider,
            lvmThinProvider,
            zfsProvider,
            zfsThinProvider,
            sfTargetProvider,
            sfInitProvider,
            disklessProvider
        );
    }

    public List<DeviceProvider> getDriverList()
    {
        return driverList;
    }

    public DeviceProvider getDeviceProviderByStorPool(StorPool storPool)
    {
        StorageDriverKind driverKind = storPool.getDriverKind();

        DeviceProvider devProvider;
        if (driverKind instanceof LvmDriverKind)
        {
            devProvider = lvmProvider;
        }
        else if (driverKind instanceof LvmThinDriverKind)
        {
            devProvider = lvmThinProvider;
        }
        else if (driverKind instanceof ZfsDriverKind)
        {
            devProvider = zfsProvider;
        }
        else if (driverKind instanceof ZfsThinDriverKind)
        {
            devProvider = zfsThinProvider;
        }
        else if (driverKind instanceof SwordfishTargetDriverKind)
        {
            devProvider = sfTargetProvider;
        }
        else if (driverKind instanceof SwordfishInitiatorDriverKind)
        {
            devProvider = sfInitProvider;
        }
        else if (driverKind instanceof DisklessDriverKind)
        {
            devProvider = disklessProvider;
        }
        else
        {
            throw new ImplementationError("Unknown storage provider found: " +
                driverKind.getDriverName() + " " + driverKind.getClass().getSimpleName()
            );
        }
        return devProvider;
    }

    public DeviceProvider getDeviceProviderByKind(DeviceProviderKind deviceProviderKind)
    {
        DeviceProvider devProvider;
        switch (deviceProviderKind)
        {
            case LVM:
                devProvider = lvmProvider;
                break;
            case LVM_THIN:
                devProvider = lvmThinProvider;
                break;
            case SWORDFISH_INITIATOR:
                devProvider = sfInitProvider;
                break;
            case SWORDFISH_TARGET:
                devProvider = sfTargetProvider;
                break;
            case ZFS:
                devProvider = zfsProvider;
                break;
            case ZFS_THIN:
                devProvider = zfsThinProvider;
                break;
            case DRBD_DISKLESS:
                devProvider = disklessProvider;
                break;
            case FAIL_BECAUSE_NOT_A_VLM_PROVIDER_BUT_A_VLM_LAYER:
                throw new ImplementationError("A volume from a layer was asked for its provider type");
            default:
                throw new ImplementationError("Unknown storage provider found: " + deviceProviderKind);

        }
        return devProvider;
    }
}
