package com.example.tukai.orderitemservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.tukai.orderitemservice.dao.OrderItemRepository;
import com.example.tukai.orderitemservice.domain.OrderItem;
import com.example.tukai.orderitemservice.exception.OrderItemNotFoundException;

@Service
public class OrderItemServiceImpl implements OrderItemService{
	@Autowired
	OrderItemRepository orderItemRepo;
	
	@Override
	public OrderItem getOrderItemByProductCode(String productCode) {
		OrderItem orderItem = orderItemRepo.findByProductCode(productCode);
		if(orderItem == null) {
			throw new OrderItemNotFoundException("ORDER_ITEM_NOT_FOUND", "Order Item not found for product code "+productCode);
		}
		return orderItem;
	}
	
	@Override
	public Long saveOrderItem(OrderItem orderItem) {
		OrderItem savedOrderItem = orderItemRepo.saveAndFlush(orderItem);
		return savedOrderItem.getId();
	}

	@Override
	public List<OrderItem> getOrderItemByOrderId(Long orderId) {
		List<OrderItem> orderItems = orderItemRepo.findByOrderId(orderId);
		if(CollectionUtils.isEmpty(orderItems)) {
			throw new OrderItemNotFoundException("ORDER_ITEMS_NOT_FOUND", "Order Items not found for order id "+orderId);
		}
		return orderItems;
	}
}
