package com.example.adopciones.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adopciones.dto.BusquedaDTO;
import com.example.adopciones.models.BusquedaModel;
import com.example.adopciones.models.MascotaModel;
import com.example.adopciones.repositories.BusquedaRepository;
import com.example.adopciones.repositories.MascotaRepository;
import com.example.adopciones.utils.FechaUtil;

@Service
public class BusquedaService {
	
	@Autowired
	BusquedaRepository busquedaRepository;
	
	@Autowired
	MascotaRepository mascotaRepository;

	public void save(BusquedaDTO busquedaDTO) {
		
		MascotaModel mascotaSeleccionada = mascotaRepository.findById(busquedaDTO.getMascotaId()).get();
		
		BusquedaModel busquedaNueva = new BusquedaModel();
			busquedaNueva.setDireccion(busquedaDTO.getDireccion());
			busquedaNueva.setDistrito(busquedaDTO.getDistrito());
			busquedaNueva.setFechaPerdida(null);
			busquedaNueva.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
			busquedaNueva.setMascota(mascotaSeleccionada);
			
			busquedaNueva.setTelefonoA(busquedaDTO.getTelefonoA());
			busquedaNueva.setTelefonoB(busquedaDTO.getTelefonoB());
		busquedaRepository.save(busquedaNueva);
	}
	
	//Obtener todos
	public List<BusquedaDTO> listar(){
		List<BusquedaDTO> listaEnviar = new ArrayList<>();
		List<BusquedaModel> listaBD = busquedaRepository.findAll();
		FechaUtil fechaUtil = new FechaUtil();
		
		for(BusquedaModel p : listaBD) {
			BusquedaDTO busquedaSingle = new BusquedaDTO();
				//String fechaPerdida = fechaUtil.convertirFecha(p.getFechaPerdida());
				String fechaRegistro = fechaUtil.convertirFecha(p.getFechaRegistro());
				
				busquedaSingle.setId(p.getId());

				busquedaSingle.setDireccion(p.getDireccion());
				busquedaSingle.setDistrito(p.getDistrito());
				busquedaSingle.setFechaPerdida(null);	//cambiable
				busquedaSingle.setFechaRegistro(fechaRegistro);
				busquedaSingle.setMascotaId(p.getMascota().getId());
				busquedaSingle.setTelefonoA(p.getTelefonoA());
				busquedaSingle.setTelefonoB(p.getTelefonoB());
			listaEnviar.add(busquedaSingle);
			
		}
		return listaEnviar;
	}
	
	//Obtener por mascota_id
	public List<BusquedaDTO> obtenerPorMascotaId(int mascotaId){
		List<BusquedaDTO> listaEnviar = new ArrayList<>();
		MascotaModel mascotaSeleccionada = mascotaRepository.findById(mascotaId).get();
		
		List<BusquedaModel> listaBD = busquedaRepository.findAllByMascota(mascotaSeleccionada);
		
		FechaUtil fechaUtil = new FechaUtil();
		for(BusquedaModel p : listaBD) {
			BusquedaDTO busquedaSingle = new BusquedaDTO();
				//String fechaPerdida = fechaUtil.convertirFecha(p.getFechaPerdida());
				String fechaRegistro = fechaUtil.convertirFecha(p.getFechaRegistro());
				
				busquedaSingle.setId(p.getId());
				
				busquedaSingle.setDireccion(p.getDireccion());
				busquedaSingle.setDistrito(p.getDistrito());
				busquedaSingle.setFechaPerdida(null); //cambiable
				busquedaSingle.setFechaRegistro(fechaRegistro);
				busquedaSingle.setMascotaId(p.getMascota().getId());
				busquedaSingle.setTelefonoA(p.getTelefonoA());
				busquedaSingle.setTelefonoB(p.getTelefonoB());
			listaEnviar.add(busquedaSingle);
			
		}
		return listaEnviar;
	}
	
	//Obtener por id
	public BusquedaDTO obtenerPorId(int id){
		
		BusquedaModel p = busquedaRepository.findById(id).get();
		FechaUtil fechaUtil = new FechaUtil();
		
		BusquedaDTO busquedaSingle = new BusquedaDTO();
			//String fechaPerdida = fechaUtil.convertirFecha(p.getFechaPerdida());
			String fechaRegistro = fechaUtil.convertirFecha(p.getFechaRegistro());
			
			busquedaSingle.setId(p.getId());
			
			busquedaSingle.setDireccion(p.getDireccion());
			busquedaSingle.setDistrito(p.getDistrito());
			busquedaSingle.setFechaPerdida(null);
			busquedaSingle.setFechaRegistro(fechaRegistro);
			busquedaSingle.setMascotaId(p.getMascota().getId());
			busquedaSingle.setTelefonoA(p.getTelefonoA());
			busquedaSingle.setTelefonoB(p.getTelefonoB());
			
		
		return busquedaSingle;
	}
	
}





























