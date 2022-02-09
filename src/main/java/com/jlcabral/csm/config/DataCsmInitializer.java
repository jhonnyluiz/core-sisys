package com.jlcabral.csm.config;

import static com.jlcabral.csm.constant.SistemaConstant.CSM_MODULO_MODULO;
import static com.jlcabral.csm.constant.SistemaConstant.CSM_MODULO_OPERACAO;
import static com.jlcabral.csm.constant.SistemaConstant.CSM_MODULO_PARAMETRIZACAO;
import static com.jlcabral.csm.constant.SistemaConstant.CSM_MODULO_SISTEMA;
import static com.jlcabral.csm.constant.SistemaConstant.CSM_SISTEMA;
import static java.util.Arrays.asList;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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
		sistemaCSM.setModulos(Arrays.asList(CSM_MODULO_PARAMETRIZACAO));
		sistemaCSM.getModulos().get(0).setModulosFilhos(asList(CSM_MODULO_SISTEMA, CSM_MODULO_MODULO, CSM_MODULO_OPERACAO));
		sistemaService.create(sistemaCSM);
	}
}
