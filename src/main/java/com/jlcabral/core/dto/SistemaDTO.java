package com.jlcabral.core.dto;

import java.util.List;

import com.jlcabral.core.enumerated.TypeSituacaoEnum;

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
public class SistemaDTO extends AppDTO {
	private static final long serialVersionUID = 4982055211698501904L;

	private Long id;
	private String nome;
	private String codigo;
	private String descricao;
	private String url;
	private TypeSituacaoEnum typeSituacao;
	private List<ItemMenuDTO> itensMenu;
}
