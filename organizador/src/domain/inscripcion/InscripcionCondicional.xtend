package domain.inscripcion

import domain.Jugador
import domain.Partido
import domain.excepciones.NoSeCumpleLaCondicionParaAnotarseException
import domain.inscripcion.condiciones.Condicion

public class InscripcionCondicional extends TipoDeInscripcion{
	//int prioridad=3
	@Property Condicion condicion
	
	new(Condicion condicion)
	{
		this.condicion=condicion
	}
	
	override inscribir(Jugador participante, Partido partido){
		if(!condicion.seCumple(partido))
		{
			throw new NoSeCumpleLaCondicionParaAnotarseException("No se cumplió la condición que exigía este jugador para anotarse", partido, participante);
		}
		else
		{
			super.inscribir(participante,partido)
		}
	}
	
	override reemplazar(Partido partido, Jugador entrante, Jugador saliente) 
	{
		if(entrante.modalidad instanceof InscripcionEstandar || entrante.modalidad instanceof InscripcionSolidaria)
			{
				partido.reemplazar(entrante,saliente)
				return true;
			} //Estandar y solidaria reemplaza a condicional
		else return false//Un condicional no puede reemplazar a otro condicional
	}
	
}