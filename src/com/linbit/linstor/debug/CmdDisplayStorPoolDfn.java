package com.linbit.linstor.debug;

import com.linbit.InvalidNameException;
import com.linbit.linstor.StorPool;
import com.linbit.linstor.StorPoolDefinition;
import com.linbit.linstor.StorPoolName;
import com.linbit.linstor.security.AccessContext;
import com.linbit.linstor.security.AccessDeniedException;
import com.linbit.linstor.security.AccessType;
import com.linbit.linstor.security.ObjectProtection;
import com.linbit.utils.TreePrinter;
import com.linbit.utils.UuidUtils;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;

public class CmdDisplayStorPoolDfn extends BaseDebugCmd
{
    private static final Map<String, String> PARAMETER_DESCRIPTIONS = new TreeMap<>();

    private final FilteredObjectLister<StorPoolDefinition> lister;

    static
    {
        PARAMETER_DESCRIPTIONS.put(
            FilteredObjectLister.PRM_NAME,
            "Name of the storage pool definition(s) to display"
        );
        PARAMETER_DESCRIPTIONS.put(
            FilteredObjectLister.PRM_FILTER_NAME,
            "Filter pattern to apply to the storage pool definition name.\n" +
            "Storage pool definitions with a name matching the pattern will be displayed."
        );
    }

    public CmdDisplayStorPoolDfn()
    {
        super(
            new String[]
            {
                "DspStorPoolDfn"
            },
            "Display storage pool definition(s)",
            "Displays information about one or multiple storage pool definition(s)",
            PARAMETER_DESCRIPTIONS,
            null
        );

        lister = new FilteredObjectLister<>(
            "storage pool definition",
            "storage pool definition",
            new StorPoolDefinitionHandler()
        );
    }

    @Override
    public void execute(
        PrintStream debugOut,
        PrintStream debugErr,
        AccessContext accCtx,
        Map<String, String> parameters
    )
        throws Exception
    {
        lister.execute(debugOut, debugErr, accCtx, parameters);
    }

    private class StorPoolDefinitionHandler implements FilteredObjectLister.ObjectHandler<StorPoolDefinition>
    {
        @Override
        public List<Lock> getRequiredLocks()
        {
            return Arrays.asList(
                cmnDebugCtl.getReconfigurationLock().readLock(),
                cmnDebugCtl.getStorPoolDfnMapLock().readLock()
            );
        }

        @Override
        public void ensureSearchAccess(final AccessContext accCtx)
            throws AccessDeniedException
        {
            ObjectProtection storPoolDfnMapProt = cmnDebugCtl.getStorPoolDfnMapProt();
            if (storPoolDfnMapProt != null)
            {
                storPoolDfnMapProt.requireAccess(accCtx, AccessType.VIEW);
            }
        }

        @Override
        public Collection<StorPoolDefinition> getAll()
        {
            return cmnDebugCtl.getStorPoolDfnMap().values();
        }

        @Override
        public StorPoolDefinition getByName(final String name)
            throws InvalidNameException
        {
            return cmnDebugCtl.getStorPoolDfnMap().get(new StorPoolName(name));
        }

        @Override
        public String getName(final StorPoolDefinition storPoolDfnRef)
        {
            return storPoolDfnRef.getName().value;
        }

        @Override
        public void displayObjects(
            final PrintStream output, final StorPoolDefinition storPoolDfnRef, final AccessContext accCtx
        )
        {
            try
            {
                ObjectProtection objProt = storPoolDfnRef.getObjProt();
                objProt.requireAccess(accCtx, AccessType.VIEW);

                TreePrinter.Builder treeBuilder = TreePrinter
                    .builder(
                        "\u001b[1;37m%-40s\u001b[0m %-36s",
                        storPoolDfnRef.getName().displayValue,
                        storPoolDfnRef.getUuid().toString().toUpperCase()
                    )
                    .leaf("Volatile UUID: %s", UuidUtils.dbgInstanceIdString(storPoolDfnRef))
                    .leaf(
                        "Creator: %-24s Owner: %-24s",
                        objProt.getCreator().name.displayValue,
                        objProt.getOwner().name.displayValue
                    )
                    .leaf("Security type: %-24s", objProt.getSecurityType().name.displayValue);

                Iterator<StorPool> storPoolIterator = storPoolDfnRef.iterateStorPools(accCtx);

                treeBuilder.branchHideEmpty("Storage pools");
                while (storPoolIterator.hasNext())
                {
                    StorPool storPool = storPoolIterator.next();

                    treeBuilder
                        .branch(
                            "\u001b[1;37mStorage pool\u001b[0m %-36s",
                            storPool.getUuid().toString().toUpperCase()
                        )
                        .leaf("Node name: %s", storPool.getNode().getName().displayValue)
                        .leaf("Node UUID: %s", storPool.getNode().getUuid().toString().toUpperCase())
                        .leaf("Node volatile UUID: %s", UuidUtils.dbgInstanceIdString(storPool.getNode()))
                        .leaf("Driver name: %s", storPool.getDriverName())
                        .leaf("Volume count: %d", storPool.getVolumes(accCtx).size())
                        .endBranch();
                }
                treeBuilder.endBranch();

                treeBuilder.print(output);
            }
            catch (AccessDeniedException accExc)
            {
                // No view access
            }
        }

        @Override
        public int countObjects(final StorPoolDefinition storPoolDfnRef, final AccessContext accCtx)
        {
            return 1;
        }
    }
}
