package com.order.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidUserFound extends RuntimeException {
	public InvalidUserFound(String errMsg){
		super(errMsg);
	}
}
