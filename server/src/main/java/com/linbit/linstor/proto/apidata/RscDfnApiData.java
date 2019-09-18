package com.linbit.linstor.proto.apidata;

import com.linbit.linstor.api.interfaces.RscDfnLayerDataApi;
import com.linbit.linstor.api.pojo.RscGrpPojo;
import com.linbit.linstor.api.protobuf.ProtoDeserializationUtils;
import com.linbit.linstor.api.protobuf.ProtoLayerUtils;
import com.linbit.linstor.core.apis.ResourceDefinitionApi;
import com.linbit.linstor.core.objects.ResourceDefinition;
import com.linbit.linstor.core.objects.ResourceGroup.RscGrpApi;
import com.linbit.linstor.core.objects.VolumeDefinition;
import com.linbit.linstor.proto.common.RscDfnOuterClass;
import com.linbit.linstor.proto.common.VlmDfnOuterClass.VlmDfn;
import com.linbit.utils.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author rpeinthor
 */
public class RscDfnApiData implements ResourceDefinitionApi
{
    private final RscDfnOuterClass.RscDfn rscDfn;
    private final List<Pair<String, RscDfnLayerDataApi>> layerData;
    private final RscGrpPojo rscGrp;

    public RscDfnApiData(RscDfnOuterClass.RscDfn rscDfnRef)
    {
        layerData = ProtoLayerUtils.extractRscDfnLayerData(rscDfnRef);
        rscDfn = rscDfnRef;
        rscGrp = ProtoDeserializationUtils.parseRscGrp(rscDfnRef.getRscGrp());
    }

    @Override
    public UUID getUuid()
    {
        UUID uuid = null;
        if (rscDfn.hasRscDfnUuid())
        {
            uuid = UUID.fromString(rscDfn.getRscDfnUuid());
        }
        return uuid;
    }

    @Override
    public RscGrpApi getResourceGroup()
    {
        return rscGrp;
    }

    @Override
    public String getResourceName()
    {
        return rscDfn.getRscName();
    }

    @Override
    public byte[] getExternalName()
    {
        return rscDfn.getExternalName().toByteArray();
    }

    @Override
    public long getFlags()
    {
        return ResourceDefinition.Flags.fromStringList(rscDfn.getRscDfnFlagsList());
    }

    @Override
    public Map<String, String> getProps()
    {
        return rscDfn.getRscDfnPropsMap();
    }

    @Override
    public List<VolumeDefinition.VlmDfnApi> getVlmDfnList()
    {
        List<VolumeDefinition.VlmDfnApi> ret = new ArrayList<>();
        for (VlmDfn vlmDfn : rscDfn.getVlmDfnsList())
        {
            ret.add(new VlmDfnApiData(vlmDfn));
        }
        return ret;
    }

    @Override
    public List<Pair<String, RscDfnLayerDataApi>> getLayerData()
    {
        return layerData;
    }
}
