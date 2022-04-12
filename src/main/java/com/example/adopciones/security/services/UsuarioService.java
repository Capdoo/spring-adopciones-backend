package com.example.adopciones.security.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adopciones.dto.UsuarioDTO;
import com.example.adopciones.security.models.UsuarioModel;
import com.example.adopciones.security.repositories.UsuarioRepository;


@Service
//Para implementar rollbacks y evitar incoherencia : Concurrencia
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	//Obtener
	public List<UsuarioDTO> listar(){
		List<UsuarioDTO> listaEnviar = new ArrayList<>();

		List<UsuarioModel> listaModels = usuarioRepository.findAll();
		
		for(UsuarioModel p: listaModels) {
			UsuarioDTO usuarioSingle = new UsuarioDTO();

				usuarioSingle.setApellidoMaterno(p.getApellidoMaterno());
				usuarioSingle.setApellidoPaterno(p.getApellidoPaterno());
				usuarioSingle.setDireccion(p.getDireccion());
				usuarioSingle.setDni(p.getDni());
				usuarioSingle.setEmail(p.getEmail());
				usuarioSingle.setNombres(p.getNombre());
				usuarioSingle.setNombreUsuario(p.getNombreUsuario());
				usuarioSingle.setTelefono(p.getTelefono());
				
			listaEnviar.add(usuarioSingle);
		}

		return listaEnviar;
	}
	
	
	
	//Seguridad
	public Optional<UsuarioModel> getByNombreUsuario(String nombreUsuario){
		return usuarioRepository.findByNombreUsuario(nombreUsuario);
	}
	
	public boolean existsByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.existsByNombreUsuario(nombreUsuario);
	}
	
	public boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}
	
	public void save(UsuarioModel usuarioModel) {
		usuarioRepository.save(usuarioModel);
	}
	
}











