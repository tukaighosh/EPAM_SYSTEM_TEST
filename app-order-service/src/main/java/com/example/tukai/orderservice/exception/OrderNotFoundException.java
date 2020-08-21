package com.example.tukai.orderservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;
}
