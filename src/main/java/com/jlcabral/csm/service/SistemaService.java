package com.jlcabral.csm.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.jlcabral.core.service.AppCrudService;
import com.jlcabral.core.util.ObjUtil;
import com.jlcabral.csm.entity.Sistema;
import com.jlcabral.csm.repository.SistemaRepository;

@Service
public class SistemaService extends AppCrudService<SistemaRepository, Sistema, Long> {

	@Override
	protected Sistema toUpdateValue(Sistema entity, Sistema entityDB) {
		return entityDB;
	}

	public Sistema findByCodSistema(String codSistema) {
		Sistema sistema = getRepo().findByCodigo(codSistema);
		sistema.setItensMenu(sistema.getItensMenu().stream().filter(i -> ObjUtil.isEmpty(i.getItemPai())).collect(Collectors.toList()));
		return sistema;
	}
}
