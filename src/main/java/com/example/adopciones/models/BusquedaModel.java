package com.example.adopciones.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="busquedas")
public class BusquedaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String direccion;
	private String distrito;
	private Timestamp fechaRegistro;
	private Timestamp fechaPerdida;
	private String telefonoA;
	private String telefonoB;
	
	@ManyToOne
	@JoinColumn(name="mascota_id",referencedColumnName = "id", nullable=false)
	private MascotaModel mascota;

	public BusquedaModel() {
		super();
	}
	
	public BusquedaModel(String direccion, String distrito, Timestamp fechaRegistro, Timestamp fechaPerdida,String telefonoA,
			String telefonoB, MascotaModel mascota) {
		super();
		this.direccion = direccion;
		this.distrito = distrito;
		this.fechaRegistro = fechaRegistro;
		this.fechaPerdida = fechaPerdida;
		this.telefonoA = telefonoA;
		this.telefonoB = telefonoB;
		this.mascota = mascota;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public Timestamp getFechaPerdida() {
		return fechaPerdida;
	}

	public void setFechaPerdida(Timestamp fechaPerdida) {
		this.fechaPerdida = fechaPerdida;
	}

	public String getTelefonoA() {
		return telefonoA;
	}

	public void setTelefonoA(String telefonoA) {
		this.telefonoA = telefonoA;
	}

	public String getTelefonoB() {
		return telefonoB;
	}

	public void setTelefonoB(String telefonoB) {
		this.telefonoB = telefonoB;
	}

	public MascotaModel getMascota() {
		return mascota;
	}

	public void setMascota(MascotaModel mascota) {
		this.mascota = mascota;
	}

	
}
