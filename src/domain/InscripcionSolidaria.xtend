package domain

class InscripcionSolidaria extends TipoDeInscripcion
{
	override esSolidaria()
	{
		return true;
	}
	
	override inscribirse(Partido partido, Participante participante)
	{

		if (super.inscribirse(partido, participante))
		{
			return true;	
		}
		else
		{
			if(partido.hayCondicionales())
			{
				var condicional = partido.getPrimerCondicional();
				partido.reemplazar(condicional, participante);
				return true;
			}
			
			//si no salió por ningún lado, es que no encontró forma de meterse en el partido
			throw new ImposibleAnotarseException("No hay lugar en el partido", partido, participante); // TODO hacer más interesante a esta excepción
		}
		
	
	}
}