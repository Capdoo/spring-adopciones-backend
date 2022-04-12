package com.example.adopciones.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adopciones.models.DetalleModel;

public interface DetalleRepository extends JpaRepository<DetalleModel, Integer>{

	
	public List<DetalleModel> findAll();
	public List<DetalleModel> findAllByEspecie(String especie);
	
	
}
