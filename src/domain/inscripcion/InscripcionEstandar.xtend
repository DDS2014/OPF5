package domain.inscripcion

import domain.Participante
import domain.Partido

public class InscripcionEstandar extends TipoDeInscripcion{
	@Property int prioridad=1

	new(Participante participante) {
			super(participante)
		}
	 
	override reemplazar(Partido partido, Participante entrante, Participante saliente) {
		//Nadie reemplaza a estandar
		return false
	}
}