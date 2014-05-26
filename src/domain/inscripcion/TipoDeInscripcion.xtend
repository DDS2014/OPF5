package domain.inscripcion

import domain.Participante
import domain.Partido
import domain.excepciones.NoHayLugarParaAnotarseException
import java.util.List

public abstract class TipoDeInscripcion {
	@Property int prioridad
	@Property Participante participante;
	
	new(Participante participante)
	{
		this.participante = participante;
		this.participante.setModalidad(this);
	}
	
	def void inscribir(Partido partido){ //OJO: ESTO YA NO RETORNA BOOLEAN
		var List<Participante> jugadores = partido.participantesConfirmados.toList
		var seInscribio=false
		
		var i=0
		
		while(!seInscribio && i<jugadores.size)
		{
			var saliente = jugadores.get(i) 
			seInscribio = saliente.modalidad.reemplazar(partido, this.participante, saliente)
			i=i+1
		}
		
		if(!seInscribio) throw new NoHayLugarParaAnotarseException("No se encontró ningun lugar para acomodar a este jugador", partido, participante);
		
	}
	
	def abstract boolean reemplazar(Partido partido, Participante entrante,Participante saliente)
}