package com.jlcabral.csm.constant;

import com.jlcabral.csm.entity.ItemMenu;
import com.jlcabral.csm.entity.Sistema;
import com.jlcabral.csm.enumerated.TypeSituacaoEnum;

public class SistemaConstant {
	private SistemaConstant() {
	}

	public static final Sistema CSM_SISTEMA = Sistema.builder().nome("CSM - Gerenciador de Sistemas Comun")
			.codigo("CSM").typeSituacao(TypeSituacaoEnum.ATIVO).build();

	//===========================ADMINISTRACAO================================
	public static final ItemMenu ADMINISTRACAO = ItemMenu.builder().label("Administração").icon("pi pi-qrcode").order(0).build();
	public static final ItemMenu ADMINISTRACAO_USUARIOS = ItemMenu.builder().label("Usuários").url("administracao/usuarios").icon("pi pi-users").order(1).build();

	//===========================PARAMETRIZACAO================================
	public static final ItemMenu PARAMETRIZACAO = ItemMenu.builder().label("Parametrização").icon("pi pi-qrcode").order(1).build();

	public static final ItemMenu PARAMETRIZACAO_MENU = ItemMenu.builder().label("Menu").icon("pi pi-list").order(0).build();
	public static final ItemMenu PARAMETRIZACAO_MENU_SISTEMA = ItemMenu.builder().label("Sistema").url("parametrizacoes/menu/sistemas").icon("pi pi-microsoft").order(0).build();

	public static final ItemMenu PARAMETRIZACAO_PERFIS = ItemMenu.builder().label("Perfis").url("parametrizacoes/perfis").icon("pi pi-user").order(1).build();

	public static final ItemMenu PARAMETRIZACAO_OPERACOES = ItemMenu.builder().label("Operações").url("parametrizacoes/operacoes").icon("pi pi-th-large").order(2).build();
	

	//===========================CONFIGURACOES================================
	public static final ItemMenu CONFIGURACOES = ItemMenu.builder().label("Configurações").icon("pi pi-cog").order(2).build();

	public static final ItemMenu CONFIGURACOES_PERFIL = ItemMenu.builder().label("Perfil").url("configuracoes/perfil").icon("pi pi-user").order(0).build();
	public static final ItemMenu CONFIGURACOES_SEGURANCA = ItemMenu.builder().label("Segurança").url("configuracoes/seguranca").icon("pi pi-lock").order(1).build();
}
