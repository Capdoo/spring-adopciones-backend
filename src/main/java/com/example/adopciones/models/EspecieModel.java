package com.example.adopciones.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="especies")
public class EspecieModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;

	@OneToOne(cascade =  CascadeType.ALL, mappedBy = "especie")
	private MascotaModel mascota;

	public EspecieModel() {
		super();
	}
	
	
	public EspecieModel(int id, String nombre, MascotaModel mascota) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mascota = mascota;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public MascotaModel getMascota() {
		return mascota;
	}

	public void setMascota(MascotaModel mascota) {
		this.mascota = mascota;
	}

}
