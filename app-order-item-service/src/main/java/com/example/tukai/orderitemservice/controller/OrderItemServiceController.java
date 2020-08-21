package com.example.tukai.orderitemservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tukai.orderitemservice.domain.OrderItem;
import com.example.tukai.orderitemservice.service.OrderItemService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order-item/service")
public class OrderItemServiceController {
	@Autowired
	OrderItemService orderItemService;

	@ApiOperation(value = "Get Order Item by product code")
	@GetMapping(value = "/getOrderItemByProductCode/{productCode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderItem getOrderItemByProductCode(@PathVariable String productCode) {
		return orderItemService.getOrderItemByProductCode(productCode);
	}
	
	@ApiOperation(value = "Get Order Item by order id")
	@GetMapping(value = "/getOrderItemByOrderId/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderItem> getOrderItemByOrderId(@PathVariable Long orderId) {
		return orderItemService.getOrderItemByOrderId(orderId);
	}

	@ApiOperation(value = "Save Order Item")
	@PostMapping(value = "/addOrderItem", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Long addOrderItem(@RequestBody OrderItem orderItem) {
		return orderItemService.saveOrderItem(orderItem);
	}

}
