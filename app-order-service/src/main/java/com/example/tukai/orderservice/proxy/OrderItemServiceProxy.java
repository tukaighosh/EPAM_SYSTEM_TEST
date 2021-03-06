package com.example.tukai.orderservice.proxy;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.tukai.orderservice.vo.OrderItemVO;


@FeignClient(name = "infra-gateway")
public interface OrderItemServiceProxy {

	@GetMapping(value = "/app-order-item-service/order-item/service/order-item/orderId/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderItemVO> getOrderItemByOrderId(@PathVariable("orderId") Long orderId);

	@PostMapping(value = "/app-order-item-service/order-item/service/order-item/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Long saveOrderItem(@RequestBody OrderItemVO orderItem);
}
