package domain.inscripcion


import domain.Partido
import domain.Jugador

public class InscripcionEstandar extends TipoDeInscripcion{
	@Property int prioridad=1


	 
	override reemplazar(Partido partido, Jugador entrante, Jugador saliente) {
		//Nadie reemplaza a estandar
		return false
	}
}