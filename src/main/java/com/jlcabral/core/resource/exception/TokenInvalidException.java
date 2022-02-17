package com.jlcabral.core.resource.exception;

import com.jlcabral.core.enumerated.TypeMessageExceptionEnum;
import com.jlcabral.core.exception.BusinessException;

public class TokenInvalidException extends BusinessException {
	private static final long serialVersionUID = 7975080165777150128L;

	public TokenInvalidException() {
		super(TypeMessageExceptionEnum.E, "TOKEN_INVALID", "Autenticação inválida", null, false);
	}
}
