package com.yasinbee.apifirst.order.service;

import com.yasinbee.apifirst.order.dto.OrderRequest;
import com.yasinbee.apifirst.order.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest request);

    OrderResponse findById(Long orderId);
}
