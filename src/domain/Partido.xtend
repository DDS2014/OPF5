package domain

import java.util.SortedSet

public class Partido 
{
	@Property String fecha;
	@Property String hora;
	SortedSet<Participante> jugadoresConfirmados;
	
	new(String fecha, String hora) 
	{
		this.fecha = fecha;
		this.hora = hora;		
	}

	def boolean hayLugaresLibres() 
	{
		return (this.jugadoresConfirmados.length < 10);
	}
	
	def confirmarAsistencia(Participante participante)
	{
		this.jugadoresConfirmados.add(participante);
	}
	
	//TODO usar los tipos posta de fecha y hora
	
}