package com.example.tukai.orderitemservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tukai.orderitemservice.domain.OrderItem;
import com.example.tukai.orderitemservice.vo.OrderItemVO;

@Service
public interface OrderItemService {

	public OrderItemVO getOrderItemByProductCode(String productCode);
	
	public Long saveOrderItem(OrderItem orderItem);
	
	public List<OrderItemVO> getOrderItemByOrderId(Long orderId);
}
