package domain

public class InscripcionEstandar extends TipoDeInscripcion{
	@Property int prioridad=1
	
	override reemplazar(Partido partido, Participante entrante, Participante saliente) {
		//Nadie reemplaza a estandar
		return false
	}
}