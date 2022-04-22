package com.example.adopciones.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adopciones.models.AdopcionModel;
import com.example.adopciones.models.MascotaModel;

public interface AdopcionRepository extends JpaRepository<AdopcionModel, Integer>{

	public List<AdopcionModel> findAll();
	public List<AdopcionModel> findAllByMascota(MascotaModel mascotaModel);
	
}
