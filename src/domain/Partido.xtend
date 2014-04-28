package domain

import java.util.Set
import java.util.HashSet

public class Partido 
{
	@Property String fecha;
	@Property String hora;
	Set<Participante> participantesConfirmados;
	
	new(String fecha, String hora) 
	{
		this.fecha = fecha;
		this.hora = hora;
		this.participantesConfirmados = new HashSet();		
	}

	def Iterable<Jugador> getJugadoresConfirmados() //este método obtiene la lista de jugadores confirmados
	{
		return participantesConfirmados.map([p | p.getJugador]);	
	}

	def boolean hayLugaresLibres() 
	{
		return (this.participantesConfirmados.length < 10);
	}
	
	def confirmarAsistencia(Participante participante)
	{
		this.participantesConfirmados.add(participante);
	}
	
	def boolean estaInscripto(Jugador jugador) 
	{
		val confirmados = this.getJugadoresConfirmados();
		
		if (confirmados.exists([j | j == jugador])) //si alguno de los confirmados es este jugador...
		{
			return true	
		}
		
		return false;
	}
	
	def getJugador() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	//TODO usar los tipos posta de fecha y hora
	
}