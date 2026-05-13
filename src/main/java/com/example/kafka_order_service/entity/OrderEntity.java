package com.example.kafka_order_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    private String orderId;

    private String customerName;
    private String productName;
    private BigDecimal amount;
    private String status;
    private LocalDateTime createdAt;

    public OrderEntity() {
    }

    public OrderEntity(String orderId, String customerName, String productName,
                       BigDecimal amount, String status, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
    }
}
