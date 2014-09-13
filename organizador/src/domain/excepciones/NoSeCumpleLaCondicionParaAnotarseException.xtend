package domain.excepciones

import domain.Jugador
import domain.Partido

class NoSeCumpleLaCondicionParaAnotarseException extends RuntimeException //TODO hacer más interesante a esta excepción
{
	Jugador participante;
	Partido partido;
	
	new(String message, Partido partido, Jugador participante)
	{
		this.participante = participante;
		this.partido = partido;
	}
}

//el codigo está copypasteado de la otra excepción... eso no puede estar bien