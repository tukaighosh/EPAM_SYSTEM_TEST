package com.example.tukai.orderservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tukai.orderservice.vo.OrderVO;

@Service
public interface OrderService {

	public List<OrderVO> getOrdersByCustomerName(String customerName);
	
	public OrderVO getOrderByOrderId(Long orderId);
	
	public OrderVO saveOrder(OrderVO orderVO);
}
