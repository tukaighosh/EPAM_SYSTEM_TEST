package com.example.tukai.orderitemservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.tukai.orderitemservice.dao.OrderItemRepository;
import com.example.tukai.orderitemservice.domain.OrderItem;
import com.example.tukai.orderitemservice.service.OrderItemService;
import com.example.tukai.orderitemservice.service.OrderItemServiceImpl;
import com.example.tukai.orderitemservice.vo.OrderItemVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderItemServiceImpl.class)
public class OrderItemServiceTest {

	@Autowired
	private OrderItemService orderItemService;

	@MockBean
	private OrderItemRepository orderItemRepository;

	@Test
	public void saveOrderItemTest() {
		OrderItem orderItem = buildOrderItem();
		Mockito.when(orderItemRepository.saveAndFlush(Mockito.any()))
				.thenReturn(orderItem);
		Long id = orderItemService.saveOrderItem(orderItem);
		assertThat(id).isNotNull();
	}
	
	@Test
	public void getOrderItemByOrderIdTest() {
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		OrderItem orderItem = buildOrderItem();
		orderItems.add(orderItem);
		Mockito.when(orderItemRepository.findByOrderId(Mockito.anyLong()))
				.thenReturn(orderItems);
		List<OrderItemVO> responseList = orderItemService.getOrderItemByOrderId(1L);
		assertThat(responseList).isNotNull();
		assertThat(responseList).isNotEmpty();
	}
	
	@Test
	public void getOrderItemByProductCodeTest() {
		OrderItem orderItem = buildOrderItem();
		Mockito.when(orderItemRepository.findByProductCode(Mockito.anyString()))
				.thenReturn(orderItem);
		OrderItemVO response = orderItemService.getOrderItemByProductCode("P-1");
		assertThat(response).isNotNull();
	}
	
	private OrderItem buildOrderItem() {
		OrderItem orderItem = new OrderItem();
		orderItem.setId(1L);
		orderItem.setOrderId(1L);
		orderItem.setProductCode("P-1");
		orderItem.setProductName("Product 1");
		orderItem.setQuantity(100.50);
		return orderItem;
	}
}
