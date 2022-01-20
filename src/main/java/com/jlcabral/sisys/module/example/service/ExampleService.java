package com.jlcabral.sisys.module.example.service;

import org.springframework.stereotype.Service;

import com.jlcabral.core.service.AppCrudService;
import com.jlcabral.sisys.module.example.domain.model.ExampleModel;
import com.jlcabral.sisys.module.example.repository.ExampleRepository;

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
