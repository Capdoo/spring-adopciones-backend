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
import com.example.adopciones.utils.StringUtil;

@Service
public class BusquedaService {
	
	@Autowired
	BusquedaRepository busquedaRepository;
	
	@Autowired
	MascotaRepository mascotaRepository;

	public void save(BusquedaDTO busquedaDTO) {
		
		FechaUtil fechaUtil = new FechaUtil();
		MascotaModel mascotaSeleccionada = mascotaRepository.findById(busquedaDTO.getMascotaId()).get();
		
		BusquedaModel busquedaNueva = new BusquedaModel();
			busquedaNueva.setDireccion(busquedaDTO.getDireccion());
			busquedaNueva.setDistrito(busquedaDTO.getDistrito());
		
				Timestamp fechaPerdida = fechaUtil.obtenerTimeStampDeFecha(busquedaDTO.getFechaPerdida());
				busquedaNueva.setFechaPerdida(fechaPerdida);
			
			busquedaNueva.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
			busquedaNueva.setMascota(mascotaSeleccionada);
			
			busquedaNueva.setTelefonoA(busquedaDTO.getTelefonoA());
			busquedaNueva.setTelefonoB(busquedaDTO.getTelefonoB());
			
			busquedaNueva.setMensaje(busquedaDTO.getMensaje());
		busquedaRepository.save(busquedaNueva);
	}
	
	//Obtener todos
	public List<BusquedaDTO> listar(){
		List<BusquedaDTO> listaEnviar = new ArrayList<>();
		List<BusquedaModel> listaBD = busquedaRepository.findAll();

		
		for(BusquedaModel p : listaBD) {
			FechaUtil fechaUtil = new FechaUtil();
			StringUtil stringUtil = new StringUtil();
			BusquedaDTO busquedaSingle = new BusquedaDTO();

				busquedaSingle.setId(p.getId());
				busquedaSingle.setDireccion(p.getDireccion());
				busquedaSingle.setDistrito(p.getDistrito());
				
					String fechaPerdida = fechaUtil.convertirFecha(p.getFechaPerdida());
					busquedaSingle.setFechaPerdida(fechaPerdida);
					
					String fechaRegistro = fechaUtil.convertirFecha(p.getFechaRegistro());
					busquedaSingle.setFechaRegistro(fechaRegistro);
				
				busquedaSingle.setMascotaId(p.getMascota().getId());
				busquedaSingle.setTelefonoA(p.getTelefonoA());
				busquedaSingle.setTelefonoB(p.getTelefonoB());
				busquedaSingle.setMensaje(p.getMensaje());
				
				//Nuevo: Nombre y raza (especie)
				busquedaSingle.setNombreMascota(p.getMascota().getNombre());
				if(p.getMascota().getDetalle() != null) {
					busquedaSingle.setEspecieMascota(p.getMascota().getDetalle().getEspecie());
					busquedaSingle.setRazaMascota(p.getMascota().getDetalle().getRaza());
				}else {
					busquedaSingle.setEspecieMascota(stringUtil.obtenerEspecieToken(p.getMascota().getRazaEspecifica()));
					busquedaSingle.setRazaMascota(stringUtil.obtenerRazaToken(p.getMascota().getRazaEspecifica()));
				}
				
			listaEnviar.add(busquedaSingle);
			
		}
		return listaEnviar;
	}
	
	//Obtener por mascota_id
	public List<BusquedaDTO> obtenerPorMascotaId(int mascotaId){
		List<BusquedaDTO> listaEnviar = new ArrayList<>();
		MascotaModel mascotaSeleccionada = mascotaRepository.findById(mascotaId).get();
		
		List<BusquedaModel> listaBD = busquedaRepository.findAllByMascota(mascotaSeleccionada);
		
		for(BusquedaModel p : listaBD) {
			BusquedaDTO busquedaSingle = new BusquedaDTO();
			FechaUtil fechaUtil = new FechaUtil();

				busquedaSingle.setId(p.getId());
				busquedaSingle.setDireccion(p.getDireccion());
				busquedaSingle.setDistrito(p.getDistrito());
					String fechaPerdida = fechaUtil.convertirFecha(p.getFechaPerdida());
					busquedaSingle.setFechaPerdida(fechaPerdida);
					
					String fechaRegistro = fechaUtil.convertirFecha(p.getFechaRegistro());
					busquedaSingle.setFechaRegistro(fechaRegistro);
					
				busquedaSingle.setMascotaId(p.getMascota().getId());
				busquedaSingle.setTelefonoA(p.getTelefonoA());
				busquedaSingle.setTelefonoB(p.getTelefonoB());
				busquedaSingle.setMensaje(p.getMensaje());
			listaEnviar.add(busquedaSingle);
			
		}
		return listaEnviar;
	}
	
	//Obtener por id
	public BusquedaDTO obtenerPorId(int id){
		
		BusquedaModel p = busquedaRepository.findById(id).get();
		
		BusquedaDTO busquedaSingle = new BusquedaDTO();
			FechaUtil fechaUtil = new FechaUtil();

			busquedaSingle.setId(p.getId());
			
			busquedaSingle.setDireccion(p.getDireccion());
			busquedaSingle.setDistrito(p.getDistrito());
				String fechaPerdida = fechaUtil.convertirFecha(p.getFechaPerdida());
				busquedaSingle.setFechaPerdida(fechaPerdida);
				
				String fechaRegistro = fechaUtil.convertirFecha(p.getFechaRegistro());
				busquedaSingle.setFechaRegistro(fechaRegistro);
			busquedaSingle.setMascotaId(p.getMascota().getId());
			busquedaSingle.setTelefonoA(p.getTelefonoA());
			busquedaSingle.setTelefonoB(p.getTelefonoB());
			
			busquedaSingle.setMensaje(p.getMensaje());

		return busquedaSingle;
	}
	
}





























