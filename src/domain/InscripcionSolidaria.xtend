package domain

class InscripcionSolidaria extends TipoDeInscripcion
{
	override inscribirse(Partido partido, Participante participante)
	{

	super.inscribirse(partido, participante); //primero ejecuto el comportamiento común
	
	//OJO: CÓDIGO REPETIDO
	
	if(partido.hayLugaresLibres() == false)
	{
		
		if(partido.hayCondicionales())
		{
			var condicional = partido.getPrimerCondicional();
			partido.reemplazar(condicional, participante);
			return;
		}
		
		//si no salió por ningún lado, es que no encontró forma de meterse en el partido
		throw new ImposibleAnotarseException("No hay lugar en el partido", partido, participante); // TODO hacer más interesante a esta excepción
	}
	
	}
}