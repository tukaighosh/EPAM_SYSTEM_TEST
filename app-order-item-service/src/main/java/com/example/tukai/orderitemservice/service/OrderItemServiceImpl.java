package com.example.tukai.orderitemservice.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.tukai.orderitemservice.dao.OrderItemRepository;
import com.example.tukai.orderitemservice.domain.OrderItem;
import com.example.tukai.orderitemservice.exception.OrderItemNotFoundException;
import com.example.tukai.orderitemservice.vo.OrderItemVO;

@Service
public class OrderItemServiceImpl implements OrderItemService{
	@Autowired
	OrderItemRepository orderItemRepo;
	
	@Override
	public OrderItemVO getOrderItemByProductCode(String productCode) {
		OrderItem orderItem = orderItemRepo.findByProductCode(productCode);
		if(orderItem == null) {
			throw new OrderItemNotFoundException("ORDER_ITEM_NOT_FOUND", "Order Item not found for product code "+productCode);
		}
		return mapOrderItemToOrderItemVO(orderItem);
	}
	
	@Override
	public Long saveOrderItem(OrderItem orderItem) {
		OrderItem savedOrderItem = orderItemRepo.saveAndFlush(orderItem);
		return savedOrderItem.getId();
	}

	@Override
	public List<OrderItemVO> getOrderItemByOrderId(Long orderId) {
		List<OrderItem> orderItems = orderItemRepo.findByOrderId(orderId);
		if (CollectionUtils.isEmpty(orderItems)) {
			throw new OrderItemNotFoundException("ORDER_ITEMS_NOT_FOUND",
					"Order Items not found for order id " + orderId);
		}
		return orderItems.stream()
				.map(this::mapOrderItemToOrderItemVO)
				.collect(Collectors.toList());
	}
	
	private OrderItemVO mapOrderItemToOrderItemVO(OrderItem orderItem) {
		OrderItemVO orderItemVO = new OrderItemVO();
		orderItemVO.setOrderId(orderItem.getOrderId());
		orderItemVO.setProductCode(orderItem.getProductCode());
		orderItemVO.setProductName(orderItem.getProductName());
		orderItemVO.setQuantity(orderItem.getQuantity());
		return orderItemVO;
	}
}
