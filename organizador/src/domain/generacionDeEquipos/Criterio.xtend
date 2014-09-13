package domain.generacionDeEquipos

import domain.Jugador
import domain.calificaciones.Calificacion
import java.util.Collection
import java.util.Comparator

abstract class Criterio implements Comparator<Jugador>
{
	def double evaluarJugador(Jugador jugador);	
	
	def double promediarCalificaciones(Collection<Calificacion> calificacionesAPromediar)
	{
		var suma = 0 as double;
		var cantidadAPromediar = calificacionesAPromediar.length();
		var puntajesAPromediar = calificacionesAPromediar.map[calif | calif.getPuntaje()]
		
		for(puntaje:puntajesAPromediar)
		{
			suma = suma + puntaje;
		}
	
		return suma/cantidadAPromediar;
	}
	
	override compare(Jugador arg0, Jugador arg1)  //permito ordenar los jugadores de mayor a menor puntaje de evaluacion
	{
		if (this.evaluarJugador(arg0) > evaluarJugador(arg1))
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
}