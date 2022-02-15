package com.jlcabral.auth.resource.exceptions;

import com.jlcabral.core.enumerated.TypeMessageExceptionEnum;
import com.jlcabral.core.exception.BusinessException;

public class InvalidCredentialsException extends BusinessException {
	private static final long serialVersionUID = 7975080165777150128L;

	public InvalidCredentialsException() {
		super(TypeMessageExceptionEnum.E, "INVALID_CREDENTIALS", "Usuário ou senha incorretos", null, false);
	}
}
