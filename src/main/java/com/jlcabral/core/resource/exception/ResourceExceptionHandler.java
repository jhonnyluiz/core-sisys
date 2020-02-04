package com.jlcabral.core.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jlcabral.core.exception.EnumInvalidException;
import com.jlcabral.core.service.BusinessMessages;

@ControllerAdvice
public class ResourceExceptionHandler {

	@Autowired
	private BusinessMessages messages;
	
	@ExceptionHandler(EnumInvalidException.class)
	public ResponseEntity<DevelopError> objetoNaoEncontrado(EnumInvalidException e, HttpServletRequest request) {
		String msg = messages.get(e.getCodeMessage(), e.getParametersMessage());
		DevelopError err = new DevelopError(msg, e.getCodeMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
}
