package com.example.adopciones.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.adopciones.security.enums.RolNombre;
import com.example.adopciones.security.models.RolModel;



@Repository
public interface RolRepository extends JpaRepository<RolModel, Integer>{
	
	Optional<RolModel> findByRolNombre(RolNombre rolNombre);
	
	
}
