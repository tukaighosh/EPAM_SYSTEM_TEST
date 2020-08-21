package com.example.tukai.orderservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tukai.orderservice.vo.OrderRequest;
import com.example.tukai.orderservice.vo.OrderResponse;

@Service
public interface OrderService {

	public List<OrderResponse> getOrdersByCustomerName(String customerName);
	
	public OrderResponse getOrderByOrderId(Long orderId);
	
	public Long saveOrder(OrderRequest orderVO);
}
