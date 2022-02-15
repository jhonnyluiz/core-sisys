package com.jlcabral.auth.resource.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jlcabral.auth.resource.exceptions.InvalidCredentialsException;
import com.jlcabral.auth.resource.exceptions.UserDisabledCredentialsException;
import com.jlcabral.core.resource.exception.CommonError;

@ControllerAdvice
public class AuthHandlerResource {

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<CommonError> invalideCredential(InvalidCredentialsException e, HttpServletRequest request) {
		CommonError err = new CommonError(e.getMessage(), e.getCodeMessage(), e.getTypeMessage(), e.getDevelopError());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}
	
	@ExceptionHandler(UserDisabledCredentialsException.class)
	public ResponseEntity<CommonError> userDisabled(UserDisabledCredentialsException e, HttpServletRequest request) {
		CommonError err = new CommonError(e.getMessage(), e.getCodeMessage(), e.getTypeMessage(), e.getDevelopError());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}
}
