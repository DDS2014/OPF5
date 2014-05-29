package domain.notificaciones


import domain.Jugador
import domain.Partido

class NotificarAdminObserver implements PartidoObserver {
	
	override avisarInscripcionDeJugador(Partido partido, Jugador jugador, boolean habiaLugar) {
		if(habiaLugar && !partido.hayLugaresLibres()){
		
			//System.out.println("Se notifico al administrador")
			var subject = "Partido Confirmado"
			var body = "Todas las plazas del partido fueron confirmadas"
		
			partido.distribuidor.enviarMail(Partido.MAIL_ADMINISTRADOR,subject,body)
		
		}
	}
	
	override avisarQuitaSinReemplazo(Partido partido, String mailAdmin, Jugador participante, Boolean estabaConfirmado) {
		
		if (estabaConfirmado) //esto significa que, en un partido confirmado, alguien se bajó sin nombrar un reemplazante
		{
			var subject = "Partido Indefinido"
			var body = "El partido dejó de tener todas las plazas confirmadas. El jugador " + participante.nombre + " se bajó del partido."
			
			partido.distribuidor.enviarMail(Partido.MAIL_ADMINISTRADOR,subject,body)
		}
	}
}
	
