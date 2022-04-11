package com.example.adopciones.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adopciones.models.MascotaModel;

public interface MascotaRepository extends JpaRepository<MascotaModel, Integer>{

	public List<MascotaModel> findAll();
	
}
