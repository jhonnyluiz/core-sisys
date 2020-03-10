package com.jlcabral.sisys.module.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlcabral.sisys.module.example.domain.dto.ExampleModelDTO;
import com.jlcabral.sisys.module.example.domain.factory.ExampleFactory;
import com.jlcabral.sisys.module.example.domain.model.ExampleModel;
import com.jlcabral.sisys.module.example.repository.ExampleRepository;

@Service
public class ExampleService {

	@Autowired
	protected ExampleRepository repository;	

	public Optional<ExampleModel> findById(Long id) {
		return repository.findById(id);
	}

	public ExampleModel register(ExampleModelDTO dto) {
		return ExampleFactory.mockExample();
	}

	public ExampleModel update(Long id, ExampleModelDTO dto) {
		return ExampleFactory.mockExample();
	}

	public ExampleModel delete(Long id) {
		return ExampleFactory.mockExample();
	}

	public List<ExampleModel> findAll() {
		return repository.findAll();
	}
}
