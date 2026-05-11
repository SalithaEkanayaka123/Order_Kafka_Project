package com.example.kafka_order_service.service;

import com.example.kafka_order_service.dto.OrderRequest;
import com.example.kafka_order_service.event.OrderCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderService {

    private static final String TOPIC = "order-created-topic";
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public OrderService(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
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
}
