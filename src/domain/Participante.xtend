package domain

import java.util.Date

public class Participante {
	@Property Jugador jugador
	@Property Date fechaInscripcion//Por ahora no se esta usando
	@Property TipoDeInscripcion modalidad
	
	new(Jugador jugador){
		this.jugador=jugador
		this.fechaInscripcion=new Date
	}
	
	
	def inscribirse(Partido partido)
	{
		modalidad.inscribir(partido);
	}
	
	def bajarse(Partido partido)
	{
		partido.quitarSinReemplazo(this);
	}
	
	def bajarse(Partido partido, Participante reemplazante)
	{
		partido.reemplazar(reemplazante, this);
	}
	
}