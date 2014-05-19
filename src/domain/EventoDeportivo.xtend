package domain

import java.util.List
import domain.inscripcion.TipoDeInscripcion

interface EventoDeportivo 
{
	def List<Jugador> jugadoresConfirmados();
	def Boolean estaInscripto(Jugador jugador);
	def boolean inscribir(TipoDeInscripcion modalidad);
	def boolean hayLugaresLibres();
	def boolean confirmarAsistencia(Participante participante);
	def boolean reemplazar(Participante entrante,Participante saliente);
	def void quitarSinReemplazo(Participante participante);
}
