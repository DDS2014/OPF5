package domain.generacionDeEquipos.criteriosDeEvaluacion

import domain.Jugador

class CriterioDelHandicap extends Criterio
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