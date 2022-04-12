package com.example.adopciones.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adopciones.dto.DetalleDTO;
import com.example.adopciones.models.DetalleModel;
import com.example.adopciones.repositories.DetalleRepository;

@Service
public class DetalleService {

	@Autowired
	DetalleRepository detalleRepository;
	
	//No existe registrar, son datos fijos
	
	//Obtener todos
	public List<DetalleDTO> listar(){
		List<DetalleDTO> listaDetalles = new ArrayList<>();
		List<DetalleModel> detallesBD = detalleRepository.findAll();
		
		//Single
		DetalleDTO detalleSingle = new DetalleDTO();
		for(DetalleModel p : detallesBD) {
			detalleSingle.setId(p.getId());
			detalleSingle.setEspecie(p.getEspecie());
			detalleSingle.setRaza(p.getRaza());
			
			listaDetalles.add(detalleSingle);
		}
		
		return listaDetalles;
	}
	
	public List<String> obtenerEspecies(){
		List<String> listaEspecies = new ArrayList<>();
		List<DetalleModel> detallesBD = detalleRepository.findAll();
		
		//Single

		for(DetalleModel p : detallesBD) {
			if(!(existeEspecieEnLista(listaEspecies,p.getEspecie()))) {
				listaEspecies.add(p.getEspecie());
			}
		}
		
		return listaEspecies;
	}
	
	public boolean existeEspecieEnLista(List<String> listaEspecies, String especie) {
		boolean res = false;
		
		for(String p : listaEspecies) {
			if(especie == p) {
				res = true;
			}
		}
		return res;
	}
	
	//Obtener Razas Por Especie
	public List<String> obtenerRazasPorEspecie(String especie){
		List<String> listaRazas = new ArrayList<>();

		List<DetalleModel> detallesBD = detalleRepository.findAllByEspecie(especie);
		
		for(DetalleModel p : detallesBD) {
			listaRazas.add(p.getRaza());
		}
		
		return listaRazas;
	}
	
	
}










