package com.example.adopciones.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FechaUtil {
private int id;
	
	public FechaUtil() {
		super();
	}

	public FechaUtil(int id) {
		super();
		this.id = id;
	}

	//Convertir TimeStamp en fecha String
	
	public String obtenerFechaDeTimeStamp(Timestamp mytimestamp) {
		return new SimpleDateFormat("MM/dd/yyyy").format(mytimestamp);
	}
	
	public String convertirFecha(Timestamp mytimestamp) {
		return new SimpleDateFormat("dd/MM/yyyy").format(mytimestamp);
	}


}
