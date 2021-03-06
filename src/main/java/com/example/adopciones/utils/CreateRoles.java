package com.example.adopciones.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.adopciones.security.enums.RolNombre;
import com.example.adopciones.security.models.RolModel;
import com.example.adopciones.security.services.RolService;

@Component
public class CreateRoles /*implements CommandLineRunner*/{

	
	@Autowired
	RolService rolService;
	
	//@Override
	public void run(String... args) throws Exception {
		
		RolModel rolAdmin = new RolModel(RolNombre.ROLE_ADMIN);
		
		RolModel rolUser = new RolModel(RolNombre.ROLE_USER);
		
		rolService.save(rolAdmin);
		rolService.save(rolUser);

	}
	 
	
	
	
	
}
