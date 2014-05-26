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
			partido.reemplazar(entrante,saliente) //recordar que si el reemplazar falla, rompe, no tira código de error
			return true;
		}
		else return false; //ponele que un solidario no puede reemplazar a otro
	}
}