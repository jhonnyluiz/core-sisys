package com.jlcabral.csm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jlcabral.core.service.AppCrudService;
import com.jlcabral.core.util.ObjUtil;
import com.jlcabral.csm.dto.SelectDTO;
import com.jlcabral.csm.entity.ItemMenu;
import com.jlcabral.csm.entity.Sistema;
import com.jlcabral.csm.repository.ItemMenuRepository;

@Service
public class ItemMenuService extends AppCrudService<ItemMenuRepository, ItemMenu, Long> {

	@Override
	protected ItemMenu toUpdateValue(ItemMenu entity, ItemMenu entityDB) {
		entityDB.setLabel(entity.getLabel());
		entityDB.setIcon(entity.getIcon());
		entityDB.setUrl(entity.getUrl());
		entityDB.setDisabled(entity.isDisabled());
		entityDB.setVisible(entity.isVisible());
		entityDB.setTooltip(entity.getTooltip());
		entityDB.setTooltipPosition(entity.getTooltipPosition());
		entityDB.setItemPai(ItemPaiFactoryWithId(entity));
		entityDB.setStyleClass(entity.getStyleClass());
		entityDB.setOrder(entity.getOrder());
		return entityDB;
	}

	@Override
	protected ItemMenu toCreateValue(ItemMenu entity) {
		entity.setItemPai(ItemPaiFactoryWithId(entity));
		entity.setSistema(Sistema.builder().id(entity.getSistemaId()).build());
		return entity;
	}

	private ItemMenu ItemPaiFactoryWithId(ItemMenu entity) {
		if (ObjUtil.isNotEmpty(entity.getItemPaiId())) {
			return ItemMenu.builder().id(entity.getItemPaiId()).build();
		}
		return null;
	}

	public List<SelectDTO> findListSelect(Long sistemaId, String filterText) {
		return getRepo().findListSelect(sistemaId, ObjUtil.isEmpty(filterText) ? null : filterText);
	}

}
