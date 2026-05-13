package com.example.kafka_order_service.service;

import com.example.kafka_order_service.dto.OrderRequest;
import com.example.kafka_order_service.entity.OrderEntity;
import com.example.kafka_order_service.event.OrderCreatedEvent;
import com.example.kafka_order_service.repository.OrderRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private static final String TOPIC = "order-created-topic";
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;
    private final OrderRepository orderRepository;

    public OrderService(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate, OrderRepository orderRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.orderRepository = orderRepository;
    }

    public String createOrder(OrderRequest orderRequest){
        String orderId = UUID.randomUUID().toString();

        OrderCreatedEvent event = new OrderCreatedEvent(
                orderId,
                orderRequest.customerName(),
                orderRequest.productName(),
                orderRequest.amount(),
                LocalDateTime.now()
        );

        kafkaTemplate.send(TOPIC, orderId, event);

        return orderId;
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }
}
