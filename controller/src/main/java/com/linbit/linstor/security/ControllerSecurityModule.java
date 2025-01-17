package com.linbit.linstor.security;

import com.linbit.ImplementationError;
import com.linbit.linstor.ControllerDatabase;
import com.linbit.linstor.InitializationException;
import com.linbit.linstor.annotation.PublicContext;
import com.linbit.linstor.annotation.SystemContext;
import com.linbit.linstor.core.cfg.CtrlConfig;
import com.linbit.linstor.logging.ErrorReporter;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.linbit.linstor.LinStorException;
import com.linbit.linstor.modularcrypto.ModularCryptoProvider;

public class ControllerSecurityModule extends AbstractModule
{
    @Override
    protected void configure()
    {
    }

    @Provides
    public SecurityLevelSetter securityLevelSetter(
        final ControllerDatabase dbConnectionPool,
        final DbAccessor securityDbDriver
    )
    {
        return (accCtx, newLevel) ->
            SecurityLevel.set(accCtx, newLevel, dbConnectionPool, securityDbDriver);
    }

    @Provides
    public MandatoryAuthSetter mandatoryAuthSetter(
        final ControllerDatabase dbConnectionPool,
        final DbAccessor securityDbDriver
    )
    {
        return (accCtx, newPolicy) ->
            Authentication.setRequired(accCtx, newPolicy, dbConnectionPool, securityDbDriver);
    }

    @Provides
    @Singleton
    public CtrlAuthentication initializeAuthentication(
        @SystemContext AccessContext initCtx,
        @PublicContext AccessContext publicCtx,
        ErrorReporter errorLogRef,
        ControllerDatabase dbConnPool,
        DbAccessor securityDbDriver,
        ModularCryptoProvider cryptoProvider,
        CtrlConfig ctrlConfRef
    )
        throws InitializationException
    {
        errorLogRef.logInfo("Initializing authentication subsystem");

        CtrlAuthentication authentication;
        try
        {
            authentication = new CtrlAuthentication(
                initCtx,
                initCtx,
                publicCtx,
                dbConnPool,
                securityDbDriver,
                cryptoProvider,
                errorLogRef,
                ctrlConfRef
            );
        }
        catch (AccessDeniedException accExc)
        {
            throw new ImplementationError(
                "The initialization security context does not have the necessary " +
                    "privileges to create the authentication subsystem",
                accExc
            );
        }
        catch (LinStorException exc)
        {
            throw new InitializationException(exc);
        }
        return authentication;
    }

    @Provides
    @Singleton
    public Authorization initializeAuthorization(
        @SystemContext AccessContext initCtx,
        ErrorReporter errorLogRef,
        ControllerDatabase dbConnPool,
        DbAccessor securityDbDriver
    )
    {
        errorLogRef.logInfo("Initializing authorization subsystem");

        Authorization authorization;
        try
        {
            authorization = new Authorization(initCtx, dbConnPool, securityDbDriver);
        }
        catch (AccessDeniedException accExc)
        {
            throw new ImplementationError(
                "The initialization security context does not have the necessary " +
                    "privileges to create the authorization subsystem",
                accExc
            );
        }
        return authorization;
    }
}
