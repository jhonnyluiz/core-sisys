package com.jlcabral.csm.service;

import org.springframework.stereotype.Service;

import com.jlcabral.core.service.AppCrudService;
import com.jlcabral.csm.entity.Sistema;
import com.jlcabral.csm.repository.SistemaRepository;

@Service
public class SistemaService extends AppCrudService<SistemaRepository, Sistema, Long> {

	@Override
	protected Sistema toUpdateValue(Sistema entity, Sistema entityDB) {
		return entityDB;
	}

}
