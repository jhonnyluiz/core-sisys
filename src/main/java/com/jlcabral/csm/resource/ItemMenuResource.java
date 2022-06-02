package com.jlcabral.csm.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jlcabral.core.constant.PathResource;
import com.jlcabral.core.resource.AppCrudResource;
import com.jlcabral.csm.dto.ItemMenuDTO;
import com.jlcabral.csm.dto.SelectDTO;
import com.jlcabral.csm.entity.ItemMenu;
import com.jlcabral.csm.repository.ItemMenuRepository;
import com.jlcabral.csm.service.ItemMenuService;

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
