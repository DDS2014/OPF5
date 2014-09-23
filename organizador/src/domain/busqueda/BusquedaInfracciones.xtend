package domain.busqueda
import domain.Jugador

class BusquedaInfracciones extends CriterioBusqueda {
	
	@Property Boolean conInfraccion
	
	new(String descripcion, Boolean conInfraccion){
		super(descripcion)
		this.conInfraccion = conInfraccion
	}
	
	def override match(Jugador j){
		if(conInfraccion != null)
		{
		if(conInfraccion)
			return j.tieneInfracciones
		else
			return!j.tieneInfracciones
		}
		else
			return true
	}
	
}