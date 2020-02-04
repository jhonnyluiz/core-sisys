package com.jlcabral.core.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jlcabral.core.exception.EnumInvalidException;
import com.jlcabral.core.service.Messages;

@ControllerAdvice
public class ResourceExceptionHandler {

	@Autowired
	private Messages messages;
	
	@ExceptionHandler(EnumInvalidException.class)
	public ResponseEntity<ValidationError> objetoNaoEncontrado(EnumInvalidException e, HttpServletRequest request) {
		ValidationError err = new ValidationError(messages.get(e.getCodeMessage(), e.getParametersMessage()), e.getCodeMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
}
