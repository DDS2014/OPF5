package domain.notificaciones


import domain.Jugador
import domain.Partido

interface PartidoObserver {

		def void avisarInscripcionDeJugador(Partido partido, Jugador jugador, boolean habiaLugar)
	
		def void avisarQuitaSinReemplazo(Partido partido, String mailAdmin, Jugador participante, Boolean estabaConfirmado)
}