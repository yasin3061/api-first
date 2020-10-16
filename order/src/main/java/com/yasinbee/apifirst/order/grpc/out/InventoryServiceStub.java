package com.yasinbee.apifirst.order.grpc.out;

import com.google.protobuf.GeneratedMessageV3;
import com.yasinbee.apifirst.inventory.api.dto.InventoryServiceGrpc;
import com.yasinbee.apifirst.inventory.api.dto.InventoryStatus;
import com.yasinbee.apifirst.inventory.api.dto.InventoryStatusRequest;
import com.yasinbee.inventory.api.service.InventoryService;
import io.grpc.MethodDescriptor;
import io.grpc.stub.ClientCalls;

import java.util.function.Supplier;

public class InventoryServiceStub implements InventoryService {

    @Override
    public InventoryStatus getStatus(InventoryStatusRequest request) {
        GrpcApiClient client = new GrpcApiClient(InventoryServiceGrpc.class);

        return (InventoryStatus) invokeService(client,
                InventoryServiceGrpc::getGetStatusMethod, request);
    }

    private GeneratedMessageV3 invokeService(GrpcApiClient client,
                                             Supplier<MethodDescriptor> method
            , GeneratedMessageV3 request) {

        return (GeneratedMessageV3) ClientCalls.blockingUnaryCall(client.getStub().getChannel(), method.get(),
                client.getStub().getCallOptions(), request);
    }
}
