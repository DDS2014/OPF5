package Domain

import java.util.Date

public class Participante {
	@Property Jugador jugador
	@Property Date fechaInscripcion//Por ahora no se esta usando
	@Property TipoDeInscripcion modalidad
	
	new(Jugador jugador, TipoDeInscripcion modalidad){
		this.jugador=jugador
		this.fechaInscripcion=new Date
		this.modalidad=modalidad
	}
	
	def boolean inscribirse(Partido partido){
		modalidad.inscribir(partido,this)
	}
}