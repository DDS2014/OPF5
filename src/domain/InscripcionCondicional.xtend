package domain

class InscripcionCondicional extends TipoDeInscripcion
{
	override esCondicional()
	{
		return true;
	}
	
	override inscribirse(Partido partido, Participante participante)
	{
		
		//TODO: antes de ejecutar el super, preguntar por la condicion!
		//si la condición no se cumple, el jugador no va a querer inscribirse y debe tirarse una excepción acá
			
		if (super.inscribirse(partido, participante)) //primero ejecuto el comportamiento común
		{
			return true;
		}
		
		else
		{
			throw new ImposibleAnotarseException("No hay lugar en el partido", partido, participante);
		
		}
		
	}
		
}