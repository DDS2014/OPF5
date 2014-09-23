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
		if(j!=null && !j.apodo.nullOrEmpty)
			j.apodo.contains(this.apodo)
		else
			return false
	}
	
}