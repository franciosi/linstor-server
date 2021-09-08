package com.linbit.linstor.storage.data.provider.spdk;

import com.linbit.linstor.api.interfaces.VlmLayerDataApi;
import com.linbit.linstor.api.pojo.StorageRscPojo.SpdkVlmPojo;
import com.linbit.linstor.core.objects.AbsResource;
import com.linbit.linstor.core.objects.AbsVolume;
import com.linbit.linstor.core.objects.StorPool;
import com.linbit.linstor.dbdrivers.DatabaseException;
import com.linbit.linstor.dbdrivers.interfaces.StorageLayerDatabaseDriver;
import com.linbit.linstor.security.AccessContext;
import com.linbit.linstor.security.AccessDeniedException;
import com.linbit.linstor.storage.data.provider.AbsStorageVlmData;
import com.linbit.linstor.storage.data.provider.StorageRscData;
import com.linbit.linstor.storage.interfaces.categories.resource.VlmDfnLayerObject;
import com.linbit.linstor.storage.interfaces.layers.storage.SpdkProviderObject;
import com.linbit.linstor.storage.kinds.DeviceProviderKind;
import com.linbit.linstor.transaction.TransactionObjectFactory;
import com.linbit.linstor.transaction.manager.TransactionMgr;

import javax.annotation.Nullable;
import javax.inject.Provider;

import java.util.ArrayList;

public class SpdkData<RSC extends AbsResource<RSC>>
    extends AbsStorageVlmData<RSC>
    implements SpdkProviderObject<RSC>
{
    // not persisted, not serialized, stlt only
    private transient String volumeGroup;
    private String spdkPath;

    public SpdkData(
        AbsVolume<RSC> vlmRef,
        StorageRscData<RSC> rscDataRef,
        DeviceProviderKind providerKindRef,
        StorPool storPoolRef,
        StorageLayerDatabaseDriver dbDriverRef,
        TransactionObjectFactory transObjFactory,
        Provider<? extends TransactionMgr> transMgrProvider
    )
    {
        super(
            vlmRef,
            rscDataRef,
            storPoolRef,
            dbDriverRef,
            providerKindRef,
            transObjFactory,
            transMgrProvider
        );
    }

    @Override
    public @Nullable VlmDfnLayerObject getVlmDfnLayerObject()
    {
        return null; // no special VlmDfnLayerObject for SPDK
    }

    @Override
    public void setStorPool(AccessContext accCtxRef, StorPool storPoolRef) throws DatabaseException, AccessDeniedException
    {
        super.setStorPool(accCtxRef, storPoolRef);
        volumeGroup = null; // force SpdkProvider to repeat the lookup using the new storage pool
    }

    public String getVolumeGroup()
    {
        return volumeGroup;
    }

    public void setVolumeGroup(String volumeGroupRef)
    {
        volumeGroup = volumeGroupRef;
    }

    @Override
    public VlmLayerDataApi asPojo(AccessContext accCtxRef) throws AccessDeniedException
    {
        return new SpdkVlmPojo(
            getVlmNr().value,
            getDevicePath(),
            getAllocatedSize(),
            getUsableSize(),
            getSnapshotAllocatedSize(),
            getSnapshotUsableSize(),
            new ArrayList<>(getStates()).toString(), // avoid "TransactionList " in the toString()
            storPool.get().getApiData(null, null, accCtxRef, null, null)
        );
    }

    public void setSpdkPath(String pathRef)
    {
        spdkPath = pathRef;
    }

    public String getSpdkPath()
    {
        return spdkPath;
    }
}
