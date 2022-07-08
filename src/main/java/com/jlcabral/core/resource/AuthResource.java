package com.jlcabral.core.resource;

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
import com.jlcabral.core.dto.JwtTokenDTO;
import com.jlcabral.core.dto.UsuarioLoginDTO;
import com.jlcabral.core.entity.UsuarioDetails;
import com.jlcabral.core.exception.BusinessException;
import com.jlcabral.core.resource.exception.InvalidCredentialsException;
import com.jlcabral.core.resource.exception.UserDisabledCredentialsException;
import com.jlcabral.core.service.UsuarioDetailsService;

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
			throw new UserDisabledCredentialsException();
		} catch (BadCredentialsException e) {
			throw new InvalidCredentialsException();
		}
	}
}
