package domain.generacionDeEquipos.criteriosDeEvaluacion

import domain.Jugador
import domain.excepciones.ImposibleEvaluarException
import org.uqbar.commons.model.UserException
import java.io.Serializable

class CriterioDeLasUltimasCalificaciones extends Criterio implements Serializable
{
	@Property int cantidadDeCalificaciones;
	
	new()
	{
		nombreDelCriterio = "Ultimas N calificaciones"
		this.cantidadDeCalificaciones = 0; //????? misterio
	}
	
	new(int cantidadDeCalificaciones)
	{		
		this.cantidadDeCalificaciones = cantidadDeCalificaciones;
	}
	
	override evaluarJugador(Jugador jugador) 
	{
		if (cantidadDeCalificaciones <= 0) throw new UserException("Debe especificar un número positivo de calificaciones a tener en cuenta"); //todo vale la pena una excepcion especifica para esto?		
		if (jugador.getCalificaciones.length() < cantidadDeCalificaciones) throw new ImposibleEvaluarException("El jugador tiene menos calificaciones de las que se pidieron tener en cuenta");
		var calificacionesAConsiderar = jugador.getCalificaciones.subList(0, cantidadDeCalificaciones);
		return this.promediarCalificaciones(calificacionesAConsiderar);
	}
}