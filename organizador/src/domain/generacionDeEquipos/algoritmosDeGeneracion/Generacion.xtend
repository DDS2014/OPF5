package domain.generacionDeEquipos.algoritmosDeGeneracion

import domain.Partido
import domain.excepciones.ImposibleGenerarEquiposException
import domain.Jugador
import java.util.List

abstract class Generacion {
	@Property Partido partido;
	@Property String nombreDelAlgoritmo
	
	def void generarEquipos()
	{
		if(partido.hayLugaresLibres())
		throw new ImposibleGenerarEquiposException("Todavía no se completaron los diez jugadores.");
		partido.ordenarJugadores();
		var List<Jugador> jugadoresARepartir = partido.getJugadoresConfirmados();
		this.designarJugadores(jugadoresARepartir)
	}
	
	def void designarJugadores(List<Jugador> jugadoresARepartir);
	def void enviarAlEquipoUno(Jugador jugador)
	{
		partido.agregarAlPrimerEquipo(jugador);
	}
	
	def void enviarAlEquipoDos(Jugador jugador)
	{
		partido.agregarAlSegundoEquipo(jugador);
	}
	
}