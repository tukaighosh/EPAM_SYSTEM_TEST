package com.example.tukai.orderitemservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tukai.orderitemservice.domain.OrderItem;

@Service
public interface OrderItemService {

	public OrderItem getOrderItemByProductCode(String productCode);
	
	public OrderItem saveOrderItem(OrderItem orderItem);
	
	public List<OrderItem> getOrderItemByOrderId(Long orderId);
}
