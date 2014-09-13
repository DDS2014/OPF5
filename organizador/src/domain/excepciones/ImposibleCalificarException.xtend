package domain.excepciones

import domain.Jugador
import domain.Partido

class ImposibleCalificarException extends RuntimeException{
	Jugador participante;
	Partido partido;
	
	new(String message, Partido partido, Jugador participante)
	{
		this.participante = participante;
		this.partido = partido;
	}
}