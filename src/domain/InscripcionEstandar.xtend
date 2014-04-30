package domain

class InscripcionEstandar extends TipoDeInscripcion
{
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
			
			if(partido.haySolidarios())
			{
				var solidario = partido.getPrimerSolidario();
				partido.reemplazar(solidario, participante);
				return true;
			}
			//si no salió por ningún lado, es que no encontró forma de meterse en el partido
			throw new ImposibleAnotarseException("No hay lugar en el partido", partido, participante);
			
		}
	
	}
	

}