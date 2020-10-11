package com.yasinbee.inventory.api.service;

import com.yasinbee.inventory.api.dto.InventoryStatus;
import com.yasinbee.inventory.api.dto.InventoryStatusRequest;

public interface InventoryService {

    InventoryStatus getInventoryStatus(InventoryStatusRequest request);
}
