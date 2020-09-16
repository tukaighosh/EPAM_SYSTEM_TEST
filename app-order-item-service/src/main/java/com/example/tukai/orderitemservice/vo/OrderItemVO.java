package com.example.tukai.orderitemservice.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String productCode;
	private String productName;
	private Double quantity;
	private Long orderId;
}
