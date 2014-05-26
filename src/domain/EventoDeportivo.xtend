package domain

import java.util.List
import domain.inscripcion.TipoDeInscripcion
import domain.enviadorDeMails.InterfazDistribuidorDeMails
import java.util.Date

interface EventoDeportivo 
{
	def List<Jugador> jugadoresConfirmados();
	def Boolean estaInscripto(Jugador jugador);
	def void inscribir(TipoDeInscripcion modalidad);
	def boolean hayLugaresLibres();
	def void confirmarAsistencia(Participante participante);
	def void reemplazar(Participante entrante,Participante saliente);
	def void quitarSinReemplazo(Participante participante);
	def void bajar(Participante participante);
	def InterfazDistribuidorDeMails getDistribuidor();
	def Date getFecha()	
	def void setDistribuidor(InterfazDistribuidorDeMails mails);
}
