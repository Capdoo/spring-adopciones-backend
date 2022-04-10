package com.example.adopciones.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adopciones.models.DuenoModel;


public interface DuenoRepository extends JpaRepository<DuenoModel, Integer>{
	
	List<DuenoModel> findAll();

	

}
