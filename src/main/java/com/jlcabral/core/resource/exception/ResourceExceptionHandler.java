package com.jlcabral.core.resource.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.jlcabral.core.exception.EnumInvalidException;
import com.jlcabral.core.exception.ObjectNotFoundException;
import com.jlcabral.core.service.BusinessMessages;

@ControllerAdvice
public class ResourceExceptionHandler {

	@Autowired
	private BusinessMessages messages;

	@ExceptionHandler(EnumInvalidException.class)
	public ResponseEntity<DevelopError> enumInvalido(EnumInvalidException e, HttpServletRequest request) {
		String msg = messages.get(e.getCodeMessage(), e.getParametersMessage());
		DevelopError err = new DevelopError(msg, e.getCodeMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<DevelopError> objetoNaoEncontrado(ObjectNotFoundException e, HttpServletRequest request) {
		String msg = messages.get(e.getCodeMessage(), e.getParametersMessage());
		DevelopError err = new DevelopError(msg, e.getCodeMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<DevelopError> objetoNaoEncontrado(InvalidFormatException e, HttpServletRequest request) {
		DevelopError err = new DevelopError(e.getMessage(), "InvalidFormatException");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ValidationError>> objetoNaoEncontrado(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		List<ValidationError> listErros = new ArrayList<ValidationError>();
		for (FieldError fieldError : e.getFieldErrors()) {
			listErros.add(new ValidationError(fieldError.getDefaultMessage(), fieldError.getCode(),
					fieldError.getField(), fieldError.getRejectedValue().toString(), fieldError.getObjectName(),
					Arrays.asList(fieldError.getCodes())));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listErros);
	}

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<CommonError> invalideCredential(InvalidCredentialsException e, HttpServletRequest request) {
		CommonError err = new CommonError(e.getMessage(), e.getCodeMessage(), e.getTypeMessage(), e.getDevelopError());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}
	
	@ExceptionHandler(TokenExpiredException.class)
	public ResponseEntity<CommonError> tokenExpired(TokenExpiredException e, HttpServletRequest request) {
		CommonError err = new CommonError(e.getMessage(), e.getCodeMessage(), e.getTypeMessage(), e.getDevelopError());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}
	
	@ExceptionHandler(TokenInvalidException.class)
	public ResponseEntity<CommonError> tokenInvalid(TokenInvalidException e, HttpServletRequest request) {
		CommonError err = new CommonError(e.getMessage(), e.getCodeMessage(), e.getTypeMessage(), e.getDevelopError());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}
	
	@ExceptionHandler(UserDisabledCredentialsException.class)
	public ResponseEntity<CommonError> userDisabled(UserDisabledCredentialsException e, HttpServletRequest request) {
		CommonError err = new CommonError(e.getMessage(), e.getCodeMessage(), e.getTypeMessage(), e.getDevelopError());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}
}
