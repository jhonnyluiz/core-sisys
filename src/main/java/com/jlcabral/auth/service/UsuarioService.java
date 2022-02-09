package com.jlcabral.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jlcabral.auth.entity.Usuario;
import com.jlcabral.auth.repository.UsuarioRepository;
import com.jlcabral.core.enumerated.SimNaoEnum;
import com.jlcabral.core.service.AppCrudService;

@Service
public class UsuarioService extends AppCrudService<UsuarioRepository, Usuario, Long> {

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	protected Usuario toCreateValue(Usuario usuario) {
		usuario.setContaAtiva(SimNaoEnum.SIM);
		usuario.setContaBloqueada(SimNaoEnum.NAO);
		usuario.setPassword(bcryptEncoder.encode(usuario.getPassword()));
		return usuario;
	}

	@Override
	protected Usuario toUpdateValue(Usuario entity, Usuario entityDB) {
		return entityDB;
	}

}
