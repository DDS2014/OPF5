package domain

public class InscripcionCondicional extends TipoDeInscripcion{
	@Property int prioridad=3
	@Property Condicion condicion
	
	new(Participante participante, Condicion condicion)
	{
		super(participante)
		this.condicion=condicion
	}
	
	override inscribir(Partido partido){
		if(!condicion.seCumple(partido))
		{
			return false;
			//TODO en realidad, en vez de un return false, acá tiene que ir una excepción del tipo  "NoSeCumpleLaCondicionException"
		}
		else{
			return super.inscribir(partido)
		}
	}
	
	override reemplazar(Partido partido, Participante entrante, Participante saliente) {
		if(entrante.modalidad instanceof InscripcionEstandar || entrante.modalidad instanceof InscripcionSolidaria)
			return partido.reemplazar(entrante,saliente)//Estandar y solidaria reemplaza a condicional
		else return false//Un condicional no puede reemplazar a otro condicional
	}
	
}