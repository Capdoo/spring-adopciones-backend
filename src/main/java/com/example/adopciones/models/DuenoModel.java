package com.example.adopciones.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

import com.example.adopciones.security.models.UsuarioModel;

@Entity
@Table(name="dueños")
public class DuenoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	//Id del usuario (OneToOne)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "DUEÑO_FK_EMPLEADO"))
	private UsuarioModel usuario;
	
	
	private String fechaRegistro;
	private int numeroMascotas;
	
	//Secundarios
	private int rate;
	private int historial_id;
	
	
	
	public DuenoModel() {
		super();
	}

	public DuenoModel(int id, UsuarioModel usuario, String fechaRegistro, int numeroMascotas, int rate,
			int historial_id) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fechaRegistro = fechaRegistro;
		this.numeroMascotas = numeroMascotas;
		this.rate = rate;
		this.historial_id = historial_id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UsuarioModel getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getNumeroMascotas() {
		return numeroMascotas;
	}
	public void setNumeroMascotas(int numeroMascotas) {
		this.numeroMascotas = numeroMascotas;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getHistorial_id() {
		return historial_id;
	}
	public void setHistorial_id(int historial_id) {
		this.historial_id = historial_id;
	}

	
	
	
	
}
