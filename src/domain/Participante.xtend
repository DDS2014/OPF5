package domain

class Participante 
{
	@Property Jugador jugador;
	@Property TipoDeInscripcion modalidad;
	
	new(Jugador jugador, TipoDeInscripcion modalidad) 
	{
		this.jugador = jugador;
		this.modalidad = modalidad;
	}
	
	def inscribirse(Partido partido) 
	{
		this.modalidad.inscribirse(partido, this);
	}
		
}