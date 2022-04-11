package com.example.adopciones.dto;

public class MascotaDTO {
	
	private String nombre;
	private String genero;
	private int edad;
	private String fechaRegistro;
	private int idDueno;
	
	public MascotaDTO() {
		super();
	}
	
	public MascotaDTO(String nombre, String genero, int edad, String fechaRegistro, int idDueno) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
		this.fechaRegistro = fechaRegistro;
		this.idDueno = idDueno;
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
	public int getIdDueno() {
		return idDueno;
	}
	public void setIdDueno(int idDueno) {
		this.idDueno = idDueno;
	}


}
