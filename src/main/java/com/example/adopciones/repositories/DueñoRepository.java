package com.example.adopciones.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adopciones.models.DueñoModel;


public interface DueñoRepository extends JpaRepository<DueñoModel, Integer>{
	
	List<DueñoModel> findAll();

	

}
