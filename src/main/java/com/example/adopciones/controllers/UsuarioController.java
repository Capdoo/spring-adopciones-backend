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

import com.example.adopciones.dto.MascotaDTO;
import com.example.adopciones.dto.MensajeDTO;
import com.example.adopciones.dto.StringDTO;
import com.example.adopciones.dto.UsuarioDTO;
import com.example.adopciones.security.models.UsuarioModel;
import com.example.adopciones.security.repositories.UsuarioRepository;
import com.example.adopciones.security.services.UsuarioService;
import com.example.adopciones.services.DuenoService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	DuenoService duenoService;
	
	@GetMapping("/obtener")
	public ResponseEntity<Object> obtener(){
		
		try {
			List<UsuarioDTO> listaUsuarios = usuarioService.listar();
			return new ResponseEntity<Object>(listaUsuarios, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Hubo un problema"), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/id")
	public ResponseEntity<Object> obtener(@RequestBody StringDTO stringDTO){
		
		try {
			int id = usuarioService.obtenerIdPorUsername(stringDTO.getData());
			StringDTO respuesta = new StringDTO();
				respuesta.setData(id+"");
			return new ResponseEntity<Object>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Hubo un problema"), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/isDueño")
	public ResponseEntity<Object> isDueno(@RequestBody StringDTO stringDTO){
		
		try {
			int idUsuario = usuarioService.obtenerIdPorUsername(stringDTO.getData());
			boolean res = duenoService.existsDuenoPorUsuarioId(idUsuario);
			StringDTO respuesta = new StringDTO();
				respuesta.setData(res+"");
			return new ResponseEntity<Object>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Hubo un problema"), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	//Actualizar datos
	

}
