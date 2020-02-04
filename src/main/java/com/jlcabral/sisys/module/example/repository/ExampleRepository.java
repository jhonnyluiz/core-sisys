package com.jlcabral.sisys.module.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlcabral.sisys.module.example.domain.model.ExampleModel;

@Repository
public interface ExampleRepository extends JpaRepository<ExampleModel, Long>{

}
