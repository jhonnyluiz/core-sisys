package com.jlcabral.sisys.module.example.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlcabral.core.resource.AppCrudResource;
import com.jlcabral.sisys.module.example.domain.dto.ExampleModelDTO;
import com.jlcabral.sisys.module.example.domain.model.ExampleModel;
import com.jlcabral.sisys.module.example.repository.ExampleRepository;
import com.jlcabral.sisys.module.example.service.ExampleService;

@RestController
@RequestMapping(path = "example")
public class ExampleResource
		extends AppCrudResource<ExampleService, ExampleRepository, ExampleModelDTO, ExampleModel, Long> {

}
