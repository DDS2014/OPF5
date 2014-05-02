package Domain

public class InscripcionSolidaria extends TipoDeInscripcion{
	@Property int prioridad=2
	
	override reemplazar(Partido partido, Participante entrante, Participante saliente) {
		if(entrante.modalidad instanceof InscripcionEstandar)
		{
			//Estandar reemplaza a solidario
			return partido.reemplazar(entrante,saliente)
		}
		else{
			//No se si un solidario puede reemplazar a otro solidario
			return false
		}
	}
}