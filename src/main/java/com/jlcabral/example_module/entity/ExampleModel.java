package com.jlcabral.example_module.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jlcabral.core.entity.AppEntity;
import com.jlcabral.core.enumerated.TypeGenderEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExampleModel extends AppEntity<Long> {
	private static final long serialVersionUID = -149194150168965195L;

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
