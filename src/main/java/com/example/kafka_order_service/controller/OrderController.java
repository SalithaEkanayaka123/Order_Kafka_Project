package com.example.kafka_order_service.controller;

import com.example.kafka_order_service.dto.OrderRequest;
import com.example.kafka_order_service.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Map<String, String> createOrder(@RequestBody OrderRequest request) {
        String orderId = orderService.createOrder(request);

        return Map.of(
                "message", "Order event published successfully",
                "orderId", orderId
        );
    }
}
