package domain.busqueda 
import java.util.List
import domain.Jugador
import org.uqbar.commons.model.Entity

abstract class CriterioBusqueda extends Entity {
	@Property String descripcion
	
	new(String descripcion){
		this.descripcion = descripcion
	}
	
	def List<Jugador> buscar(List<Jugador> jugadores){
		this.validar
		jugadores.filter[j|match(j)].toList()
	}
	
	def validar(){
		
	}
	
	def Boolean match(Jugador j){
		return true;
	}
	
	override def toString() {
		this.descripcion
	}
}