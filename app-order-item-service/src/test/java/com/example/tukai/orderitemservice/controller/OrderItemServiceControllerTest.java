package com.example.tukai.orderitemservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.tukai.orderitemservice.controller.OrderItemServiceController;
import com.example.tukai.orderitemservice.domain.OrderItem;
import com.example.tukai.orderitemservice.service.OrderItemService;
import com.example.tukai.orderitemservice.vo.OrderItemVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderItemServiceController.class)
public class OrderItemServiceControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private OrderItemService orderItemService;

	@Test
	public void addOrderItemTest() throws Exception {
		Mockito.when(orderItemService.saveOrderItem(Mockito.any(OrderItem.class))).thenReturn(1L);
		OrderItemVO orderItem = buildOrderItem();
		mvc.perform(MockMvcRequestBuilders.post("/order-item/service/addOrderItem")
				.content(new ObjectMapper().writeValueAsString(orderItem)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void getOrderItemByOrderIdTest() throws Exception {
		List<OrderItemVO> orderItems = new ArrayList<OrderItemVO>();
		OrderItemVO orderItem = buildOrderItem();
		orderItems.add(orderItem);
		Mockito.when(orderItemService.getOrderItemByOrderId(Mockito.anyLong())).thenReturn(orderItems);
		mvc.perform(MockMvcRequestBuilders.get("/order-item/service/getOrderItemByOrderId/{orderId}", 1L)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void getOrderItemByProductCodeTest() throws Exception {
		OrderItemVO orderItem = buildOrderItem();
		Mockito.when(orderItemService.getOrderItemByProductCode(Mockito.anyString())).thenReturn(orderItem);
		mvc.perform(MockMvcRequestBuilders.get("/order-item/service/getOrderItemByProductCode/{productCode}", "P-1")
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	private OrderItemVO buildOrderItem() {
		OrderItemVO orderItem = new OrderItemVO();
		orderItem.setOrderId(1L);
		orderItem.setProductCode("P-1");
		orderItem.setProductName("Product 1");
		orderItem.setQuantity(100.50);
		return orderItem;
	}
}
