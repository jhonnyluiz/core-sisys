package com.jlcabral.csm.constant;

import com.jlcabral.csm.entity.Sistema;
import com.jlcabral.csm.entity.SistemaModulo;
import com.jlcabral.csm.enumerated.TypeModuloEnum;
import com.jlcabral.csm.enumerated.TypeSituacaoEnum;

public class SistemaConstant {
	private SistemaConstant() {
	}

	public static final Sistema CSM_SISTEMA = Sistema.builder().nome("CSM - Gerenciador de Sistemas Comun").codigo("CSM").typeSituacao(TypeSituacaoEnum.ATIVO).build();

	public static final SistemaModulo CSM_MODULO_PARAMETRIZACAO = SistemaModulo.builder().nome("Parametrização")
			.codigo("CSM_PARAMETRIZACAO").typeSituacao(TypeSituacaoEnum.ATIVO).typeModulo(TypeModuloEnum.MULTIPLO)
			.urlModulo("/parametrizacao").sistema(CSM_SISTEMA).build();

	public static final SistemaModulo CSM_MODULO_USUARIOS = SistemaModulo.builder().nome("Usuários")
			.codigo("CSM_USUARIO").typeSituacao(TypeSituacaoEnum.ATIVO).typeModulo(TypeModuloEnum.UNICO)
			.urlModulo("/parametrizacao/usuarios").sistema(CSM_SISTEMA).moduloVinculado(CSM_MODULO_PARAMETRIZACAO)
			.build();

	public static final SistemaModulo CSM_MODULO_SISTEMA = SistemaModulo.builder().nome("Sistemas")
			.codigo("CSM_SISTEMA").typeSituacao(TypeSituacaoEnum.ATIVO).typeModulo(TypeModuloEnum.UNICO)
			.urlModulo("/parametrizacao/sistemas").sistema(CSM_SISTEMA).moduloVinculado(CSM_MODULO_PARAMETRIZACAO)
			.build();

	public static final SistemaModulo CSM_MODULO_MODULO = SistemaModulo.builder().nome("Módulos").codigo("CSM_MODULO")
			.typeSituacao(TypeSituacaoEnum.ATIVO).typeModulo(TypeModuloEnum.UNICO).urlModulo("/parametrizacao/modulos")
			.sistema(CSM_SISTEMA).moduloVinculado(CSM_MODULO_PARAMETRIZACAO).build();

	public static final SistemaModulo CSM_MODULO_OPERACAO = SistemaModulo.builder().nome("Operações")
			.codigo("CSM_OPERACAO").typeSituacao(TypeSituacaoEnum.ATIVO).typeModulo(TypeModuloEnum.UNICO)
			.urlModulo("/parametrizacao/operacoes").sistema(CSM_SISTEMA).moduloVinculado(CSM_MODULO_PARAMETRIZACAO)
			.build();

}
