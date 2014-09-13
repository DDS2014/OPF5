package domain.inscripcion


import domain.Partido
import domain.excepciones.NoHayLugarParaAnotarseException
import java.util.List
import domain.Jugador

public abstract class TipoDeInscripcion {
	@Property int prioridad
	@Property Jugador participante;
	
	def void setCliente(Jugador jugador)
	{
		this.participante = jugador;
	}
	
	def void inscribir(Jugador participante, Partido partido)
	{ //OJO: ESTO YA NO RETORNA BOOLEAN
		var List<Jugador> jugadores = partido.jugadoresConfirmados.toList
		var seInscribio=false
		
		if(partido.hayLugaresLibres)
		{
		 	partido.confirmarAsistencia(participante);
		 	seInscribio =true;
			
		}
		else
		{
			var i=0
		
			while(!seInscribio && i<jugadores.size)
			{
				var saliente = jugadores.get(i) 
				seInscribio = saliente.modalidad.reemplazar(partido, participante, saliente)
				i=i+1
			}
		
		}
		
		if(!seInscribio) throw new NoHayLugarParaAnotarseException("No se encontró ningun lugar para acomodar a este jugador", partido, participante);
		
	}
	
	def abstract boolean reemplazar(Partido partido, Jugador entrante,Jugador saliente)



}