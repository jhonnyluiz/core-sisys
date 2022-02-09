package com.jlcabral.csm.service;

import org.springframework.stereotype.Service;

import com.jlcabral.core.service.AppCrudService;
import com.jlcabral.csm.entity.SistemaModulo;
import com.jlcabral.csm.repository.SistemaModuloRepository;

@Service
public class SistemaModuloService extends AppCrudService<SistemaModuloRepository, SistemaModulo, Long> {

	@Override
	protected SistemaModulo toUpdateValue(SistemaModulo entity, SistemaModulo entityDB) {
		return entityDB;
	}

}
