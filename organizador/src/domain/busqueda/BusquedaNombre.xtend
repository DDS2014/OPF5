package domain.busqueda 
import domain.Jugador
import java.util.List

class BusquedaNombre extends CriterioBusqueda{
	
	@Property String nombreABuscar
	
	new (String nombre){
		this.nombreABuscar = nombre
	}
	
	def override match(Jugador j){
		j.nombre.startsWith(this.nombreABuscar)
	}
}