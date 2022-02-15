package com.jlcabral.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlcabral.csm.entity.Sistema;

@Repository
public interface SistemaRepository extends JpaRepository<Sistema, Long> {

	Sistema findByCodigo(String codigo);

}
