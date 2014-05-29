package domain.excepciones

import domain.Partido
import domain.Jugador

class ImposibleBajarseException extends RuntimeException 
{
	Jugador participante;
	Partido partido;
	
	new(String message, Partido partido, Jugador participante)
	{
		this.participante = participante;
		this.partido = partido;
	}
}