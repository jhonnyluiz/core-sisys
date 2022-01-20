package com.jlcabral.core.resource.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jlcabral.core.enumerated.TypeMessageExceptionEnum;

@JsonInclude(Include.NON_EMPTY)
public class ValidationError extends CommonError {
	private static final long serialVersionUID = 3280678078473975742L;

	private String nameField;
	private String valueField;
	private String typeField;
	private List<?> valuesExpecteds;

	public ValidationError(String message, String codeMessage) {
		super(message, codeMessage, TypeMessageExceptionEnum.E);
	}

	public ValidationError(String message, String codeMessage, String nameField, String valueField, String typeField,
			List<?> valuesExpecteds) {
		super(message, codeMessage, TypeMessageExceptionEnum.E);
		this.nameField = nameField;
		this.valueField = valueField;
		this.typeField = typeField;
		this.valuesExpecteds = valuesExpecteds;
	}

	public String getNameField() {
		return nameField;
	}

	public void setNameField(String nameField) {
		this.nameField = nameField;
	}

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public List<?> getValuesExpecteds() {
		return valuesExpecteds;
	}

	public void setValuesExpecteds(List<?> valuesExpecteds) {
		this.valuesExpecteds = valuesExpecteds;
	}

	public String getTypeField() {
		return typeField;
	}

	public void setTypeField(String typeField) {
		this.typeField = typeField;
	}

}
