package domain.inscripcion

import domain.Participante
import domain.Partido

public class InscripcionSolidaria extends TipoDeInscripcion
{
	@Property int prioridad=2

	new(Participante participante) 
	{
		super(participante)
	}
	
	
	override reemplazar(Partido partido, Participante entrante, Participante saliente) {
		if(entrante.modalidad instanceof InscripcionEstandar)
		{
			//Estandar reemplaza a solidario
			return partido.reemplazar(entrante,saliente)
		}
		else
		{
			//No se si un solidario puede reemplazar a otro solidario
			return false
		}
	}
}