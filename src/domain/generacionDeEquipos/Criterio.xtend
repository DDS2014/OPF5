package domain.generacionDeEquipos

import domain.Jugador
import java.util.HashSet
import domain.calificaciones.Calificacion

abstract class Criterio 
{
	def double evaluarJugador(Jugador jugador);	
	
	def double promediarCalificaciones(HashSet<Calificacion> calificacionesAPromediar)
	{
		var suma = 0;
		var puntajesAPromediar = calificacionesAPromediar.map[calif | calif.getPuntaje()]
		
		for(puntaje:puntajesAPromediar)
		{
			suma = suma + puntaje;
		}
	
		return suma;
	}
}