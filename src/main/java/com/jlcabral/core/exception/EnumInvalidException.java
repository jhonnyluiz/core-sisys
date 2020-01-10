package com.jlcabral.core.exception;

import com.jlcabral.core.constant.MsgConstant;
import com.jlcabral.core.enumerated.TypeMessageExceptionEnum;

public class EnumInvalidException extends BusinessException {
	private static final long serialVersionUID = 224221447922773090L;

	public EnumInvalidException(Object codigo, String nameEnum) {
		super(TypeMessageExceptionEnum.E, MsgConstant.MSG_001, null, codigo, nameEnum);
	}
}
