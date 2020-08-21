package com.example.tukai.orderservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.tukai.orderservice.dao.OrderRepository;
import com.example.tukai.orderservice.domain.Order;
import com.example.tukai.orderservice.proxy.OrderItemServiceProxy;
import com.example.tukai.orderservice.vo.OrderItemVO;
import com.example.tukai.orderservice.vo.OrderRequest;
import com.example.tukai.orderservice.vo.OrderResponse;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderItemServiceProxy orderItemServiceProxy;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Override
	public List<OrderResponse> getOrdersByCustomerName(String customerName) {
		List<OrderResponse> orderVOs = new ArrayList<>();
		List<Order> orders = orderRepo.findByCustomerName(customerName);
		if(!CollectionUtils.isEmpty(orders)) {
			orders.stream().forEach(order -> {
				OrderResponse orderVO = new OrderResponse();
				orderVO.setCustomerName(order.getCustomerName());
				orderVO.setOrderDate(order.getOrderDate());
				orderVO.setShippingAdrress(order.getShippingAdrress());
				orderVO.setTotal(order.getTotal());
				List<OrderItemVO> orderItems = orderItemServiceProxy.getOrderItems(order.getId());
				orderVO.setOrderItems(orderItems);
				orderVOs.add(orderVO);
			});
		}
		return orderVOs;
	}

	@Override
	public OrderResponse getOrderByOrderId(Long orderId) {
		OrderResponse orderVO = new OrderResponse();
		Order order = orderRepo.findOne(orderId);
		if (order != null) {
			orderVO.setCustomerName(order.getCustomerName());
			orderVO.setOrderDate(order.getOrderDate());
			orderVO.setShippingAdrress(order.getShippingAdrress());
			orderVO.setTotal(order.getTotal());
			List<OrderItemVO> orderItems = orderItemServiceProxy.getOrderItems(order.getId());
			orderVO.setOrderItems(orderItems);
		}
		return orderVO;
	}

	@Override
	public Long saveOrder(OrderRequest orderVO) {
		Order order = new Order();
		order.setCustomerName(orderVO.getCustomerName());
		order.setOrderDate(new Date());
		order.setShippingAdrress(order.getShippingAdrress());
		order.setTotal(orderVO.getTotal());
		Order savedOrder = orderRepo.save(order);
		if(!CollectionUtils.isEmpty(orderVO.getOrderItems())) {
			orderVO.getOrderItems().stream().forEach(orderItem -> {
				OrderItemVO orderItemVO = new OrderItemVO();
				orderItemVO.setOrderId(savedOrder.getId());
				orderItemVO.setProductCode(orderItem.getProductCode());
				orderItemVO.setProductName(orderItem.getProductName());
				orderItemVO.setQuantity(orderItem.getQuantity());
				orderItemServiceProxy.addOrderItem(orderItemVO);
			});
		}
		return savedOrder.getId();
	}

}
