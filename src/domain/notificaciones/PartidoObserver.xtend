package domain.notificaciones

import domain.Participante
import domain.Jugador
import domain.Partido

interface PartidoObserver {

		def void inscribir(Partido partido, Jugador jugador, boolean habiaLugar)
	
		def void quitarSinReemplazo(Partido partido, String mailAdmin, Participante participante)
}