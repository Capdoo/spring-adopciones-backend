package com.example.adopciones.controllers;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.adopciones.dto.DueñoDTO;
import com.example.adopciones.dto.MensajeDTO;
import com.example.adopciones.repositories.DueñoRepository;
import com.example.adopciones.services.DueñoService;
import com.nimbusds.oauth2.sdk.http.HTTPEndpoint;
import com.nimbusds.oauth2.sdk.http.HTTPResponse;

@RestController
@RequestMapping("/dueños")
public class DueñoController {

	@Autowired
	DueñoService dueñoService;
	
	@PostMapping("/registrar")
	public ResponseEntity<Object> guardar(@RequestBody DueñoDTO dueñoDTO){
		
		try {
			
			dueñoService.save(dueñoDTO);
			return new ResponseEntity<Object>(new MensajeDTO("Registrado con exito"), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Hubo un problema"), HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
