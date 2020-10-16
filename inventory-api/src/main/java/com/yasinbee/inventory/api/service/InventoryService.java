package com.yasinbee.inventory.api.service;

import com.yasinbee.apifirst.inventory.api.dto.InventoryStatus;
import com.yasinbee.apifirst.inventory.api.dto.InventoryStatusRequest;

public interface InventoryService {
    InventoryStatus getStatus(InventoryStatusRequest request);
}
