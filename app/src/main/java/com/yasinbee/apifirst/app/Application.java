package com.yasinbee.apifirst.app;

import com.yasinbee.apifirst.order.config.InventoryConfig;
import com.yasinbee.apifirst.order.config.OrderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ImportAutoConfiguration(classes = {OrderConfig.class, InventoryConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
