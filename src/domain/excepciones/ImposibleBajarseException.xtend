package domain.excepciones

import domain.Participante
import domain.EventoDeportivo

class ImposibleBajarseException extends RuntimeException 
{
	Participante participante;
	EventoDeportivo partido;
	
	new(String message, EventoDeportivo partido, Participante participante)
	{
		this.participante = participante;
		this.partido = partido;
	}
}