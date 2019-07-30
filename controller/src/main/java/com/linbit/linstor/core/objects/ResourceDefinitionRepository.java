package com.linbit.linstor.core.objects;

import com.linbit.linstor.core.CoreModule;
import com.linbit.linstor.core.identifier.ResourceName;
import com.linbit.linstor.core.objects.ResourceDefinition;
import com.linbit.linstor.core.objects.ResourceDefinitionData;
import com.linbit.linstor.security.AccessContext;
import com.linbit.linstor.security.AccessDeniedException;
import com.linbit.linstor.security.AccessType;
import com.linbit.linstor.security.ProtectedObject;

/**
 * Provides access to resource definitions with automatic security checks.
 */
public interface ResourceDefinitionRepository extends ProtectedObject
{
    void requireAccess(AccessContext accCtx, AccessType requested)
        throws AccessDeniedException;

    ResourceDefinitionData get(AccessContext accCtx, ResourceName nameRef)
        throws AccessDeniedException;

    ResourceDefinitionData get(AccessContext accCtx, byte[] externalName)
        throws AccessDeniedException;

    void put(AccessContext accCtx, ResourceDefinition resourceDefinition)
        throws AccessDeniedException;

    void remove(AccessContext accCtx, ResourceName resourceName, byte[] externalName)
        throws AccessDeniedException;

    CoreModule.ResourceDefinitionMap getMapForView(AccessContext accCtx)
        throws AccessDeniedException;

    CoreModule.ResourceDefinitionMapExtName getMapForViewExtName(AccessContext accCtx)
        throws AccessDeniedException;
}