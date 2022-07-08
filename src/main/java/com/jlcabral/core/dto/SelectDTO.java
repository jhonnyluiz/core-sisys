package com.jlcabral.core.dto;

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
public class SelectDTO extends AppDTO {
	private static final long serialVersionUID = -6068396335444231304L;
	
	private Long codigo;
	private String descricao;
}
