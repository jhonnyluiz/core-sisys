package com.jlcabral.example_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlcabral.example_module.entity.ExampleModel;

@Repository
public interface ExampleRepository extends JpaRepository<ExampleModel, Long>{

}
