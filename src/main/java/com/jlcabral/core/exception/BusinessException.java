package com.jlcabral.core.exception;

import com.jlcabral.core.enumerated.TypeMessageExceptionEnum;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 7139506938542051826L;

	private TypeMessageExceptionEnum typeMessage;
	private String codeMessage;
	private String message;
	private Object[] parametersMessage;

	public BusinessException(TypeMessageExceptionEnum typeMessage, String codeMessage, String message,
			Object... parametersMessage) {
		this.message = message;
		this.codeMessage = codeMessage;
		this.typeMessage = typeMessage;
		this.parametersMessage = parametersMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCodeMessage() {
		return codeMessage;
	}

	public void setCodeMessage(String codeMessage) {
		this.codeMessage = codeMessage;
	}

	public TypeMessageExceptionEnum getTypeMessage() {
		return typeMessage;
	}

	public void setTypeMessage(TypeMessageExceptionEnum typeMessage) {
		this.typeMessage = typeMessage;
	}

	public Object[] getParametersMessage() {
		return parametersMessage;
	}

	public void setParametersMessage(Object[] parametersMessage) {
		this.parametersMessage = parametersMessage;
	}

}
