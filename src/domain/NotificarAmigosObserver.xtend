package domain

import domain.PartidoObserver

class NotificarAmigosObserver implements PartidoObserver {
	
	def override notificarConfirmacionJugador(Partido partido){
		partido.jugadoresConfirmados.forEach[jugador|jugador.avisarAmigos()]
	}
}