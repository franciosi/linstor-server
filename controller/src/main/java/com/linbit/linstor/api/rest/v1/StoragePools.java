package com.linbit.linstor.api.rest.v1;

import com.linbit.linstor.LinstorParsingUtils;
import com.linbit.linstor.StorPool;
import com.linbit.linstor.api.ApiCallRc;
import com.linbit.linstor.api.ApiCallRcImpl;
import com.linbit.linstor.api.ApiCallRcWith;
import com.linbit.linstor.api.ApiConsts;
import com.linbit.linstor.api.rest.v1.serializer.Json;
import com.linbit.linstor.api.rest.v1.serializer.JsonGenTypes;
import com.linbit.linstor.core.apicallhandler.controller.CtrlStorPoolApiCallHandler;
import com.linbit.linstor.core.apicallhandler.controller.CtrlStorPoolCrtApiCallHandler;
import com.linbit.linstor.core.apicallhandler.controller.CtrlStorPoolListApiCallHandler;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.grizzly.http.server.Request;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Path("nodes/{nodeName}/storage-pools")
@Produces(MediaType.APPLICATION_JSON)
public class StoragePools
{
    private final RequestHelper requestHelper;
    private final CtrlStorPoolListApiCallHandler ctrlStorPoolListApiCallHandler;
    private final CtrlStorPoolApiCallHandler ctrlStorPoolApiCallHandler;
    private final CtrlStorPoolCrtApiCallHandler ctrlStorPoolCrtApiCallHandler;
    private final ObjectMapper objectMapper;

    @Inject
    StoragePools(
        RequestHelper requestHelperRef,
        CtrlStorPoolListApiCallHandler ctrlStorPoolListApiCallHandlerRef,
        CtrlStorPoolApiCallHandler ctrlStorPoolApiCallHandlerRef,
        CtrlStorPoolCrtApiCallHandler ctrlStorPoolCrtApiCallHandlerRef
    )
    {
        requestHelper = requestHelperRef;
        ctrlStorPoolListApiCallHandler = ctrlStorPoolListApiCallHandlerRef;
        ctrlStorPoolApiCallHandler = ctrlStorPoolApiCallHandlerRef;
        ctrlStorPoolCrtApiCallHandler = ctrlStorPoolCrtApiCallHandlerRef;
        objectMapper = new ObjectMapper();
    }

    @GET
    public void listStoragePools(
        @Context Request request,
        @Suspended final AsyncResponse asyncResponse,
        @PathParam("nodeName") String nodeName,
        @DefaultValue("0") @QueryParam("limit") int limit,
        @DefaultValue("0") @QueryParam("offset") int offset
    )
    {
        listStoragePools(request, asyncResponse, nodeName, null, limit, offset);
    }

    @GET
    @Path("{storPoolName}")
    public void listStoragePools(
        @Context Request request,
        @Suspended final AsyncResponse asyncResponse,
        @PathParam("nodeName") String nodeName,
        @PathParam("storPoolName") String storPoolName,
        @DefaultValue("0") @QueryParam("limit") int limit,
        @DefaultValue("0") @QueryParam("offset") int offset
    )
    {
        List<String> nodeNames = new ArrayList<>();
        List<String> storPoolNames = new ArrayList<>();

        if (nodeName != null)
        {
            nodeNames.add(nodeName);
        }

        if (storPoolName != null)
        {
            storPoolNames.add(storPoolName);
        }

        Flux<ApiCallRcWith<List<StorPool.StorPoolApi>>> flux = ctrlStorPoolListApiCallHandler
            .listStorPools(nodeNames, storPoolNames)
            .subscriberContext(requestHelper.createContext(ApiConsts.API_LST_STOR_POOL, request));

        requestHelper.doFlux(asyncResponse, apiCallRcWithToResponse(flux, nodeName, storPoolName, limit, offset));
    }

    Mono<Response> apiCallRcWithToResponse(
        Flux<ApiCallRcWith<List<StorPool.StorPoolApi>>> apiCallRcWithFlux,
        String nodeName,
        String storPoolName,
        int limit,
        int offset
    )
    {
        return apiCallRcWithFlux.flatMap(apiCallRcWith ->
        {
            Response resp;
            if (apiCallRcWith.hasApiCallRc())
            {
                resp = ApiCallRcConverter.toResponse(
                    apiCallRcWith.getApiCallRc(),
                    Response.Status.INTERNAL_SERVER_ERROR
                );
            }
            else
            {
                Stream<StorPool.StorPoolApi> storPoolApiStream = apiCallRcWith.getValue().stream();
                if (limit > 0)
                {
                    storPoolApiStream = storPoolApiStream.skip(offset).limit(limit);
                }
                List<JsonGenTypes.StoragePool> storPoolDataList = storPoolApiStream
                    .map(Json::storPoolApiToStoragePool)
                    .collect(Collectors.toList());

                try
                {
                    if (storPoolName != null && storPoolDataList.isEmpty())
                    {
                        ApiCallRcImpl apiCallRc = new ApiCallRcImpl();
                        apiCallRc.addEntry(
                            ApiCallRcImpl.simpleEntry(
                                ApiConsts.FAIL_NOT_FOUND_STOR_POOL,
                                String.format("Storage pool '%s' on node '%s' not found.", storPoolName, nodeName)
                            )
                        );

                        resp = Response
                            .status(Response.Status.NOT_FOUND)
                            .entity(ApiCallRcConverter.toJSON(apiCallRc))
                            .type(MediaType.APPLICATION_JSON)
                            .build();
                    }
                    else
                    {
                        resp = Response
                            .status(Response.Status.OK)
                            .entity(objectMapper.writeValueAsString(
                                storPoolName != null ? storPoolDataList.get(0) : storPoolDataList)
                            )
                            .type(MediaType.APPLICATION_JSON)
                            .build();
                    }
                }
                catch (JsonProcessingException exc)
                {
                    exc.printStackTrace();
                    resp = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
                }
            }

            return Mono.just(resp);
        }).next();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createStorPool(
        @Context Request request,
        @Suspended final AsyncResponse asyncResponse,
        @PathParam("nodeName") String nodeName,
        String jsonData
    )
    {
        try
        {
            JsonGenTypes.StoragePool storPoolData = objectMapper
                .readValue(jsonData, JsonGenTypes.StoragePool.class);

            Flux<ApiCallRc> responses = ctrlStorPoolCrtApiCallHandler.createStorPool(
                nodeName,
                storPoolData.storage_pool_name,
                LinstorParsingUtils.asProviderKind(storPoolData.provider_kind),
                storPoolData.free_space_mgr_name,
                storPoolData.props
            )
                .subscriberContext(requestHelper.createContext(ApiConsts.API_CRT_STOR_POOL, request));

            requestHelper.doFlux(
                asyncResponse,
                ApiCallRcConverter.mapToMonoResponse(responses, Response.Status.CREATED)
            );
        }
        catch (IOException ioExc)
        {
            ApiCallRcConverter.handleJsonParseException(ioExc, asyncResponse);
        }
    }

    @PUT
    @Path("{storPoolName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifyStorPool(
        @Context Request request,
        @PathParam("nodeName") String nodeName,
        @PathParam("storPoolName") String storPoolName,
        String jsonData
    )
    {
        return requestHelper.doInScope(requestHelper.createContext(ApiConsts.API_DEL_STOR_POOL, request), () ->
            {
                JsonGenTypes.StoragePoolDefinitionModify modifyData = objectMapper
                    .readValue(jsonData, JsonGenTypes.StoragePoolDefinitionModify.class);

                return ApiCallRcConverter.toResponse(
                    ctrlStorPoolApiCallHandler.modifyStorPool(
                        null,
                        nodeName,
                        storPoolName,
                        modifyData.override_props,
                        new HashSet<>(modifyData.delete_props),
                        new HashSet<>(modifyData.delete_namespaces)
                    ),
                    Response.Status.OK
                );
            },
            true
        );
    }

    @DELETE
    @Path("{storPoolName}")
    public Response deleteStorPool(
        @Context Request request,
        @PathParam("nodeName") String nodeName,
        @PathParam("storPoolName") String storPoolName
    )
    {
        return requestHelper.doInScope(requestHelper.createContext(ApiConsts.API_DEL_STOR_POOL, request), () ->
            ApiCallRcConverter.toResponse(
                ctrlStorPoolApiCallHandler.deleteStorPool(nodeName, storPoolName),
                Response.Status.OK
            ),
            true
        );
    }
}
