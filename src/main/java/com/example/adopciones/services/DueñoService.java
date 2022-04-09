package com.example.adopciones.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adopciones.dto.DueñoDTO;
import com.example.adopciones.models.DueñoModel;
import com.example.adopciones.repositories.DueñoRepository;
import com.example.adopciones.security.models.UsuarioModel;
import com.example.adopciones.security.repositories.UsuarioRepository;

@Service
public class DueñoService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	DueñoRepository dueñoRepository;
	
	public void save(DueñoDTO dueñoDTO) {
		
		//Obteniendo al Usuario
		UsuarioModel usuarioObtenido = usuarioRepository.findById(dueñoDTO.getUsuario_id()).get();
		
		DueñoModel dueñoModel = new DueñoModel();
			dueñoModel.setFechaRegistro(dueñoDTO.getFechaRegistro());
			dueñoModel.setHistorial_id(dueñoDTO.getHistorial_id());
			dueñoModel.setNumeroMascotas(dueñoDTO.getNumero_mascotas());
			dueñoModel.setRate(dueñoDTO.getRate());
			dueñoModel.setUsuario(usuarioObtenido);
			
		dueñoRepository.save(dueñoModel);
	}
	
	
}
