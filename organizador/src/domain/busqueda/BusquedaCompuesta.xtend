package domain.busqueda
import domain.Jugador
import java.util.List
import java.util.ArrayList

class BusquedaCompuesta extends CriterioBusqueda {
	
	@Property List<CriterioBusqueda> criterios
	
	new(String descripcion) {
		super(descripcion)
		this.criterios = new ArrayList<CriterioBusqueda>
	}
	
	def override match(Jugador j){
		criterios.forall[c|c.match(j)]
	}
}