package domain.generacionDeEquipos

import domain.Jugador
import domain.calificaciones.Calificacion

import java.util.Collection

abstract class Criterio 
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
}