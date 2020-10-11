package com.yasinbee.apifirst.order.service;

import com.yasinbee.apifirst.order.dto.InventoryStatus;
import com.yasinbee.apifirst.order.dto.InventoryStatusRequest;

public interface InventoryService {

    InventoryStatus getInventoryStatus(InventoryStatusRequest request);
}
