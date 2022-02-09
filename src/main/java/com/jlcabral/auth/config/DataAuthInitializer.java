package com.jlcabral.auth.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.jlcabral.auth.contants.RoleConstant;
import com.jlcabral.auth.entity.Usuario;
import com.jlcabral.auth.factory.UsuarioDefaultFactory;
import com.jlcabral.auth.service.RoleService;
import com.jlcabral.auth.service.UsuarioService;

@Component
public class DataAuthInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RoleService roleService;

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
			usuarioService.create(UsuarioDefaultFactory.getAdmin());
		}
	}

}
