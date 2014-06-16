package domain.generacionDeEquipos.algoritmosDeGeneracion

import domain.Partido
import domain.excepciones.ImposibleGenerarEquiposException

abstract class Generacion {
	@Property Partido partido;
	
	def void generarEquipos(){
		if(partido.hayLugaresLibres())
			throw new ImposibleGenerarEquiposException("Todavía no se completaron los diez jugadores.")
		partido.ordenarJugadores()
		this.designarJugadores()
	}
	
	def void designarJugadores(){}
}