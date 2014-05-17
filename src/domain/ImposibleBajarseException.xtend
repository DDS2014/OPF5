package domain

class ImposibleBajarseException extends RuntimeException 
{
	Participante participante;
	Partido partido;
	
	new(String message, Partido partido, Participante participante)
	{
		this.participante = participante;
		this.partido = partido;
	}
}