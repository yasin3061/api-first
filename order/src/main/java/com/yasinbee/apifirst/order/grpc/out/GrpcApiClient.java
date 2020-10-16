package com.yasinbee.apifirst.order.grpc.out;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.AbstractStub;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GrpcApiClient {

    private AbstractStub stub;
    public GrpcApiClient(Class<?> grpc) {
        ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forAddress("localhost", 50000);
        channelBuilder.usePlaintext();

        ManagedChannel channel = channelBuilder.build();
        try {
            Class<?> grpcClass = grpc.forName(grpc.getCanonicalName());
            Method method = findMethodOnClass("newBlockingStub", grpcClass);
            this.stub = (AbstractStub) method.invoke(grpcClass, channel);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Cannot create gRPC client", e);
        }
    }

    private static Method findMethodOnClass(String methodName, Class<?> grpcClass) {
        Method[] methods = grpcClass.getMethods();
        Method method = null;

        for (Method m : methods) {
            if (m.getName().equals(methodName)) {
                method = m;
                break;
            }
        }

        if (method == null) {
            throw new RuntimeException("Cannot find methodName method");
        }

        return method;
    }

    public AbstractStub getStub() {
        return this.stub;
    }
}
