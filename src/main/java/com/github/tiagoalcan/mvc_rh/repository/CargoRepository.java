package com.github.tiagoalcan.mvc_rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.tiagoalcan.mvc_rh.model.Cargo;
import com.github.tiagoalcan.mvc_rh.model.Departamento;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
