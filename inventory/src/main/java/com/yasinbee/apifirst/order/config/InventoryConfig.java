package com.yasinbee.apifirst.order.config;

import com.yasinbee.apifirst.order.grpc.in.GrpcApiServer;
import com.yasinbee.apifirst.order.grpc.in.InventoryServiceApiGrpc;
import com.yasinbee.inventory.api.service.InventoryService;
import com.yasinbee.apifirst.order.service.InventoryServiceImpl;
import org.mapstruct.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.yasinbee.apifirst.order")
public class InventoryConfig {

//    @Bean(name = "inventoryService")
    public InventoryService getInventoryService() {
        return new InventoryServiceImpl();
    }

    @Bean
    public InventoryServiceApiGrpc getInventoryServiceApiGrpc() {
        return new InventoryServiceApiGrpc(getInventoryService());
    }

    @Bean
    public GrpcApiServer inventoryApiGrpcServer(InventoryServiceApiGrpc serviceApiGrpc) {
        return new GrpcApiServer(serviceApiGrpc);
    }
}
