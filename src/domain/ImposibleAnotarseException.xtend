package domain

class ImposibleAnotarseException extends RuntimeException //TODO hacer más interesante a esta excepción
{
	Participante participante;
	Partido partido;
	
	new(String message, Partido partido, Participante participante)
	{
		this.participante = participante;
		this.partido = partido;
	}
}