package com.linbit.linstor.dbdrivers.k8s.crd;

import com.linbit.ImplementationError;
import com.linbit.linstor.dbdrivers.DatabaseTable;
import com.linbit.linstor.dbdrivers.DatabaseTable.Column;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LinstorVersionSpec implements LinstorSpec
{
    @JsonIgnore private static final long serialVersionUID = 5539207148044018793L;

    @JsonProperty("version") public final int version;

    @JsonCreator
    public LinstorVersionSpec(@JsonProperty("version") int versionRef)
    {
        version = versionRef;
    }

    @JsonIgnore
    @Override
    public String getLinstorKey()
    {
        return "version";
    }

    @JsonIgnore
    public static String getYamlLocation()
    {
        return "com/linbit/linstor/dbcp/k8s/crd/LinstorVersion.yaml";
    }

    @Override
    @JsonIgnore
    public Map<String, Object> asRawParameters()
    {
        throw new ImplementationError("Method not supported by LinstorVersion");
    }

    @Override
    @JsonIgnore
    public Object getByColumn(Column clmRef)
    {
        throw new ImplementationError("Method not supported by LinstorVersion");
    }

    @Override
    @JsonIgnore
    public DatabaseTable getDatabaseTable()
    {
        throw new ImplementationError("Method not supported by LinstorVersion");
    }
}
