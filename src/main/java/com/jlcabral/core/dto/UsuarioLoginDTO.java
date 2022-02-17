package com.jlcabral.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioLoginDTO extends AppDTO {
	private static final long serialVersionUID = 6432158544320776380L;
	
	private String username;
	private String password;
}
