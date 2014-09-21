package domain

import domain.infracciones.Infraccion
import domain.notificaciones.PartidoObserver
import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import java.util.Date
import java.util.List
//import domain.enviadorDeMails.InterfazDistribuidorDeMails
import domain.excepciones.JugadorNoFueAnotadoException
import java.util.Hashtable
import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio
import domain.generacionDeEquipos.algoritmosDeGeneracion.Generacion
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.Entity

@Observable
public class Partido extends Entity implements Comparator<Jugador> { //para descartar la solución decorator, no implementar EventoDeportivo y cambiar los "override" que fallen por "def"
	@Property Date fecha
	@Property List<Jugador> jugadoresConfirmados
	@Property List<PartidoObserver> observers //para descartar la solución observer, borrar este campo y todo lo que rompa como consecuencia
	public static final String MAIL_ADMINISTRADOR="admin@admin.com" 
	//@Property InterfazDistribuidorDeMails distribuidor
	Hashtable<Jugador, Date> fechasDeInscripcion;
	@Property Criterio criterioDeOrdenamiento;
	@Property List<Jugador> primerEquipo
	@Property List<Jugador> segundoEquipo
	@Property Generacion algoritmo;
	PartidoState estado;
	
	//CONSTRUCTOR
	new(Date fecha){
		this.fecha=fecha;
		this.jugadoresConfirmados=new ArrayList();
		this.observers =new ArrayList();
		this.fechasDeInscripcion = new Hashtable();
		this.primerEquipo = new ArrayList();
		this.segundoEquipo = new ArrayList();
		this.estado = new PartidoAbierto_State();
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
	def void confirmarAsistencia(Jugador jugador)
	{
		estado.validarCambios();
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
		estado.validarCambios();
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
	def definirAlgoritmoGeneracion(Generacion algoritmo){
		this.algoritmo=algoritmo
		this.algoritmo.partido=this
	}
	
	def ordenarJugadores()
	{
		Collections.sort(jugadoresConfirmados, criterioDeOrdenamiento);
	}
	
	def generarEquipos()
	{
		this.algoritmo.generarEquipos();
	}
	
	def resetearEquipos()
	{
		estado.validarCambios();
		primerEquipo = new ArrayList();
		segundoEquipo = new ArrayList();
		//y que el garbage collector haga el resto
	}
	

	def agregarAlPrimerEquipo(Jugador jugador) 
		{
			primerEquipo.add(jugador)
				
		}
		
	def agregarAlSegundoEquipo(Jugador jugador) 
	{
		{
			segundoEquipo.add(jugador)
		}
	}
	
	def confirmarEquipos()
	{
		if (!hayEquipo) throw new RuntimeException("No se puede confirmar los equipos ya que no se generaron correctamente"); //todo agregar una excepción propia para esto
		this.estado = new PartidoConEquiposConfirmados_State();	
	}

	def hayEquipo() 
	{
		return ((segundoEquipo.size == 5) && (primerEquipo.size == 5));
	}

}

