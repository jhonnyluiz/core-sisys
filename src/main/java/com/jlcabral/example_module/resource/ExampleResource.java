package com.jlcabral.example_module.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlcabral.core.resource.AppCrudResource;
import com.jlcabral.example_module.dto.ExampleModelDTO;
import com.jlcabral.example_module.entity.ExampleModel;
import com.jlcabral.example_module.repository.ExampleRepository;
import com.jlcabral.example_module.service.ExampleService;

@RestController
@RequestMapping(path = "example")
public class ExampleResource
		extends AppCrudResource<ExampleService, ExampleRepository, ExampleModelDTO, ExampleModel, Long> {

}
