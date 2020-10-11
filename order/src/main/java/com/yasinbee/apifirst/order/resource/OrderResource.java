package com.yasinbee.apifirst.order.resource;

import com.yasinbee.apifirst.order.dto.OrderRequest;
import com.yasinbee.apifirst.order.dto.OrderResponse;
import com.yasinbee.apifirst.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class OrderResource {
    private final OrderService orderService;

    @Autowired
    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public OrderResponse placeOrder(@RequestBody OrderRequest newOrderRequest) {
        return orderService.placeOrder(newOrderRequest);
    }

    @GetMapping("/orders/{id}")
    public OrderResponse findOrder(@PathVariable("id") Long orderId) {
        return orderService.findById(orderId);
    }
}
