package domain.busqueda 
import domain.Jugador
import org.uqbar.commons.model.UserException

class BusquedaPromedio extends CriterioBusqueda{
	@Property Double desde
	@Property Double hasta
	
	new(){
		super("Promedio")
	}
	
	def override match(Jugador j){
		val promedio = j.promedioUltimoPartido
		return promedio >= desde && promedio <= hasta
	}
	
	def override validar(){
		if(desde == null)
			throw new UserException("Debe ingresar un número en el campo desde.")
		
		if(hasta == null)
			throw new UserException("Debe ingresar un número en el campo hasta.")
		
		if(desde>hasta)
			throw new UserException("El campo desde no puede ser mayor al campo hasta.")
	}
}