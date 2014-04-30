package domain

import java.util.HashSet
import java.util.Set

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
	
	def void confirmarAsistencia(Participante participante)
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
		this.participantesConfirmados.exists([participante | participante.sosCondicional() == true])
	}
	
	def Participante getPrimerCondicional() //este método tiene que darme una referencia al primer participante condicional que deba echarse
	{	
	var condicionales = this.participantesConfirmados.filter([participante | participante.sosCondicional()]);
	return condicionales.get(0)
	}
	
	def reemplazar(Participante saliente, Participante entrante) //permite reemplazar a un jugador (saliente) por otro (entrante)
	{
		this.participantesConfirmados.remove(saliente);
		this.participantesConfirmados.add(entrante);
	}

	def boolean haySolidarios() //Repite el codigo de hayCondicionales, capas se puedan poner en el mismo metodo los dos
	{
		this.participantesConfirmados.exists([participante | participante.sosSolidario() == true])
	} 
	
	def getPrimerSolidario() 
	{
	var solidarios = this.participantesConfirmados.filter([participante | participante.sosSolidario()]);
	return solidarios.get(0)
	}
	
	def obtenerCantidadDeInscriptos() 
	{
		return this.participantesConfirmados.length();
	}
	
	//TODO usar los tipos posta de fecha y hora
	
}