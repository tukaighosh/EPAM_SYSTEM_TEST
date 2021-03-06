package com.example.tukai.orderitemservice.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemExceptionResponse {

	private String errorCode;
	private String errorMessage;
	private Date timestamp;
}
