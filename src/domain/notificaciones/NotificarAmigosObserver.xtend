package domain.notificaciones

import domain.Participante
import domain.Jugador
import domain.Partido

class NotificarAmigosObserver implements PartidoObserver {
	
	def override avisarInscripcionDeJugador(Partido partido, Jugador jugador, boolean habiaLugar){
	
		val subject = "Me anote a un partido!"
		val body = jugador.nombre+" se inscribió al partido del "+partido.fecha.toString();
		
		jugador.amigos.forEach[j|partido.distribuidor.enviarMail(j.email,subject,body)]
	}
	
	override avisarQuitaSinReemplazo(Partido partido, String mailAdmin, Participante participante, Boolean estabaConfirmado) {
		
	}
}