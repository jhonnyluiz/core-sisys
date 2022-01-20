package com.jlcabral.core.exception;

import com.jlcabral.core.constant.MsgConstant;
import com.jlcabral.core.enumerated.TypeMessageExceptionEnum;

public class ObjectNotFoundException extends BusinessException {
	private static final long serialVersionUID = -2960757890164313424L;

	public <ID> ObjectNotFoundException(ID id, Class<?> clazz) {
		super();
		String[] parametersMessageDevelop = {id.toString(), clazz.getSimpleName()};
		setTypeMessage(TypeMessageExceptionEnum.E);
		setCodeMessage(MsgConstant.MSG_004);
		setParametersMessage(parametersMessageDevelop);
	}
}
