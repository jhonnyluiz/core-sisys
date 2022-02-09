package com.jlcabral.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlcabral.csm.entity.SistemaModulo;

@Repository
public interface SistemaModuloRepository extends JpaRepository<SistemaModulo, Long> {

}