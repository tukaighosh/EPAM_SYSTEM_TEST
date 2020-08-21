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
import com.example.tukai.orderservice.vo.OrderVO;
import com.example.tukai.orderservice.vo.OrderVO.OrderItem;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderItemServiceProxy orderItemServiceProxy;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Override
	public List<OrderVO> getOrdersByCustomerName(String customerName) {
		List<OrderVO> orderVOs = new ArrayList<>();
		List<Order> orders = orderRepo.findByCustomerName(customerName);
		if(!CollectionUtils.isEmpty(orders)) {
			orders.stream().forEach(order -> {
				OrderVO orderVO = new OrderVO();
				orderVO.setCustomerName(order.getCustomerName());
				orderVO.setOrderDate(order.getOrderDate());
				orderVO.setShippingAdrress(order.getShippingAdrress());
				orderVO.setTotal(order.getTotal());
				List<OrderItem> orderItems = orderItemServiceProxy.getOrderItems(order.getId());
				orderVO.setOrderItems(orderItems);
				orderVOs.add(orderVO);
			});
		}
		return orderVOs;
	}

	@Override
	public OrderVO getOrderByOrderId(Long orderId) {
		OrderVO orderVO = new OrderVO();
		Order order = orderRepo.findOne(orderId);
		if (order != null) {
			orderVO.setCustomerName(order.getCustomerName());
			orderVO.setOrderDate(order.getOrderDate());
			orderVO.setShippingAdrress(order.getShippingAdrress());
			orderVO.setTotal(order.getTotal());
			List<OrderItem> orderItems = orderItemServiceProxy.getOrderItems(order.getId());
			orderVO.setOrderItems(orderItems);
		}
		return orderVO;
	}

	@Override
	public OrderVO saveOrder(OrderVO orderVO) {
		Order order = new Order();
		order.setCustomerName(orderVO.getCustomerName());
		order.setOrderDate(new Date());
		order.setShippingAdrress(order.getShippingAdrress());
		order.setTotal(orderVO.getTotal());
		Order savedOrder = orderRepo.save(order);
		if(!CollectionUtils.isEmpty(orderVO.getOrderItems())) {
			orderVO.getOrderItems().stream().forEach(orderItem -> {
				orderItem.setOrderId(savedOrder.getId());
				orderItemServiceProxy.addOrderItem(orderItem);
			});
		}
		return orderVO;
	}

}
