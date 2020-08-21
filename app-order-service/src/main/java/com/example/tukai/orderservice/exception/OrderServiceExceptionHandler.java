package com.example.tukai.orderservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class OrderServiceExceptionHandler 
		extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { OrderNotFoundException.class })
	protected ResponseEntity<Object> handleOrderNotFoundException(OrderNotFoundException ex, WebRequest request) {
		log.error("System encountered exception while completing the request");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(OrderExceptionResponse.builder()
						.errorCode(ex.getErrorCode())
						.errorMessage(ex.getErrorMessage())
						.timestamp(new Date())
						.build());
	}
	
	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
		log.error("System encountered exception while completing the request");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(OrderExceptionResponse.builder()
						.errorCode(HttpStatus.INTERNAL_SERVER_ERROR.name())
						.errorMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
						.timestamp(new Date())
						.build());
	}
}
