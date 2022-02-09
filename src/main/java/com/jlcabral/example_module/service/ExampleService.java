package com.jlcabral.example_module.service;

import org.springframework.stereotype.Service;

import com.jlcabral.core.service.AppCrudService;
import com.jlcabral.example_module.entity.ExampleModel;
import com.jlcabral.example_module.repository.ExampleRepository;

@Service
public class ExampleService extends AppCrudService<ExampleRepository, ExampleModel, Long> {

	@Override
	protected ExampleModel toUpdateValue(ExampleModel entity, ExampleModel entityDB) {
		entityDB.setGenero(entity.getGenero());
		entityDB.setNameExample(entity.getNameExample());
		entityDB.setNumberExample(entity.getNumberExample());
		return entityDB;
	}

}
