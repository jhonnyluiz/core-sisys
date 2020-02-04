package com.jlcabral.core.exception;

import com.jlcabral.core.constant.MsgConstant;
import com.jlcabral.core.enumerated.TypeMessageExceptionEnum;

public class EnumInvalidException extends BusinessException {
	private static final long serialVersionUID = 224221447922773090L;

	public EnumInvalidException(Object codigo, String nameEnum) {
		super();
		String[] parametersMessage = { codigo.toString(), nameEnum };
		setTypeMessage(TypeMessageExceptionEnum.E);
		setCodeMessage(MsgConstant.MSG_902);
		setParametersMessage(parametersMessage);
	}
}
