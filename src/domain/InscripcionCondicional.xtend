package domain

public class InscripcionCondicional extends TipoDeInscripcion{
	@Property int prioridad=3
	@Property Condicion condicion
	
	new(Condicion condicion){
		this.condicion=condicion
	}
	
	override inscribir(Partido partido,Participante participante){
		if(!condicion.seCumple(partido))
		{
			return false;
		}
		else{
			return super.inscribir(partido,participante)
		}
	}
	
	override reemplazar(Partido partido, Participante entrante, Participante saliente) {
		if(entrante.modalidad instanceof InscripcionEstandar || entrante.modalidad instanceof InscripcionSolidaria)
			return partido.reemplazar(entrante,saliente)//Estandar y solidaria reemplaza a condicional
		else return false//Un condicional no puede reemplazar a otro condicional
	}
	
}