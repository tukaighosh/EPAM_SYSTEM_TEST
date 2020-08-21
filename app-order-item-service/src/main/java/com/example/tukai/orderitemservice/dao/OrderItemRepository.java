package com.example.tukai.orderitemservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tukai.orderitemservice.domain.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	OrderItem findByProductCode(String productCode);
	
	List<OrderItem> findByOrderId(Long orderId);
}
