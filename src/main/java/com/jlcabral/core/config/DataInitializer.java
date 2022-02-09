package com.jlcabral.core.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.jlcabral.auth.contants.RoleConstant;
import com.jlcabral.auth.entity.Usuario;
import com.jlcabral.auth.factory.UsuarioAdminFactory;
import com.jlcabral.auth.service.RoleService;
import com.jlcabral.auth.service.UsuarioService;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RoleService roleService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initRoles();
		initUserAdmin();
	}

	private void initRoles() {
		roleService.saveAll(RoleConstant.getRoles());
	}

	private void initUserAdmin() {
		List<Usuario> usuarios = usuarioService.findAll();
		if (usuarios.isEmpty()) {
			usuarioService.create(UsuarioAdminFactory.get());
		}
	}

}
