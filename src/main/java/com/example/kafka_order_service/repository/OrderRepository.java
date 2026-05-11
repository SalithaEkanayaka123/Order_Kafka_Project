package com.example.kafka_order_service.repository;

import com.example.kafka_order_service.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {
}
