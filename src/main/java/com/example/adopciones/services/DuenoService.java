package com.example.adopciones.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adopciones.dto.DuenoDTO;
import com.example.adopciones.models.DuenoModel;
import com.example.adopciones.repositories.DuenoRepository;
import com.example.adopciones.security.models.UsuarioModel;
import com.example.adopciones.security.repositories.UsuarioRepository;

@Service
public class DuenoService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	DuenoRepository duenoRepository;
	
	public void save(DuenoDTO dueñoDTO) {
		
		//Obteniendo al Usuario
		UsuarioModel usuarioObtenido = usuarioRepository.findById(dueñoDTO.getUsuario_id()).get();
		
		DuenoModel dueñoModel = new DuenoModel();
			dueñoModel.setFechaRegistro(dueñoDTO.getFechaRegistro());
			dueñoModel.setHistorial_id(dueñoDTO.getHistorial_id());
			dueñoModel.setNumeroMascotas(dueñoDTO.getNumero_mascotas());
			dueñoModel.setRate(dueñoDTO.getRate());
			dueñoModel.setUsuario(usuarioObtenido);
			
		duenoRepository.save(dueñoModel);
	}
	
	public List<DuenoDTO> listar(){
		List<DuenoDTO> listaVacia = new ArrayList<>();
		
		//Traer los datos
		List<DuenoModel> listaModelsBD = duenoRepository.findAll();
		
		DuenoDTO duenoSingle = new DuenoDTO();
		for(DuenoModel p : listaModelsBD) {
			duenoSingle.setFechaRegistro(p.getFechaRegistro());
			duenoSingle.setHistorial_id(p.getHistorial_id());
			duenoSingle.setNumero_mascotas(p.getNumeroMascotas());
			duenoSingle.setRate(p.getRate());
			duenoSingle.setUsuario_id(p.getUsuario().getId());
				
			listaVacia.add(duenoSingle);
		}
		
		return listaVacia;
	}
	
	
}





