package domain.sugerencias

import java.util.Date

public class Denegacion {
	@Property Date fecha
	@Property String motivo
	@Property Sugerencia sugerencia
	
	new(Sugerencia sugerencia,String motivo){
		this.fecha = new Date;
		this.motivo=motivo;
		this.sugerencia=sugerencia;
	}
}