package com.example.kafka_order_service.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderCreatedEvent(
        String orderId,
        String customerName,
        String productName,
        BigDecimal amount,
        LocalDateTime createdAt
) {
}
