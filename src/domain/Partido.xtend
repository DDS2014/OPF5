package domain

import domain.infracciones.Infraccion
import domain.notificaciones.PartidoObserver
import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import java.util.Date
import java.util.List
import domain.enviadorDeMails.InterfazDistribuidorDeMails
import domain.excepciones.JugadorNoFueAnotadoException
import java.util.Hashtable
import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio
import domain.generacionDeEquipos.algoritmosDeGeneracion.Generacion
import domain.excepciones.ImposibleGenerarEquiposException

public class Partido implements Comparator<Jugador> { //para descartar la solución decorator, no implementar EventoDeportivo y cambiar los "override" que fallen por "def"
	@Property Date fecha
	@Property List<Jugador> jugadoresConfirmados
	@Property List<PartidoObserver> observers //para descartar la solución observer, borrar este campo y todo lo que rompa como consecuencia
	public static final String MAIL_ADMINISTRADOR="admin@admin.com" 
	@Property InterfazDistribuidorDeMails distribuidor
	Hashtable<Jugador, Date> fechasDeInscripcion;
	@Property Criterio criterioDeOrdenamiento;
	@Property List<Jugador> primerEquipo
	@Property List<Jugador> segundoEquipo
	@Property Boolean equiposEstanConfirmados;
	@Property Generacion algoritmo;
	
	//CONSTRUCTOR
	new(Date fecha){
		this.fecha=fecha;
		this.jugadoresConfirmados=new ArrayList();
		this.observers =new ArrayList();
		this.fechasDeInscripcion = new Hashtable();
	}
	
	def estaInscripto(Jugador jugador)
	{
		jugadoresConfirmados.contains(jugador)
	}
	
	
	def boolean hayLugaresLibres()
	{
		return this.jugadoresConfirmados.size<10//Cambiar para que no este harcodeado
	}
	
	//Inscribe al participante
	def void confirmarAsistencia(Jugador jugador){
		if(!estaInscripto(jugador))
		{
			val habiaLugar = this.hayLugaresLibres(); //recordar que al haber un reemplazo, primero entra el nuevo y después sale el viejo, por lo tanto esto es accurate
			fechasDeInscripcion.put(jugador, new Date());
			this.jugadoresConfirmados.add(jugador)
			Collections.sort(this.jugadoresConfirmados,this)
			this.observers.forEach[observer | observer.avisarInscripcionDeJugador(this,jugador,habiaLugar)]
		}
		else throw new JugadorNoFueAnotadoException("El jugador que se intentó agregar ya estaba isncripto", this, jugador);
	}
	
	//Reemplaza a un jugador entrante por el saliente
	def reemplazar(Jugador entrante,Jugador saliente)
	{
		confirmarAsistencia(entrante) //cambio el orden de estos mensajes. así, si esto tiene que reventar, rompe dentro de confirmarAsistencia directamente y me ahorro preguntar dos veces lo mismo
		jugadoresConfirmados.remove(saliente)//Despues borra al otro
		
	}
	
	def void quitarSinReemplazo(Jugador participante) 
	{
		val estabaConfirmado = !hayLugaresLibres();
		this.jugadoresConfirmados.remove(participante);
		participante.aplicarInfraccion(new Infraccion("El jugador se bajó del partido sin designar un reemplazante"));
		this.observers.forEach[observer | observer.avisarQuitaSinReemplazo(this,MAIL_ADMINISTRADOR, participante, estabaConfirmado)]	
	}
	

	
	override compare(Jugador arg0, Jugador arg1) {
		if(arg0.modalidad.prioridad>arg1.modalidad.prioridad){
			return -1;
		}
		else if(arg0.modalidad.prioridad<arg1.modalidad.prioridad){
			return 1;
		}
		else{
			if(fechasDeInscripcion.get(arg0)<fechasDeInscripcion.get(arg1)){
				return -1;
			}
			else if(fechasDeInscripcion.get(arg0)>fechasDeInscripcion.get(arg1)){
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
	
	def seJugo(){
		this.fecha.before(new Date)
	}
	
	//Generacion de equipos tentativos
	def agregarAlgoritmo(Generacion algoritmo){
		this.algoritmo=algoritmo
		this.algoritmo.partido=this
	}
	
	def ordenarJugadores(){
		this.criterioDeOrdenamiento.ordenarJugadores(this);
	}
	
	def agregarJugadorAEquipo(int equipo, int posicion){
		var jugador = jugadoresConfirmados.get(posicion)
		
		if(primerEquipo.contains(jugador))
			throw new ImposibleGenerarEquiposException("El jugador " + jugador.nombre + " ya se encuentra inscripto al primer equipo.")
		
		if(segundoEquipo.contains(jugador))
			throw new ImposibleGenerarEquiposException("El jugador " + jugador.nombre + " ya se encuentra inscripto al segundo equipo.")
		
		if(equipo == 1)	
			primerEquipo.add(jugador)
		else
			segundoEquipo.add(jugador)
	}
}