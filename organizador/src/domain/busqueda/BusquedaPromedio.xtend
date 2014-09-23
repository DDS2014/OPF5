package domain.busqueda 
import domain.Jugador

class BusquedaPromedio extends CriterioBusqueda{
	@Property double desde
	@Property double hasta
	
	new(){
		super("Promedio")
	}
	
	def override match(Jugador j){
		val promedio = j.promedioUltimoPartido
		return promedio >= desde && promedio <= hasta
	}
}