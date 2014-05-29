package domain

import domain.infracciones.Infraccion
import domain.inscripcion.TipoDeInscripcion
import domain.notificaciones.PartidoObserver
import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import java.util.Date
import java.util.List
import domain.enviadorDeMails.InterfazDistribuidorDeMails
import domain.excepciones.JugadorNoFueAnotadoException

public class Partido implements Comparator<Participante>, EventoDeportivo { //para descartar la solución decorator, no implementar EventoDeportivo y cambiar los "override" que fallen por "def"
	@Property Date fecha
	@Property List<Participante> participantesConfirmados
	@Property List<PartidoObserver> observers //para descartar la solución observer, borrar este campo y todo lo que rompa como consecuencia
	public static final String MAIL_ADMINISTRADOR="admin@admin.com" 
	@Property InterfazDistribuidorDeMails distribuidor
	
	//CONSTRUCTOR
	new(Date fecha){
		this.fecha=fecha;
		this.participantesConfirmados=new ArrayList();
		this.observers =new ArrayList();
	}
	
	//Inscripcion
	override jugadoresConfirmados(){
		participantesConfirmados.map[p|p.jugador].toList
	}
	
	override estaInscripto(Jugador jugador){
		var List<Jugador> jugadores = jugadoresConfirmados()
		jugadores.contains(jugador)
	}
	
	override inscribir(TipoDeInscripcion modalidad){
		val habiaLugar = hayLugaresLibres()
		modalidad.participante.setModalidad(modalidad);
		modalidad.participante.inscribirse(this)
	    this.observers.forEach[observer | observer.avisarInscripcionDeJugador(this,modalidad.participante.jugador,habiaLugar)]
	}
	
	override boolean hayLugaresLibres(){
		return this.participantesConfirmados.size<10//Cambiar para que no este harcodeado
	}
	
	//Inscribe al participante
	override confirmarAsistencia(Participante participante){
		if(!estaInscripto(participante.jugador))
		{
			this.participantesConfirmados.add(participante)
			Collections.sort(this.participantesConfirmados,this)
		}
		else throw new JugadorNoFueAnotadoException("El jugador que se intentó agregar ya estaba isncripto", this, participante);
	}
	
	//Reemplaza a un jugador entrante por el saliente
	override reemplazar(Participante entrante,Participante saliente)
	{
		//Primero ve si lo puede agregar, y lo agrega al final
		confirmarAsistencia(entrante) //cambio el orden de estos mensajes. así, si esto tiene que reventar, rompe dentro de confirmarAsistencia directamente y me ahorro preguntar dos veces lo mismo
		participantesConfirmados.remove(saliente)//Despues borra al otro
		
	}
	
	override void quitarSinReemplazo(Participante participante) 
	{
		val estabaConfirmado = !hayLugaresLibres();
		this.participantesConfirmados.remove(participante);
		participante.jugador.aplicarInfraccion(new Infraccion("El jugador se bajó del partido sin designar un reemplazante"));
		this.observers.forEach[observer | observer.avisarQuitaSinReemplazo(this,MAIL_ADMINISTRADOR,participante, estabaConfirmado)]	
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
	
	
}