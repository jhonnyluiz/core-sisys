package com.jlcabral.example_module.dto;

import javax.validation.constraints.NotBlank;

import com.jlcabral.core.dto.AppDTO;
import com.jlcabral.core.enumerated.TypeGenderEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExampleModelDTO extends AppDTO {
	private static final long serialVersionUID = 2951907880550851944L;

	private Long id;
	@NotBlank(message = "O campo nameExample é obrigatório")
	private String nameExample;
	private Integer numberExample;
	private TypeGenderEnum genero;
}
