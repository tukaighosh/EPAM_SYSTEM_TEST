package com.example.tukai.orderservice.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderVO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String customerName;
	private Date orderDate;
	private String shippingAdrress;
	private List<OrderItem> orderItems;
	private Double total;
	
	@Getter
	@Setter
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class OrderItem implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private String productCode;
		private String productName;
		private Double quantity;
		private Long orderId;
	}
}
