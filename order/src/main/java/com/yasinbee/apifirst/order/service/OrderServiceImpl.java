package com.yasinbee.apifirst.order.service;

import com.yasinbee.apifirst.inventory.api.dto.InventoryStatus;
import com.yasinbee.apifirst.inventory.api.dto.InventoryStatusRequest;
import com.yasinbee.apifirst.order.dao.OrderRepository;
import com.yasinbee.apifirst.order.dao.model.Order;
import com.yasinbee.apifirst.order.dto.OrderRequest;
import com.yasinbee.apifirst.order.dto.OrderResponse;
import com.yasinbee.apifirst.order.mapper.OrderMapper;
import com.yasinbee.inventory.api.service.InventoryService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    private final OrderMapper MAPPER = OrderMapper.INSTANCE;
    private final InventoryService inventoryService;
    private final OrderRepository dao;
    private final Map<String, Long> inventoryNameToIdMap = new HashMap<>();

    public OrderServiceImpl(InventoryService inventoryService, OrderRepository dao) {
        this.inventoryService = inventoryService;
        this.dao = dao;
        inventoryNameToIdMap.put("Table", 111L);
        inventoryNameToIdMap.put("Books", 99L);
    }

    @Override
    public OrderResponse placeOrder(OrderRequest request) {
        InventoryStatusRequest inventoryStatusRequest = InventoryStatusRequest.newBuilder()
                .setItemId(inventoryNameToIdMap.get(request.getItem()))
                .build();
        InventoryStatus inventoryStatus =
                inventoryService.getInventoryStatus(inventoryStatusRequest);
        if (enoughItemsAreAvailable(request, inventoryStatus)) {
            return MAPPER.orderModelToResponse(dao.save(MAPPER.orderRequestToModel(request)));
        } else {
            throw new RuntimeException("Only " + inventoryStatus.getAvailableQuantity() + " items" +
                    " are available in stock. Consider reducing the quantity");
        }
    }

    @Override
    public OrderResponse findById(Long orderId) {
        Optional<Order> optionalOrder = dao.findById(orderId);
        if (optionalOrder.isPresent()) {
            return MAPPER.orderModelToResponse(optionalOrder.get());
        } else {
            throw new RuntimeException("Order with the given id not found");
        }
    }

    private boolean enoughItemsAreAvailable(OrderRequest request, InventoryStatus inventoryStatus) {
        return inventoryStatus.getAvailableQuantity() - request.getQuantity() > 0;
    }
}
