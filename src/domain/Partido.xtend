package domain

import java.util.Date
import java.util.List
import java.util.Comparator
import java.util.Collections
import java.util.ArrayList

public class Partido implements Comparator<Participante> {
	@Property Date fecha
	@Property List<Participante> participantesConfirmados
	
	//CONSTRUCTOR
	new(Date fecha){
		this.fecha=fecha
		this.participantesConfirmados=new ArrayList()
	}
	
	//Inscripcion
	def jugadoresConfirmados(){
		participantesConfirmados.map[p|p.jugador].toList
	}
	
	def estaInscripto(Jugador jugador){
		var List<Jugador> jugadores = jugadoresConfirmados()
		jugadores.contains(jugador)
	}
	
	def boolean inscribir(Jugador jugador,TipoDeInscripcion modalidad){
		//Creo una nueva instancia de participante para el jugador a inscribirse
		val participante = new Participante(jugador)
		participante.setModalidad(modalidad);
		return participante.inscribirse(this)
	}
	
	def boolean hayLugaresLibres(){
		return this.participantesConfirmados.size<10
	}
	
	//Inscribe al participante
	def boolean confirmarAsistencia(Participante participante){
		if(!estaInscripto(participante.jugador)){
			this.participantesConfirmados.add(participante)
			Collections.sort(this.participantesConfirmados,this)
			return true
		}
		else{
			return false
		}
	}
	
	//Reemplaza a un jugador entrante por el saliente
	def boolean reemplazar(Participante entrante,Participante saliente){
		if(!estaInscripto(entrante.jugador)){//Primero ve si lo puede agregar, y lo agrega al final
			participantesConfirmados.remove(saliente)//Despues borra al otro
			confirmarAsistencia(entrante)
		}
	}
	
	
	
	def quitarSinReemplazo(Participante participante) 
	{
		this.participantesConfirmados.remove(participante);
		participante.jugador.aplicarInfraccion(new Infraccion("El jugador se bajó del partido sin designar un reemplazante"));	
	}
	
	override compare(Participante arg0, Participante arg1) {
		if(arg0.modalidad.prioridad>arg1.modalidad.prioridad){
			return -1;
		}
		else if(arg0.modalidad.prioridad<arg1.modalidad.prioridad){
			return 1;
		}
		else{
			if(arg0.fechaInscripcion<arg1.fechaInscripcion){
				return -1;
			}
			else if(arg0.fechaInscripcion>arg1.fechaInscripcion){
				return 1;
			}
			else return 0;
		}
	}


	
}