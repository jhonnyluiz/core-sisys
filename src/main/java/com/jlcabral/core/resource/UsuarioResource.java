package com.jlcabral.core.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlcabral.core.constant.PathResource;
import com.jlcabral.core.entity.Usuario;

@RestController
@RequestMapping(PathResource.USUARIOS)
public class UsuarioResource {

	@GetMapping
	public ResponseEntity<List<Usuario>> listPage() {
		return ResponseEntity.ok(Arrays.asList(Usuario.builder().username("teste").build()));
	}
}
