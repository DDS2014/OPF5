package domain.busqueda

import java.util.Date
import domain.Jugador
import org.uqbar.commons.model.UserException

class BusquedaEdad extends CriterioBusqueda{
	
	@Property Date fecha
	
	new(){
		super("Fecha de Nacimiento")
	}
	
	def override match(Jugador j){
		return j.fechaNacimiento < this.fecha
	}
	
	def override validar(){
		if(fecha == null)
			throw new UserException("Debe ingresar una fecha.")
	}
}