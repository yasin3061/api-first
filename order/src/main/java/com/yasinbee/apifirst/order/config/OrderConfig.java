package com.yasinbee.apifirst.order.config;

import com.yasinbee.apifirst.order.dao.OrderRepository;
import com.yasinbee.apifirst.order.grpc.out.InventoryServiceStub;
import com.yasinbee.inventory.api.service.InventoryService;
import com.yasinbee.apifirst.order.service.OrderService;
import com.yasinbee.apifirst.order.service.OrderServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.yasinbee.apifirst.order")
@EntityScan(basePackages = "com.yasinbee.apifirst.order.dao.model")
@EnableJpaRepositories("com.yasinbee.apifirst.order.dao")
public class OrderConfig {

    @Bean
    public OrderService getOrderService(OrderRepository dao) {
        return new OrderServiceImpl(getInventoryServiceProxy(), dao);
    }

    public InventoryService getInventoryServiceProxy() {
        return new InventoryServiceStub();
    }
}
