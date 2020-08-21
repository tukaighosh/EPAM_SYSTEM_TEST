package com.example.tukai.orderitemservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tukai.orderitemservice.dao.OrderItemRepository;
import com.example.tukai.orderitemservice.domain.OrderItem;

@Service
public class OrderItemServiceImpl implements OrderItemService{
	@Autowired
	OrderItemRepository orderItemRepo;
	
	@Override
	public OrderItem getOrderItemByProductCode(String productCode) {
		return orderItemRepo.findByProductCode(productCode);
	}
	
	@Override
	public Long saveOrderItem(OrderItem orderItem) {
		OrderItem savedOrderItem = orderItemRepo.saveAndFlush(orderItem);
		return savedOrderItem.getId();
	}

	@Override
	public List<OrderItem> getOrderItemByOrderId(Long orderId) {
		return orderItemRepo.findByOrderId(orderId);
	}
}
