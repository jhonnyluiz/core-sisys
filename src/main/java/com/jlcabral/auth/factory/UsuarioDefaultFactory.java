package com.jlcabral.auth.factory;

import com.jlcabral.auth.contants.RoleConstant;
import com.jlcabral.auth.entity.Usuario;
import com.jlcabral.core.enumerated.SimNaoEnum;

public class UsuarioDefaultFactory {

	private UsuarioDefaultFactory() {
	}
	
	public static Usuario getAdmin() {
		return Usuario.builder()
				.username("admin")
				.password("123456")
				.contaAtiva(SimNaoEnum.SIM)
				.contaBloqueada(SimNaoEnum.NAO)
				.roles(RoleConstant.getRoles())
				.build();
	}
}
