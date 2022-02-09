package com.jlcabral.auth.dto;

import com.jlcabral.core.dto.AppDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JwtTokenDTO extends AppDTO {
	private static final long serialVersionUID = 427507727663619134L;
	
	private String token;
}
