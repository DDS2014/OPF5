package domain

class Participante 
{
	Jugador jugador;
	TipoDeInscripcion modalidad;
	
	new(Jugador jugador, TipoDeInscripcion modalidad) 
	{
		this.jugador = jugador;
		this.modalidad = modalidad;
	}
	
	def inscribirse(Partido partido) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
		
}