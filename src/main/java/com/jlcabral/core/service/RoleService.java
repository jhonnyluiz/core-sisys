package com.jlcabral.core.service;

import org.springframework.stereotype.Service;

import com.jlcabral.core.entity.Role;
import com.jlcabral.core.repository.RoleRepository;

@Service
public class RoleService extends AppCrudService<RoleRepository, Role, String>{

	@Override
	protected Role toUpdateValue(Role entity, Role entityDB) {
		return entityDB;
	}

}
