package domain.excepciones

import domain.Participante
import domain.Partido

class NoHayLugarParaAnotarseException extends RuntimeException //TODO hacer más interesante a esta excepción
{
	Participante participante;
	Partido partido;
	
	new(String message, Partido partido, Participante participante)
	{
		this.participante = participante;
		this.partido = partido;
	}
}