package com.jlcabral.csm.constant;

import com.jlcabral.csm.entity.ItemMenu;
import com.jlcabral.csm.entity.Sistema;
import com.jlcabral.csm.enumerated.TypeSituacaoEnum;

public class SistemaConstant {
	private SistemaConstant() {
	}

	public static final Sistema CSM_SISTEMA = Sistema.builder().nome("CSM - Gerenciador de Sistemas Comun")
			.codigo("CSM").typeSituacao(TypeSituacaoEnum.ATIVO).build();

	public static final ItemMenu PARAMETRIZACAO = ItemMenu.builder().label("Parametrização").icon("pi pi-fw pi-qrcode").build();

	public static final ItemMenu PARAMETRIZACAO_MENU = ItemMenu.builder().label("Menu").icon("pi pi-fw pi-list").build();
	public static final ItemMenu PARAMETRIZACAO_MENU_SISTEMA = ItemMenu.builder().label("Sistema").icon("pi pi-fw pi-microsoft").build();
	public static final ItemMenu PARAMETRIZACAO_MENU_ITEM_MENU = ItemMenu.builder().label("Itens Menu").icon("pi pi-fw pi-ellipsis-v").build();

	public static final ItemMenu PARAMETRIZACAO_PERFIS = ItemMenu.builder().label("Perfis").icon("pi pi-fw pi-user").build();

	public static final ItemMenu PARAMETRIZACAO_OPERACOES = ItemMenu.builder().label("Operações").icon("pi pi-fw pi-th-large").build();
	

	public static final ItemMenu CONFIGURACOES = ItemMenu.builder().label("Configurações").icon("pi pi-fw pi-cog").build();

	public static final ItemMenu CONFIGURACOES_PERFIL = ItemMenu.builder().label("Perfil").icon("pi pi-fw pi-user").build();
	public static final ItemMenu CONFIGURACOES_SEGURANCA = ItemMenu.builder().label("Segurança").icon("pi pi-fw pi-lock").build();
}
