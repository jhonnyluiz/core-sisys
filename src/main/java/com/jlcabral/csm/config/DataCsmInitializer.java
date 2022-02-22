package com.jlcabral.csm.config;

import static com.jlcabral.csm.constant.SistemaConstant.CONFIGURACOES;
import static com.jlcabral.csm.constant.SistemaConstant.CONFIGURACOES_PERFIL;
import static com.jlcabral.csm.constant.SistemaConstant.CONFIGURACOES_SEGURANCA;
import static com.jlcabral.csm.constant.SistemaConstant.CSM_SISTEMA;
import static com.jlcabral.csm.constant.SistemaConstant.PARAMETRIZACAO;
import static com.jlcabral.csm.constant.SistemaConstant.PARAMETRIZACAO_MENU;
import static com.jlcabral.csm.constant.SistemaConstant.PARAMETRIZACAO_MENU_SISTEMA;
import static com.jlcabral.csm.constant.SistemaConstant.PARAMETRIZACAO_OPERACOES;
import static com.jlcabral.csm.constant.SistemaConstant.PARAMETRIZACAO_PERFIS;
import static java.util.Arrays.asList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.jlcabral.csm.entity.ItemMenu;
import com.jlcabral.csm.entity.Sistema;
import com.jlcabral.csm.service.SistemaService;

@Component
public class DataCsmInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private SistemaService sistemaService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initRoles();
	}

	private void initRoles() {
		Sistema sistemaCSM = CSM_SISTEMA;
		
		// START - MENU PARAMETRIZAÇÕES
		ItemMenu parametrizacao = PARAMETRIZACAO;
		parametrizacao.setSistema(sistemaCSM);

		ItemMenu parametrizacaoMenu = PARAMETRIZACAO_MENU;
				
		ItemMenu parametrizacaoMenuSistema = PARAMETRIZACAO_MENU_SISTEMA;
		parametrizacaoMenuSistema.setSistema(sistemaCSM);
		parametrizacaoMenuSistema.setItemPai(parametrizacaoMenu);

		parametrizacaoMenu.setSistema(sistemaCSM);
		parametrizacaoMenu.setItemPai(parametrizacao);
		parametrizacaoMenu.setItems(asList(parametrizacaoMenuSistema));
		
		ItemMenu parametrizacaoPerfis = PARAMETRIZACAO_PERFIS;
		parametrizacaoPerfis.setSistema(sistemaCSM);
		parametrizacaoPerfis.setItemPai(parametrizacao);
		
		ItemMenu parametrizacaoOperacao = PARAMETRIZACAO_OPERACOES;
		parametrizacaoOperacao.setSistema(sistemaCSM);
		parametrizacaoOperacao.setItemPai(parametrizacao);
		
		parametrizacao.setItems(asList(parametrizacaoMenu, parametrizacaoOperacao, parametrizacaoPerfis));
		// END - MENU PARAMETRIZAÇÕES
		
		// START - MENU CONFIGURACOES
		ItemMenu configuracao = CONFIGURACOES;
		configuracao.setSistema(sistemaCSM);

		ItemMenu configuracaoPerfil = CONFIGURACOES_PERFIL;
		configuracaoPerfil.setItemPai(configuracao);
		configuracaoPerfil.setSistema(sistemaCSM);
		
		ItemMenu configuracaoSeguranca = CONFIGURACOES_SEGURANCA;
		configuracaoSeguranca.setItemPai(configuracao);
		configuracaoSeguranca.setSistema(sistemaCSM);
		
		configuracao.setItems(asList(configuracaoPerfil, configuracaoSeguranca));
		// END - MENU PARAMETRIZAÇÕES
		
		sistemaCSM.setItensMenu(asList(parametrizacao, configuracao));
		sistemaService.create(sistemaCSM);
	}
}
