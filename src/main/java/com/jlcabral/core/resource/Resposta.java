package com.jlcabral.core.resource;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jlcabral.core.resource.exception.CommonError;
import com.jlcabral.core.util.ObjUtil;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class Resposta implements Serializable{
	private static final long serialVersionUID = 5244121347379133730L;

	private Object data;
	private Integer codeError;
	private List<CommonError> errors;
	
	public Boolean asErros() {
		return ObjUtil.isNull(errors) || errors.isEmpty();
	}
	
	public Resposta(Object data, List<CommonError> errors) {
		this.data = data;
		this.errors = errors;	
	}
	
	public Resposta(Object data, List<CommonError> errors, Integer codeError) {
		this.data = data;
		this.errors = errors;
		this.codeError = codeError;
	}
	
	public static Resposta create(Object data, List<CommonError> errors) {
		return new Resposta(data, errors);
	}
	
	public static Resposta create(Object data) {
		return Resposta.create(data, null);
	}
}
