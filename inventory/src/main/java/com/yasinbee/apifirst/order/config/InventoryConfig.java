package com.yasinbee.apifirst.order.config;

import com.yasinbee.inventory.api.service.InventoryService;
import com.yasinbee.apifirst.order.service.InventoryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.yasinbee.apifirst.order")
public class InventoryConfig {

    @Bean
    public InventoryService getInventoryService() {
        return new InventoryServiceImpl();
    }
}
