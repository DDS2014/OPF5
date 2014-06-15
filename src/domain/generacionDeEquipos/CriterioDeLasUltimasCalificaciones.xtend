package domain.generacionDeEquipos

import domain.Jugador

class CriterioDeLasUltimasCalificaciones extends Criterio
{
	int cantidadDeCalificaciones;
	
	new(int cantidadDeCalificaciones)
	{
		if (cantidadDeCalificaciones < 0) throw new RuntimeException("Debe especificar un número positivo de calificaciones a tener en cuenta"); //todo vale la pena una excepcion especifica para esto?		
		this.cantidadDeCalificaciones = cantidadDeCalificaciones;
	}
	
	override evaluarJugador(Jugador jugador) 
	{

		
		return 2.0;
	}

	
}