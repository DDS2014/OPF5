package domain.generacionDeEquipos.criteriosDeEvaluacion

import domain.Jugador
import java.io.Serializable

class CriterioDelHandicap extends Criterio implements Serializable
{
	new()
	{
		nombreDelCriterio = "Handicap"
	}
	
	override evaluarJugador(Jugador jugador)
	{
		return jugador.getHandicap(); //todo agregar excepciones?
	}
	
}