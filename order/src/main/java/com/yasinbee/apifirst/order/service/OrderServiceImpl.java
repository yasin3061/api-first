package com.yasinbee.apifirst.order.service;

import com.yasinbee.apifirst.order.dao.OrderRepository;
import com.yasinbee.apifirst.order.dao.model.Order;
import com.yasinbee.apifirst.order.dto.OrderRequest;
import com.yasinbee.apifirst.order.dto.OrderResponse;
import com.yasinbee.apifirst.order.mapper.OrderMapper;

import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    private final OrderMapper MAPPER = OrderMapper.INSTANCE;
    private final OrderRepository dao;

    public OrderServiceImpl(OrderRepository dao) {
        this.dao = dao;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest request) {
        return MAPPER.orderModelToResponse(dao.save(MAPPER.orderRequestToModel(request)));
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
}
