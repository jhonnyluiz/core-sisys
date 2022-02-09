package com.jlcabral.csm.enumerated;

import com.jlcabral.core.exception.EnumInvalidException;
import com.jlcabral.core.util.ObjUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TypeSituacaoEnum {

	ATIVO("ATIVO", "Ativo"), INATIVO("INATIVO", "Inativo");

	private String codigo;
	private String descricao;

	public static TypeSituacaoEnum toEnum(String codigo) {
		if (ObjUtil.isNotEmpty(codigo)) {
			for (TypeSituacaoEnum enumerated : TypeSituacaoEnum.values()) {
				if (enumerated.getCodigo().equals(codigo)) {
					return enumerated;
				}
			}
		}
		throw new EnumInvalidException(codigo, TypeSituacaoEnum.class.getSimpleName());
	}
}
