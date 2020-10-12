package com.yasinbee.apifirst.order.service;

import com.yasinbee.apifirst.inventory.api.dto.InventoryStatus;
import com.yasinbee.apifirst.inventory.api.dto.InventoryStatusRequest;
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
        return InventoryStatus.newBuilder()
                .setItemName("books")
                .setAvailableQuantity(5)
                .setItemDescription("Books are loved by all")
                .setUniqueItemId(99L)
                .build();
    }
}
