package domain.busqueda 
import java.util.List
import domain.Jugador

abstract class CriterioBusqueda {
	
	new(){
	}
	
	def List<Jugador> buscar(List<Jugador> jugadores){
		jugadores.filter[j|match(j)].toList()
	}
	
	def Boolean match(Jugador j);
}