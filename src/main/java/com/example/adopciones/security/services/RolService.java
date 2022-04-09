package com.example.adopciones.security.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adopciones.security.enums.RolNombre;
import com.example.adopciones.security.models.RolModel;
import com.example.adopciones.security.repositories.RolRepository;


@Service
@Transactional

public class RolService {

	@Autowired
	RolRepository rolRepository;
	
	public Optional<RolModel> getByRolNombre (RolNombre rolNombre){
		return rolRepository.findByRolNombre(rolNombre);
	}
	
	public void save(RolModel rolModel) {
		rolRepository.save(rolModel);
	}
}
