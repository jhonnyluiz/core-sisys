package com.jlcabral.auth.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlcabral.auth.config.JwtTokenUtil;
import com.jlcabral.auth.dto.JwtTokenDTO;
import com.jlcabral.auth.dto.UsuarioLoginDTO;
import com.jlcabral.auth.entity.UsuarioDetails;
import com.jlcabral.auth.service.UsuarioDetailsService;
import com.jlcabral.core.enumerated.TypeMessageExceptionEnum;
import com.jlcabral.core.exception.BusinessException;

@RestController
@RequestMapping(path = "/auth")
public class AuthResource {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UsuarioDetailsService usuarioDetailsService;

	@PostMapping(path = "/login")
	public ResponseEntity<JwtTokenDTO> createAuthenticationToken(@RequestBody UsuarioLoginDTO usuarioDTO) throws Exception {
		authenticate(usuarioDTO.getUsername(), usuarioDTO.getPassword());
		final UsuarioDetails userDetails = usuarioDetailsService.loadUserByUsername(usuarioDTO.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtTokenDTO(token));
	}
	
	private void authenticate(String username, String password) throws BusinessException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new BusinessException(TypeMessageExceptionEnum.E, "USER_DISABLED", "Usuário desabilitado", null);
		} catch (BadCredentialsException e) {
			throw new BusinessException(TypeMessageExceptionEnum.E, "INVALID_CREDENTIALS", "Usuário ou senha incorretos", null);
		}
	}
}
