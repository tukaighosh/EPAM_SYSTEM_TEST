package com.example.tukai.orderservice.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Customer name must not be null")
	private String customerName;
	@NotNull(message = "Shipping address must not be null")
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
	}
}
