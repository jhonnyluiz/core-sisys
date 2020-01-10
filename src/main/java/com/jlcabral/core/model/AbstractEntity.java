package com.jlcabral.core.model;

import com.jlcabral.core.util.ObjUtil;

public abstract class AbstractEntity {

	abstract Long getId();
	
	public final Boolean isTransient() {
		return ObjUtil.isEmpty(getId());
	}
}
