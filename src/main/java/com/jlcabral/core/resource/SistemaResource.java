package com.jlcabral.core.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlcabral.core.constant.PathResource;
import com.jlcabral.core.dto.SistemaDTO;
import com.jlcabral.core.entity.Sistema;
import com.jlcabral.core.repository.SistemaRepository;
import com.jlcabral.core.service.SistemaService;

@RestController
@RequestMapping(PathResource.SISTEMAS)
public class SistemaResource extends AppCrudResource<SistemaService, SistemaRepository, SistemaDTO, Sistema, Long> {

	@GetMapping("/byCodigo/{codSistema}")
	public ResponseEntity<Sistema> findByCodSistema(@PathVariable("codSistema") String codSistema) {
		return ResponseEntity.ok(getService().findByCodSistema(codSistema));
	}
	
	@GetMapping("/exists/{codSistema}")
	public ResponseEntity<Boolean> existsByCodigo(@PathVariable("codSistema") String codSistema) {
		return ResponseEntity.ok(getService().existsSistemaByCodigo(codSistema));
	}
}
