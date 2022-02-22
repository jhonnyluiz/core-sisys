package com.jlcabral.csm.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlcabral.core.resource.AppCrudResource;
import com.jlcabral.csm.dto.SistemaDTO;
import com.jlcabral.csm.entity.Sistema;
import com.jlcabral.csm.repository.SistemaRepository;
import com.jlcabral.csm.service.SistemaService;

@RestController
@RequestMapping("/sistemas")
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
