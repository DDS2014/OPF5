package domain.generacionDeEquipos.criteriosDeEvaluacion

import domain.Jugador
import domain.sugerencias.Comunidad
import java.util.ArrayList
import java.io.Serializable

class CriterioDelUltimoPartido extends Criterio implements Serializable
{
	Comunidad comunidad; //lleva una comunidad porque es la entidad que engloba los partidos y necesito saber cuál fué el último partido jugado
	
	new(Comunidad comunidad)
	{
		nombreDelCriterio = "Promedio del ultimo partido"
		this.comunidad = comunidad;
	}	
	override evaluarJugador(Jugador jugador) 
	{
		var calificacionesAConsiderar = new ArrayList();
		var iterableCalificaciones	= (jugador.getCalificaciones.filter[calif | calif.getPartido == comunidad.ultimoPartido()]); //explicame por que si filtro una coleccion no obtengo otra coleccion
		for(calificacion:iterableCalificaciones)
		{
			calificacionesAConsiderar.add(calificacion);
		}
		return this.promediarCalificaciones(calificacionesAConsiderar); //esto es código repetido, sin embargo no creo que valga la pena juntar los dos criterios que usan esto en una superclase abstracta CriterioQuePromediaCosas		
	}
	
	
}