package com.jlcabral.auth.service;

import org.springframework.stereotype.Service;

import com.jlcabral.auth.entity.Role;
import com.jlcabral.auth.repository.RoleRepository;
import com.jlcabral.core.service.AppCrudService;

@Service
public class RoleService extends AppCrudService<RoleRepository, Role, String>{

	@Override
	protected Role toUpdateValue(Role entity, Role entityDB) {
		return entityDB;
	}

}
