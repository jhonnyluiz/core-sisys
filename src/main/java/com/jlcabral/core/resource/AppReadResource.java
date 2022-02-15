package com.jlcabral.core.resource;

import static com.jlcabral.core.constant.PathResource.ID;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jlcabral.core.entity.AppEntity;
import com.jlcabral.core.service.AppReadService;

public abstract class AppReadResource<S extends AppReadService<R, T, ID>, R extends JpaRepository<T, ID>, T extends AppEntity<ID>, ID> {

	@Autowired
	private S service;

	@Autowired
	public ModelMapper modelMapper;

	public Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public AppReadResource() {
		ParameterizedType genericSuperclass = null;
		if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
			genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		} else if (getClass().getSuperclass().getGenericSuperclass() instanceof ParameterizedType) {
			genericSuperclass = (ParameterizedType) getClass().getSuperclass().getGenericSuperclass();
		}
		if (genericSuperclass == null) {
			throw new RuntimeException("nao foi possivel inferir o tipo generico");
		}
		entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[3];
	}

	public S getService() {
		return service;
	}

	@GetMapping("/all")
	public ResponseEntity<List<T>> listAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping
	public ResponseEntity<Page<T>> listPaginado(@PageableDefault(page = 0, size = 20) @SortDefault.SortDefaults({
			@SortDefault(sort = "id", direction = Sort.Direction.ASC) }) Pageable pageable) {
		return ResponseEntity.ok(service.findPaginado(pageable));
	}

	@GetMapping(ID)
	public ResponseEntity<T> findById(@PathVariable ID id) {
		return ResponseEntity.ok(service.findById(id));
	}

}
