package domain.generacionDeEquipos.criteriosDeEvaluacion

import domain.Jugador
import domain.excepciones.ImposibleEvaluarException

class CriterioDeLasUltimasCalificaciones extends Criterio
{
	int cantidadDeCalificaciones;
	
	new(int cantidadDeCalificaciones)
	{
		nombreDelCriterio = "Ultimas N calificaciones"
		if (cantidadDeCalificaciones < 0) throw new RuntimeException("Debe especificar un número positivo de calificaciones a tener en cuenta"); //todo vale la pena una excepcion especifica para esto?		
		this.cantidadDeCalificaciones = cantidadDeCalificaciones;
	}
	
	override evaluarJugador(Jugador jugador) 
	{
		if (jugador.getCalificaciones.length() < cantidadDeCalificaciones) throw new ImposibleEvaluarException("El jugador tiene menos calificaciones de las que se pidieron tener en cuenta");
		var calificacionesAConsiderar = jugador.getCalificaciones.subList(0, cantidadDeCalificaciones);
		return this.promediarCalificaciones(calificacionesAConsiderar);
	}
}