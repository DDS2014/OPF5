package domain.busqueda 
import domain.Jugador

class BusquedaNombre extends CriterioBusqueda{
	
	@Property String nombre

	new() {
		super("Nombre")
	}
	
	def override match(Jugador j){
		if(this.nombre.nullOrEmpty)
			return true;
		j.nombre.toLowerCase.startsWith(this.nombre.toLowerCase)
	}
}