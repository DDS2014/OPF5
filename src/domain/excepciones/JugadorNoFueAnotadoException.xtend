package domain.excepciones

import domain.Participante
import domain.Partido

//esto es demasiado genérico, me dice que por X razón un jugador no fue anotado...
class JugadorNoFueAnotadoException extends RuntimeException 
{
	Participante participante;
	Partido partido;
	
	new(String message, Partido partido, Participante participante)
	{
		this.participante = participante;
		this.partido = partido;
	}
}