package com.example.tukai.orderitemservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;
}
