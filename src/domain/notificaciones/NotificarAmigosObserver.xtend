package domain.notificaciones

import domain.Participante
import domain.Jugador
import domain.Partido

class NotificarAmigosObserver implements PartidoObserver {
	
	def override inscribir(Partido partido, Jugador jugador, boolean habiaLugar){
	
		val subject = "Partido Confirmado"
		val body = "Todas las plazas del partido fueron confirmadas"  
		
		jugador.amigos.forEach[j|partido.distribuidor.enviarMail(j.email,subject,body)]
	}
	
	override avisarQuitaSinReemplazo(Partido partido, String mailAdmin, Participante participante) {
		
	}
}