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
	
	
	def boolean hayCondicionales() 
	{
		//este método tiene que devolver true si hay algún jugador inscripto como condicional
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def Participante getPrimerCondicional() 
	{
		//este método tiene que darme una referencia al primer participante condicional que deba echarse
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def reemplazar(Participante saliente, Participante entrante) //permite reemplazar a un jugador (saliente) por otro (entrante)
	{
		this.participantesConfirmados.remove(saliente);
		this.participantesConfirmados.add(entrante);
	}
	
	def boolean haySolidarios() 
	{
		//este método tiene que devolver true si hay algún jugador inscripto como solidario
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def Participante getPrimerSolidario() 
	{
		//este método tiene que darme una referencia al primer participante solidario que deba echarse
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	//TODO usar los tipos posta de fecha y hora
	
}