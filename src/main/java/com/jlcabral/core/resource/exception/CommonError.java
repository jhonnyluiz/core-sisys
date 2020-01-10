package com.jlcabral.core.resource.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jlcabral.core.enumerated.TypeMessageExceptionEnum;

@JsonInclude(Include.NON_EMPTY)
public class CommonError implements Serializable {
	private static final long serialVersionUID = -3300853501428127763L;

	private String message;
	private String codeMessage;
	private TypeMessageExceptionEnum typeMessage;

	public CommonError(String message, String codeMessage, TypeMessageExceptionEnum typeMessage) {
		this.message = message;
		this.codeMessage = codeMessage;
		this.typeMessage = typeMessage;
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

}
