package com.jlcabral.core.resource.exception;

import com.jlcabral.core.enumerated.TypeMessageExceptionEnum;
import com.jlcabral.core.exception.BusinessException;

public class UserDisabledCredentialsException extends BusinessException {
	private static final long serialVersionUID = 7975080165777150128L;

	public UserDisabledCredentialsException() {
		super(TypeMessageExceptionEnum.E, "USER_DISABLED", "Usuário desabilitado", null, false);
	}
}
