package com.example.tukai.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tukai.orderservice.service.OrderService;
import com.example.tukai.orderservice.vo.OrderVO;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/order/service")
public class OrderServiceController {
	
	@Autowired
	OrderService orderService;

	@ApiOperation(value = "Get Orders By Customer Name")
	@GetMapping(value = "/getOrdersByCustomerName/{customerName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderVO> getOrdersByCustomerName(@PathVariable String customerName) {
		return orderService.getOrdersByCustomerName(customerName);
	}
	
	@ApiOperation(value = "Get Orders By Order Id")
	@GetMapping(value = "/getOrderByOrderId/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderVO getOrderByOrderId(@PathVariable Long orderId) {
		return orderService.getOrderByOrderId(orderId);
	}
	
	@PostMapping(value = "/saveOrder", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderVO getOrderByOrderId(@RequestBody OrderVO orderVO) {
		return orderService.saveOrder(orderVO);
	}
}
