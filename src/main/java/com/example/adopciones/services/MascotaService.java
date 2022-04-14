package com.example.adopciones.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adopciones.dto.MascotaDTO;
import com.example.adopciones.models.DuenoModel;
import com.example.adopciones.models.MascotaModel;
import com.example.adopciones.repositories.DuenoRepository;
import com.example.adopciones.repositories.MascotaRepository;

@Service
public class MascotaService {

	
	@Autowired
	MascotaRepository mascotaRepository;
	
	@Autowired
	DuenoRepository duenoRepository;
	
	public void save(MascotaDTO mascotaDTO) {
		
		DuenoModel duenoMascota = duenoRepository.findById(mascotaDTO.getIdDueno()).get();
		
		MascotaModel mascotaNueva = new MascotaModel();
			mascotaNueva.setEdad(mascotaDTO.getEdad());
			mascotaNueva.setFechaRegistro(mascotaDTO.getFechaRegistro());
			mascotaNueva.setGenero(mascotaDTO.getGenero());
			mascotaNueva.setNombre(mascotaDTO.getNombre());
			mascotaNueva.setDueno(duenoMascota);
		
		mascotaRepository.save(mascotaNueva);
	}
	
	//Lista general
	public List<MascotaDTO> listar(){
		List<MascotaDTO> listaMascotas = new ArrayList<>();
		List<MascotaModel> listaBD = mascotaRepository.findAll();
		
		for(MascotaModel p : listaBD) {
			MascotaDTO mascotaSingle = new MascotaDTO();

			   	mascotaSingle.setEdad(p.getEdad());
				mascotaSingle.setFechaRegistro(p.getFechaRegistro());
				mascotaSingle.setGenero(p.getGenero());
				mascotaSingle.setIdDueno(p.getDueno().getId());
				mascotaSingle.setNombre(p.getNombre());
			
			listaMascotas.add(mascotaSingle);
		}
		
		return listaMascotas;
	}
	
	//Lista por id de dueño
 	
}
