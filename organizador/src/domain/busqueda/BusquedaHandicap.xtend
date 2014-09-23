package domain.busqueda 
import domain.Jugador

class BusquedaHandicap extends CriterioBusqueda{
	
	@Property double desde
	@Property double hasta
	
	new(){
		super("Handicap")
	}
	
	def override match(Jugador j){
		return j.handicap >= desde && j.handicap <= hasta
	}
}