package com.example.adopciones.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adopciones.models.RefugioModel;
import com.example.adopciones.security.models.UsuarioModel;

public interface RefugioRepository extends JpaRepository<RefugioModel, Integer>{

	public List<RefugioModel> findAll();
	public List<RefugioModel> findAllByUsuario(UsuarioModel usuarioModel);
}
