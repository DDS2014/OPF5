package domain

import domain.infracciones.Infraccion
import domain.inscripcion.TipoDeInscripcion
import domain.notificaciones.PartidoObserver
import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import java.util.Date
import java.util.List
//import domain.enviadorDeMails.distribuidor.DistribuidorStub
import domain.enviadorDeMails.DistribuidorDeMails

public class Partido implements Comparator<Participante> {
	@Property Date fecha
	@Property List<Participante> participantesConfirmados
	@Property List<PartidoObserver> observers
	public static final String MAIL_ADMINISTRADOR="admin@admin.com" 
	@Property DistribuidorDeMails distribuidor
	
	//CONSTRUCTOR
	new(Date fecha){
		this.fecha=fecha;
		this.participantesConfirmados=new ArrayList();
		this.observers =new ArrayList();
	}
	
	//Inscripcion
	def jugadoresConfirmados(){
		participantesConfirmados.map[p|p.jugador].toList
	}
	
	def estaInscripto(Jugador jugador){
		var List<Jugador> jugadores = jugadoresConfirmados()
		jugadores.contains(jugador)
	}
	
	def boolean inscribir(TipoDeInscripcion modalidad){
		val habiaLugar = hayLugaresLibres()
		modalidad.participante.setModalidad(modalidad);
		modalidad.participante.inscribirse(this)
	    this.observers.forEach[observer | observer.inscribir(this,modalidad.participante.jugador,habiaLugar)]
		return true
	}
	
	def boolean hayLugaresLibres(){
		return this.participantesConfirmados.size<10//Cambiar para que no este harcodeado
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
		var bool = false
		if(!estaInscripto(entrante.jugador)){//Primero ve si lo puede agregar, y lo agrega al final
			participantesConfirmados.remove(saliente)//Despues borra al otro
			bool=confirmarAsistencia(entrante)
		}
		return bool
	}
	
	def void quitarSinReemplazo(Participante participante) 
	{
		this.participantesConfirmados.remove(participante);
		participante.jugador.aplicarInfraccion(new Infraccion("El jugador se bajó del partido sin designar un reemplazante"));
		this.observers.forEach[observer | observer.quitarSinReemplazo(this,MAIL_ADMINISTRADOR,participante)]	
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
	
	def agregarObsever(PartidoObserver observer) {
		this.observers.add(observer)
	}

	def removeObserver(PartidoObserver observer){
		this.observers.remove(observer)
	}
	
	
	//Cambiar
	def amigosNotificados(){
		this.jugadoresConfirmados.forall[jugador | jugador.avisarAmigos()]
	}
}