package com.order.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFound extends RuntimeException {
	public OrderNotFound(String errorMsg) {
		super(errorMsg);
	}
}
