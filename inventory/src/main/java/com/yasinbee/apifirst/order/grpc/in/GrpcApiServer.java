package com.yasinbee.apifirst.order.grpc.in;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;

import java.io.IOException;

public class GrpcApiServer {

    private final BindableService service;

    public GrpcApiServer(BindableService service) {
        this.service = service;
        registerService();
    }

    private void registerService() {
        ServerServiceDefinition serverServiceDefinition = service.bindService();
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(50000);
        Server server = serverBuilder.addService(serverServiceDefinition).build();
        startGrpcServer(server);
    }

    private void startGrpcServer(Server server) {
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
