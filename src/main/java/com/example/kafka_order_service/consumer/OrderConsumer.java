package com.example.kafka_order_service.consumer;

import com.example.kafka_order_service.entity.OrderEntity;
import com.example.kafka_order_service.event.OrderCreatedEvent;
import com.example.kafka_order_service.repository.OrderRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private final OrderRepository orderRepository;

    public OrderConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "order-created-topic", groupId = "order-service-group")
    public void consume(OrderCreatedEvent event) {
        OrderEntity order = new OrderEntity(
                event.orderId(),
                event.customerName(),
                event.productName(),
                event.amount(),
                "PROCESSED",
                event.createdAt()
        );

        orderRepository.save(order);

        System.out.println("Order processed successfully: " + event.orderId());
    }
}
