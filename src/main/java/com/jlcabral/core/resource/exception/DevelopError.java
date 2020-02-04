package com.jlcabral.core.resource.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jlcabral.core.enumerated.TypeMessageExceptionEnum;

@JsonInclude(Include.NON_EMPTY)
public class DevelopError extends CommonError {
	private static final long serialVersionUID = -79058443973763595L;

	public DevelopError(String message, String codeMessage) {
		super(message, codeMessage, TypeMessageExceptionEnum.E);
		setDevelopError(Boolean.TRUE);
	}

}
