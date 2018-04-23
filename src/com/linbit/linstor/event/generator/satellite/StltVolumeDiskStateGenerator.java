package com.linbit.linstor.event.generator.satellite;

import com.linbit.linstor.drbdstate.DrbdEventService;
import com.linbit.linstor.event.ObjectIdentifier;
import com.linbit.linstor.event.generator.VolumeDiskStateGenerator;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StltVolumeDiskStateGenerator implements VolumeDiskStateGenerator
{
    private final DrbdEventService drbdEventService;

    @Inject
    public StltVolumeDiskStateGenerator(DrbdEventService drbdEventServiceRef)
    {
        drbdEventService = drbdEventServiceRef;
    }

    @Override
    public String generate(ObjectIdentifier objectIdentifier)
        throws Exception
    {
        return drbdEventService.getDrbdResource(objectIdentifier.getResourceName().displayValue)
            .getVolume(objectIdentifier.getVolumeNumber())
            .getDiskState()
            .toString();
    }
}
