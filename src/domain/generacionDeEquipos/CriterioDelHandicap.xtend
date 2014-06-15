package domain.generacionDeEquipos

import domain.Jugador

class CriterioDelHandicap extends Criterio
{
	
	override evaluarJugador(Jugador jugador)
	{
		return jugador.getHandicap(); //todo agregar excepciones?
	}
	
}