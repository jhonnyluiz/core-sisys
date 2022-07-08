package com.jlcabral.core.factory;

import com.jlcabral.core.constant.RoleConstant;
import com.jlcabral.core.entity.Usuario;
import com.jlcabral.core.enumerated.SimNaoEnum;

public class UsuarioDefaultFactory {

	private UsuarioDefaultFactory() {
	}
	
	public static Usuario getAdmin() {
		return Usuario.builder()
				.username("admin")
				.password("123456")
				.pessoaId(1L)
				.contaAtiva(SimNaoEnum.SIM)
				.contaBloqueada(SimNaoEnum.NAO)
				.roles(RoleConstant.getRoles())
				.build();
	}
}
