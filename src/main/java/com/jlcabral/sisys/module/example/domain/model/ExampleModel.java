package com.jlcabral.sisys.module.example.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jlcabral.core.enumerated.TypeGenderEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExampleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nameExample;
	private Integer numberExample;
	private TypeGenderEnum genero;

	public ExampleModel setGenero(TypeGenderEnum genero) {
		this.genero = genero;
		return this;
	}

}
