package com.jlcabral.core.enumerated;

import com.jlcabral.core.exception.EnumInvalidException;
import com.jlcabral.core.util.ObjUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TypeModuloEnum {

	UNICO("UNICO", "Único"), MULTIPLO("MULTIPLO", "Multiplu");

	private String codigo;
	private String descricao;

	public static TypeModuloEnum toEnum(String codigo) {
		if (ObjUtil.isNotEmpty(codigo)) {
			for (TypeModuloEnum enumerated : TypeModuloEnum.values()) {
				if (enumerated.getCodigo().equals(codigo)) {
					return enumerated;
				}
			}
		}
		throw new EnumInvalidException(codigo, TypeModuloEnum.class.getSimpleName());
	}
}
