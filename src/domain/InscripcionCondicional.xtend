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
			throw new NoSeCumpleLaCondicionParaAnotarseException("No se cumplió la condición que exigía este participante para anotarse", partido, participante);
		}
		else
		{
			super.inscribir(partido)
		}
	}
	
	override reemplazar(Partido partido, Participante entrante, Participante saliente) 
	{
		if(entrante.modalidad instanceof InscripcionEstandar || entrante.modalidad instanceof InscripcionSolidaria)
			return partido.reemplazar(entrante,saliente)//Estandar y solidaria reemplaza a condicional
		else return false//Un condicional no puede reemplazar a otro condicional
	}
	
}