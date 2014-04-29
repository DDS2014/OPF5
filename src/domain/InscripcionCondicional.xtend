package domain

class InscripcionCondicional extends TipoDeInscripcion
{
	
	override inscribirse(Partido partido, Participante participante)
	{
		
		//TODO: antes de ejecutar el super, preguntar por la condicion!
		//si la condición no se cumple, el jugador no va a querer inscribirse y debe tirarse una excepción acá
			
		super.inscribirse(partido, participante); 
		
		if(partido.hayLugaresLibres() == false)
		{
			throw new ImposibleAnotarseException("No hay lugar en el partido", partido, participante);
		
		}
		
	}
		
}