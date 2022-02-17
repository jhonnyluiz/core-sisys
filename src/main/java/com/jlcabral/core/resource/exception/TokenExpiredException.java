package com.jlcabral.core.resource.exception;

import com.jlcabral.core.enumerated.TypeMessageExceptionEnum;
import com.jlcabral.core.exception.BusinessException;

public class TokenExpiredException extends BusinessException {
	private static final long serialVersionUID = 7975080165777150128L;

	public TokenExpiredException() {
		super(TypeMessageExceptionEnum.E, "TOKEN_EXPIRED", "Autenticação expirada", null, false);
	}
}
