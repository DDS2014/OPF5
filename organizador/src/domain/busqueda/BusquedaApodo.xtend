package domain.busqueda 
import domain.Jugador

class BusquedaApodo extends CriterioBusqueda {
	
	@Property String apodo
	
	new(){
		super("Apodo")
	}
	
	def override match(Jugador j){
		if(this.apodo.nullOrEmpty)
			return true;
		j.apodo.toLowerCase.contains(this.apodo.toLowerCase)
	}
}