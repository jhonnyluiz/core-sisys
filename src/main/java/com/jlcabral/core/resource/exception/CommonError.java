package com.jlcabral.core.resource.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jlcabral.core.enumerated.TypeMessageExceptionEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
public class CommonError implements Serializable {
	private static final long serialVersionUID = -3300853501428127763L;

	private String message;
	private String codeMessage;
	private TypeMessageExceptionEnum typeMessage;
	private Boolean developError;

	public CommonError(String message, String codeMessage, TypeMessageExceptionEnum typeMessage) {
		this.message = message;
		this.codeMessage = codeMessage;
		this.typeMessage = typeMessage;
	}
}
