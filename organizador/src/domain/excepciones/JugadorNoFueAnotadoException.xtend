package domain.excepciones

import domain.Jugador
import domain.Partido

//esto es demasiado genérico, me dice que por X razón un jugador no fue anotado...
class JugadorNoFueAnotadoException extends RuntimeException 
{
	Jugador participante;
	Partido partido;
	
	new(String message, Partido partido, Jugador participante)
	{
		this.participante = participante;
		this.partido = partido;
	}
}