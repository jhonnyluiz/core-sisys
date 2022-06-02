package com.jlcabral.csm.service;

import static com.jlcabral.core.util.ObjUtil.isEmpty;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jlcabral.core.service.AppCrudService;
import com.jlcabral.core.util.ObjUtil;
import com.jlcabral.csm.entity.ItemMenu;
import com.jlcabral.csm.entity.Sistema;
import com.jlcabral.csm.repository.SistemaRepository;

@Service
public class SistemaService extends AppCrudService<SistemaRepository, Sistema, Long> {

	@Override
	protected Sistema toUpdateValue(Sistema entity, Sistema entityDB) {
		entityDB.setNome(entity.getNome());
		entityDB.setTypeSituacao(entity.getTypeSituacao());
		entityDB.setUrl(entity.getUrl());
		entityDB.setDescricao(entity.getDescricao());
		if (ObjUtil.isNotEmpty(entity.getItensMenu())) {			
			entityDB.setItensMenu(
					entity.getItensMenu().stream().map(item -> item.setData(entityDB, null)).collect(Collectors.toList()));
		}
		return entityDB;
	}

	public Sistema findByCodSistema(String codSistema) {
		Sistema sistema = getRepo().findByCodigo(codSistema);
		sistema.setItensMenu(mountMenuItens(sistema));
		return sistema;
	}

	public Boolean existsSistemaByCodigo(String codSistema) {
		return getRepo().existsSistemaByCodigo(codSistema);
	}

	@Override
	protected Sistema mapperEntity(Sistema entity) {
		entity.setItensMenu(mountMenuItens(entity));
		return entity;
	}

	private List<ItemMenu> mountMenuItens(Sistema sistema) {
		return sistema.getItensMenu().stream().filter(i -> isEmpty(i.getItemPai())).collect(toList());
	}
}
