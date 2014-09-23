package domain.busqueda 
import domain.Jugador
import org.uqbar.commons.model.UserException

class BusquedaHandicap extends CriterioBusqueda{
	
	@Property Double desde
	@Property Double hasta
	
	new(){
		super("Handicap")
	}
	
	def override match(Jugador j){
		if(hasta!=null)
			return j.handicap >= desde && j.handicap <= hasta
		else
			return j.handicap >= desde
	}
	
	def override validar(){
		if(desde == null)
			throw new UserException("Debe ingresar un número en el campo desde.")
		
		if(hasta!=null && desde>hasta)
			throw new UserException("El campo desde no puede ser mayor al campo hasta.")
	}
}