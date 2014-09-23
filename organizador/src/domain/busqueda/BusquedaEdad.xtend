package domain.busqueda

import java.util.Date
import domain.Jugador

class BusquedaEdad extends CriterioBusqueda{
	
	@Property Date fecha
	
	new(){
		super("Fecha de Nacimiento")
	}
	
	def override match(Jugador j){
		if(this.fecha != null)
			return j.fechaNacimiento < this.fecha
		else
			return true
	}
}