package com.jlcabral.core.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jlcabral.core.entity.AppEntity;
import com.jlcabral.core.exception.ObjectNotFoundException;

public abstract class AppReadService<R extends JpaRepository<T, ID>, T extends AppEntity<ID>, ID> {

	@Autowired
	private R repository;

	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public AppReadService() {
		ParameterizedType genericSuperclass = null;
		if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
			genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		} else if (getClass().getSuperclass().getGenericSuperclass() instanceof ParameterizedType) {
			genericSuperclass = (ParameterizedType) getClass().getSuperclass().getGenericSuperclass();
		}
		if (genericSuperclass == null) {
			throw new RuntimeException("nao foi possivel inferir o tipo generico");
		}
		entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[1];
	}

	public R getRepo() {
		return repository;
	}

	public T findById(ID id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, entityClass));
	}

	public List<T> findAll() {
		return repository.findAll();
	}

	public Page<T> findPaginado(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
