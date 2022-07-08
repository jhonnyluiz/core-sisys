package com.jlcabral.core.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jlcabral.core.constant.PathResource;
import com.jlcabral.core.dto.ItemMenuDTO;
import com.jlcabral.core.dto.SelectDTO;
import com.jlcabral.core.entity.ItemMenu;
import com.jlcabral.core.repository.ItemMenuRepository;
import com.jlcabral.core.service.ItemMenuService;

@RestController
@RequestMapping(PathResource.ITENS_MENU)
public class ItemMenuResource
		extends AppCrudResource<ItemMenuService, ItemMenuRepository, ItemMenuDTO, ItemMenu, Long> {

	@GetMapping(PathResource.LIST_SELECT)
	public ResponseEntity<List<SelectDTO>> findListSelect(@RequestParam("sistemaId") Long sistemaId,
			@RequestParam("filterText") String filterText) {
		return ResponseEntity.ok(getService().findListSelect(sistemaId, filterText));
	}
}
