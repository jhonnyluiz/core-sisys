package com.jlcabral.sisys.example.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlcabral.core.enumerated.TypeGenderEnum;
import com.jlcabral.sisys.example.domain.model.ExampleModel;
import com.jlcabral.sisys.example.domain.model.ExampleModelDTO;

@RestController
@RequestMapping(path = "example")
public class ExampleResource {

	@PostMapping
	public ExampleModel getMessage(@RequestBody ExampleModelDTO dto) {
		return new ExampleModel(TypeGenderEnum.toEnum(dto.codTypeGender));
//		return messages.get(msg, "teste");
	}
}
