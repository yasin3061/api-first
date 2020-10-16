package com.yasinbee.apifirst.order.grpc.in;

import com.yasinbee.apifirst.inventory.api.dto.InventoryServiceGrpc;
import com.yasinbee.apifirst.inventory.api.dto.InventoryStatus;
import com.yasinbee.apifirst.inventory.api.dto.InventoryStatusRequest;
import com.yasinbee.inventory.api.service.InventoryService;
import io.grpc.stub.StreamObserver;

public class InventoryServiceApiGrpc extends InventoryServiceGrpc.InventoryServiceImplBase {

    private final InventoryService service;
    public InventoryServiceApiGrpc(InventoryService service) {
        this.service =  service;
    }

    @Override
    public void getStatus(InventoryStatusRequest request,
                          StreamObserver<InventoryStatus> responseObserver) {
        responseObserver.onNext(service.getStatus(request));
        responseObserver.onCompleted();
    }
}
