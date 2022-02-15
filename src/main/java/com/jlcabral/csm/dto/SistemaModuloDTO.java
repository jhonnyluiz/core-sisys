package com.jlcabral.csm.dto;

import java.util.List;

import com.jlcabral.core.dto.AppDTO;
import com.jlcabral.csm.entity.Sistema;
import com.jlcabral.csm.enumerated.TypeModuloEnum;
import com.jlcabral.csm.enumerated.TypeSituacaoEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SistemaModuloDTO extends AppDTO {
	private static final long serialVersionUID = -4577615062231534675L;
	
	private Long id;
	private String nome;
	private String codigo;
	private TypeSituacaoEnum typeSituacao;
	private TypeModuloEnum typeModulo;
	private String urlModulo;
	private Sistema sistema;
	private List<SistemaModuloDTO> modulosFilhos;
}
