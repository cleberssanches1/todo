package com.valdir.todo.resource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.valdir.todo.service.exception.ObjectNotFoundException;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4011945319085937650L;

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, ServletRequest request) {

		StandardError standardError = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
	}

}
