package com.example.adopciones.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adopciones.models.BusquedaModel;
import com.example.adopciones.models.MascotaModel;

public interface BusquedaRepository extends JpaRepository<BusquedaModel, Integer>{
	
	public List<BusquedaModel> findAll();
	public List<BusquedaModel> findAllByMascota(MascotaModel mascotaModel);
	
}
