package com.yasinbee.apifirst.order.service;

import com.yasinbee.inventory.api.dto.InventoryStatus;
import com.yasinbee.inventory.api.dto.InventoryStatusRequest;
import com.yasinbee.inventory.api.service.InventoryService;

import java.util.HashMap;
import java.util.Map;

public class InventoryServiceImpl implements InventoryService {

    private final Map<Long, InventoryStatus> inventoryStatusMap = new HashMap<>();

    public InventoryServiceImpl() {
        InventoryStatus booksStatus = getBooksInventoryStatus();
        inventoryStatusMap.put(booksStatus.getUniqueItemId(), booksStatus);
    }

    @Override
    public InventoryStatus getInventoryStatus(InventoryStatusRequest request) {
        return inventoryStatusMap.get(request.getItemId());
    }

    private InventoryStatus getBooksInventoryStatus() {
        InventoryStatus status = new InventoryStatus();
        status.setItemName("books");
        status.setAvailableQuantity(5);
        status.setItemDescription("Books are loved by all");
        status.setUniqueItemId(99L);
        return status;
    }
}
