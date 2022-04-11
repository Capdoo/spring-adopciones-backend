package com.example.adopciones.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.adopciones.dto.DuenoDTO;
import com.example.adopciones.dto.MensajeDTO;
import com.example.adopciones.services.DuenoService;

@RestController
@RequestMapping("/dueños")
public class DueñoController {

	@Autowired
	DuenoService duenoService;
	
	@PostMapping("/registrar")
	public ResponseEntity<Object> guardar(@RequestBody DuenoDTO dueñoDTO){
		
		try {
			duenoService.save(dueñoDTO);
			return new ResponseEntity<Object>(new MensajeDTO("Registrado con exito"), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Hubo un problema"), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/obtener")
	public ResponseEntity<Object> obtener(){
		
		try {
			List<DuenoDTO> listaDuenos = duenoService.listar();
			return new ResponseEntity<Object>(listaDuenos, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Hubo un problema"), HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
