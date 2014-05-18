package domain.notificaciones

import domain.Participante
import domain.Jugador
import domain.Partido

class NotificarAdminObserver implements PartidoObserver {
	
	override inscribir(Partido partido, Jugador jugador, boolean habiaLugar) {
		if(habiaLugar && !partido.hayLugaresLibres()){
		
			//System.out.println("Se notifico al administrador")
			var subject = "Partido Confirmado"
			var body = "Todas las plazas del partido fueron confirmadas"
		
			partido.distribuidor.enviarMail(Partido.MAIL_ADMINISTRADOR,subject,body)
		
		}
	}
	
	override quitarSinReemplazo(Partido partido, String mailAdmin, Participante participante) {
		var subject = "Partido Indefinido"
		var body = "El partido dejó de tener todas las plazas confirmadas. El jugador " + participante.jugador.nombre + " se bajó del partido."
		
		partido.distribuidor.enviarMail(Partido.MAIL_ADMINISTRADOR,subject,body) 
	}
	
}