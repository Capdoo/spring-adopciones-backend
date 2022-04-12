package com.example.adopciones.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mascotas")
public class MascotaModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	private String genero;
	private int edad;
	private String fechaRegistro;
	private String color;
	private String caracteristica;
	private String tamano;
	
	//Insertado por el usuario para no saturar la bd
	private String raza;
	
	@ManyToOne
	@JoinColumn(name="dueño_id",referencedColumnName = "id", nullable=false)
	private DuenoModel dueno;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "detalle_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "MASCOTA_FK_DETALLE"))
	private DetalleModel detalle;

	public MascotaModel() {
		super();
	}
	
	public MascotaModel(int id, String nombre, String genero, int edad, String fechaRegistro, String color,
			String caracteristica, String tamano, String raza, DuenoModel dueno, DetalleModel detalle) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
		this.fechaRegistro = fechaRegistro;
		this.color = color;
		this.caracteristica = caracteristica;
		this.tamano = tamano;
		this.raza = raza;
		this.dueno = dueno;
		this.detalle = detalle;
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


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public DuenoModel getDueno() {
		return dueno;
	}


	public void setDueno(DuenoModel dueno) {
		this.dueno = dueno;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public DetalleModel getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleModel detalle) {
		this.detalle = detalle;
	}

	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}

	

}
