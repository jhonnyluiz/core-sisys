package com.jlcabral.sisys.example.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlcabral.core.enumerated.TypeGenderEnum;
import com.jlcabral.sisys.example.domain.dto.ExampleModelDTO;
import com.jlcabral.sisys.example.domain.factory.MaleNameFactory;
import com.jlcabral.sisys.example.domain.model.ExampleModel;

@RestController
@RequestMapping(path = "example")
public class ExampleResource {

	@PostMapping
	public ExampleModel getMessage(@RequestBody ExampleModelDTO dto) {
		return new ExampleModel(TypeGenderEnum.toEnum(dto.codTypeGender));
//		return messages.get(msg, "teste");
	}

	@GetMapping
	public ResponseEntity<List<String>> listarTodos() {
		return ResponseEntity.ok(new MaleNameFactory().listFullNames(5));
	}
}
