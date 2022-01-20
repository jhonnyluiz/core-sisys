package com.jlcabral.core.model;

import static com.jlcabral.core.util.ObjUtil.isEmpty;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;

@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class AppEntity<ID> implements Serializable {
	private static final long serialVersionUID = -3250877196364766099L;

	public abstract void setId(ID id);

	@EqualsAndHashCode.Include
	public abstract ID getId();

	@JsonIgnore
	public final Boolean isTransient() {
		return isEmpty(getId());
	}
}
