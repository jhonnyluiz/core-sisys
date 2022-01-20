package com.jlcabral.core.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jlcabral.core.model.AppEntity;

public abstract class AppCrudService<R extends JpaRepository<T, ID>, T extends AppEntity<ID>, ID>
		extends AppReadService<R, T, ID> {

	public T create(T entity) {
		entity.setId(null);
		return getRepo().save(entity);
	}

	public T update(ID id, T entity) {
		T entityDB = findById(id);
		return getRepo().save(toUpdateValue(entity, entityDB));
	}

	protected abstract T toUpdateValue(T entity, T entityDB);

	public void delete(ID id) {
		getRepo().deleteById(id);
	}
}
