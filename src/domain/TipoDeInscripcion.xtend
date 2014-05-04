package domain

import java.util.List

public abstract class TipoDeInscripcion {
	@Property int prioridad
	Participante participante;
	
	new(Participante participante)
	{
		this.participante = participante;
	}
	
	def boolean inscribir(Partido partido){
		var List<Participante> jugadores = partido.participantesConfirmados.toList
		var seInscribio=false
		
		if(partido.hayLugaresLibres){
			seInscribio= partido.confirmarAsistencia(participante)
		}
		else{	
			var i=0
			while(!seInscribio && i<jugadores.size){
				var saliente = jugadores.get(i) 
				seInscribio = saliente.modalidad.reemplazar(partido, participante, saliente)
				i=i+1
			}
		}
		
		return seInscribio
	}
	
	def abstract boolean reemplazar(Partido partido, Participante entrante,Participante saliente)
}