package domain

import java.util.Date

class Participante
{
	@Property Jugador jugador;
	@Property TipoDeInscripcion modalidad;
	@Property Date fecha;
	
	new(Jugador jugador, TipoDeInscripcion modalidad) 
	{
		this.jugador = jugador;
		this.modalidad = modalidad;
		this.fecha = new Date();
	}
	
	def inscribirse(Partido partido) 
	{
		this.modalidad.inscribirse(partido, this);
	}
	
	def boolean sosCondicional() 
	{
		return modalidad.esCondicional();
	}
	
	def boolean sosSolidario()
	{
		return modalidad.esSolidaria();
	}

	 
}