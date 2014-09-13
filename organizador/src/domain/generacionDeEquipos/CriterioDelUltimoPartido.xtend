package domain.generacionDeEquipos

import domain.Jugador
import domain.sugerencias.Comunidad
import java.util.ArrayList

class CriterioDelUltimoPartido extends Criterio
{
	Comunidad comunidad; //lleva una comunidad porque es la entidad que engloba los partidos y necesito saber cuál fué el último partido jugado
	
	new(Comunidad comunidad)
	{
		this.comunidad = comunidad;
	}	
	override evaluarJugador(Jugador jugador) 
	{
		var calificacionesAConsiderar = new ArrayList();
		var iterableCalificaciones	= (jugador.calificaciones.filter[calif | calif.partido == comunidad.ultimoPartido()]); //explicame por que si filtro una coleccion no obtengo otra coleccion
		for(calificacion:iterableCalificaciones)
		{
			calificacionesAConsiderar.add(calificacion);
		}
		return this.promediarCalificaciones(calificacionesAConsiderar); //esto es código repetido, sin embargo no creo que valga la pena juntar los dos criterios que usan esto en una superclase abstracta CriterioQuePromediaCosas		
	}
	
	
}