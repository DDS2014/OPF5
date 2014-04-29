package domain

class InscripcionEstandar extends TipoDeInscripcion
{
	override inscribirse(Partido partido, Participante participante)
	{

	super.inscribirse(partido, participante); //primero ejecuto el comportamiento común
	
	if(partido.hayLugaresLibres() == false)
	{
		
		if(partido.hayCondicionales())
		{
			var condicional = partido.getPrimerCondicional();
			partido.reemplazar(condicional, participante);
			return;
		}
		
		if(partido.haySolidarios())
		{
			var solidario = partido.getPrimerSolidario();
			partido.reemplazar(solidario, participante);
			return;
		}
		//si no salió por ningún lado, es que no encontró forma de meterse en el partido
		throw new RuntimeException("No hay lugar en el partido"); //TODO PONER UNA EXCEPCIÓN POSTA, PERSONALIZADA
		
		}
	
	}

}