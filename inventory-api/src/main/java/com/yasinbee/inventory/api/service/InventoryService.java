package com.yasinbee.inventory.api.service;

import com.yasinbee.apifirst.inventory.api.dto.InventoryStatus;
import com.yasinbee.apifirst.inventory.api.dto.InventoryStatusRequest;

public interface InventoryService {

    InventoryStatus getInventoryStatus(InventoryStatusRequest request);

    default void tester() {
        InventoryStatus.newBuilder().build();
    }
}
