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
import domain.enviadorDeMails.InterfazDistribuidorDeMails
import java.io.Serializable

@Observable
public class Partido extends Entity implements Comparator<Jugador>, Serializable 
{ //para descartar la solución decorator, no implementar EventoDeportivo y cambiar los "override" que fallen por "def"
	Date fecha
	List<Jugador> jugadoresConfirmados
	List<PartidoObserver> observers 
	public static final String MAIL_ADMINISTRADOR="admin@admin.com" 
	InterfazDistribuidorDeMails distribuidor
	Hashtable<Jugador, Date> fechasDeInscripcion;
	Criterio criterioDeOrdenamiento;
	List<Jugador> primerEquipo
	List<Jugador> segundoEquipo
	Generacion algoritmo;
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
	
	//constructor sin parametros para hibernate
	new()
	{
		
	}
	
	
	//getters y setters para hibernate
	def getFecha(){ fecha }
	def setFecha(Date f) { fecha = f}
	def getJugadoresConfirmados() { jugadoresConfirmados }
	def setJugadoresConfirmados(List<Jugador> j) { jugadoresConfirmados = j }
	def getObservers() { observers }
	def setObservers(List<PartidoObserver> o) {observers = o}
	def getDistribuidor() { distribuidor }
	def setDistribuidor(InterfazDistribuidorDeMails d) { distribuidor = d }
	def getFechasDeInscripcion() { fechasDeInscripcion }
	def setFechasDeInscripcion(Hashtable<Jugador, Date> f) { fechasDeInscripcion = f  }
	def getCriterioDeOrdenamiento() { criterioDeOrdenamiento }
	def setCriterioDeOrdenamiento(Criterio c) {criterioDeOrdenamiento = c }
	def getPrimerEquipo() { primerEquipo }
	def setPrimerEquipo(List<Jugador> j) { primerEquipo = j }
	def getSegundoEquipo() { segundoEquipo }
	def setSegundoEquipo(List<Jugador> j) {segundoEquipo = j}
	def getAlgoritmo() { algoritmo }
	def setAlgoritmo (Generacion a) { algoritmo = a }
	def getEstado() { estado }
	def setEstado(PartidoState e) {estado = e }
	
	
	
	
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
		this.resetearEquipos();
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

