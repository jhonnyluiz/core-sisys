package com.jlcabral.sisys.module.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlcabral.core.resource.Resposta;
import com.jlcabral.sisys.module.example.domain.dto.ExampleModelDTO;
import com.jlcabral.sisys.module.example.domain.factory.ExampleFactory;
import com.jlcabral.sisys.module.example.domain.model.ExampleModel;
import com.jlcabral.sisys.module.example.service.ExampleService;

@RestController
@RequestMapping(path = "example")
public class ExampleResource {

	@Autowired
	private ExampleService service;

	@GetMapping
	public ResponseEntity<Resposta> listAll() {
		return ResponseEntity.ok(Resposta.create(service.findAll()));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<ExampleModel> findById(@PathVariable Long id) {
		return ResponseEntity.ok(ExampleFactory.mockExample());
	}

	@PostMapping
	public ResponseEntity<ExampleModel> objectRegister(@RequestBody ExampleModelDTO dto) {
		return ResponseEntity.ok(ExampleFactory.mockExample());
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<ExampleModel> objectUpdate(@PathVariable Long id, @RequestBody ExampleModelDTO dto) {
		return ResponseEntity.ok(ExampleFactory.mockExample());
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Long> objectDelete(@PathVariable Long id) {
		return ResponseEntity.ok(id);
	}

}
