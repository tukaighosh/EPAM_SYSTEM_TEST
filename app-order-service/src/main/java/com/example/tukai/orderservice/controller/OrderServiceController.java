package com.example.tukai.orderservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tukai.orderservice.service.OrderService;
import com.example.tukai.orderservice.vo.OrderRequest;
import com.example.tukai.orderservice.vo.OrderResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/order/service")
public class OrderServiceController {
	
	@Autowired
	OrderService orderService;

	@ApiOperation(value = "Get Orders By Customer Name")
	@GetMapping(value = "/orders/customerName/{customerName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderResponse> getOrdersByCustomerName(@PathVariable String customerName) {
		return orderService.getOrdersByCustomerName(customerName);
	}
	
	@ApiOperation(value = "Get Orders By Order Id")
	@GetMapping(value = "/order/id/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse getOrderByOrderId(@PathVariable Long orderId) {
		return orderService.getOrderByOrderId(orderId);
	}
	
	@PostMapping(value = "/order/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public Long saveOrder(@Valid @RequestBody OrderRequest orderVO) {
		return orderService.saveOrder(orderVO);
	}
}
