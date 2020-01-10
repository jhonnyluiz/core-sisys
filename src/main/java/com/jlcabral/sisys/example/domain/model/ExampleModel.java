package com.jlcabral.sisys.example.domain.model;

import com.jlcabral.core.enumerated.TypeGenderEnum;

public class ExampleModel {

	private TypeGenderEnum genero;

	public ExampleModel() {
	}

	public ExampleModel(TypeGenderEnum genero) {
		super();
		this.genero = genero;
	}

	public TypeGenderEnum getGenero() {
		return genero;
	}

	public void setGenero(TypeGenderEnum genero) {
		this.genero = genero;
	}

}
