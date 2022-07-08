package com.jlcabral.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlcabral.core.entity.Sistema;

@Repository
public interface SistemaRepository extends JpaRepository<Sistema, Long> {

	Sistema findByCodigo(String codigo);

	Boolean existsSistemaByCodigo(String codSistema);

}
