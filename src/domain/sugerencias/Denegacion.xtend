package domain.sugerencias

import java.util.Date

public class Denegacion {
	@Property String nombre;
	@Property Date fecha;
	@Property String motivo;

	
	new(String nombre, String motivo){
		this.fecha = new Date;
		this.motivo=motivo;
		this.nombre = nombre;
	}
}