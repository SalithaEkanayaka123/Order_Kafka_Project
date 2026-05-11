package com.example.kafka_order_service.dto;

import java.math.BigDecimal;

public record OrderRequest(String customerName, String productName, BigDecimal amount) {
}
