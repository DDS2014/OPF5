package domain

import domain.calificaciones.Calificacion
import domain.excepciones.ImposibleBajarseException
import domain.excepciones.ImposibleCalificarException
import domain.infracciones.Infraccion
import domain.inscripcion.TipoDeInscripcion
import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import java.util.Date
import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable


@Observable
public class Jugador extends Entity implements Comparator<Calificacion> 
{


	String nombre
	String apellido
	String apodo
	int edad
	double handicap
	@Property String documento
	@Property String email
	@Property TipoDeInscripcion modalidad
	@Property ArrayList<Jugador> amigos;
	@Property ArrayList<Infraccion> infracciones;
	@Property ArrayList<Calificacion> calificaciones;
	@Property Date fechaNacimiento;
	
	
	new(String nombre,int edad, TipoDeInscripcion modalidad)
	{
		this.nombre=nombre
		this.edad=edad
		this.amigos = new ArrayList();
		this.infracciones = new ArrayList();
		this.modalidad = modalidad;
		modalidad.setCliente(this);
		this.calificaciones=new ArrayList();
	}
	
	new() {
		this.amigos = new ArrayList();
		this.infracciones = new ArrayList();
		this.calificaciones=new ArrayList();
	}
	
	def getNombre()	{ nombre }
	def setNombre(String n) { nombre = n }
	def getApellido() { apellido }
	def setApellido(String a) { apellido = a }
	def getApodo() { apodo }
	def setApodo(String a) { apodo = a }
	def getEdad() { edad }
	def setEdad(int e) { edad = e }
	def getHandicap() { handicap }
	def setHandicap(double h) { handicap = h }
	
	


	//la amistad se hace en dos pasos para que haya simetría (si yo soy tu amigo, vos sos mi amigo)	
	def hacerseAmigoDe(Jugador nuevoAmigo)
	//método que debe usarse desde afuera para hacer amigos a dos jugadores
	{
		this.confirmarAmistad(nuevoAmigo);
		nuevoAmigo.confirmarAmistad(this);
	}
	
	
	def confirmarAmistad(Jugador nuevoAmigo)
	//este método es el que agrega al nuevo amigo
	{
		this.amigos.add(nuevoAmigo);
	}
	
	def boolean tieneAlAmigo(Jugador amigo)
	{
		return this.amigos.exists([a | a == amigo]);
	}
	
	def void inscribirse(Partido partido)
	{
		modalidad.inscribir(this,partido);
	}
	
	
	def bajarse(Partido partido)
	{
		if (!partido.estaInscripto(this)) throw new ImposibleBajarseException("No puede darse de baja al jugador.", partido, this);
		partido.quitarSinReemplazo(this);
	}
	
	def bajarse(Partido partido, Jugador reemplazante)
	{
		if (!partido.estaInscripto(this)) throw new ImposibleBajarseException("El jugador no puede ser reemplazado.", partido, this);
		partido.reemplazar(reemplazante, this);
	}
	
	def aplicarInfraccion(Infraccion infraccion) 
	{
		this.infracciones.add(infraccion);
	}
	
	//CALIFICACIONES
	def calificar(int puntaje, String critica, Partido partido, Jugador calificador){
		
		if (!partido.estaInscripto(this)) throw new ImposibleCalificarException("El jugador no se encuentra inscripto.", partido, this);
		if (this.estaCalificado(partido,calificador)) throw new ImposibleCalificarException("El jugador ya fue calificado.", partido, this);
		if(this==calificador) throw new ImposibleCalificarException("El jugador no puede calificarse a si mismo.", partido, this);		
		var calificacion = new Calificacion(puntaje,critica,partido,calificador)
		this.calificaciones.add(calificacion)
		Collections.sort(this.calificaciones, this);
	}

	def boolean estaCalificado(Partido partido, Jugador calificador){
		this.calificaciones.exists[c|c.partido==partido && c.calificador==calificador]
	}
	
	
	override compare(Calificacion arg0, Calificacion arg1) //ordena las calificaciones de la más reciente a la más vieja
	{
		if(arg0.getFecha() > arg1.getFecha())
		{
			return -1;
		}
		else
		{
			return 1;
		}
		
	}
	

	
	def double promedioGlobal(){
		if (this.calificaciones.isEmpty)
		return 0
		else
		{var suma = 0 as double
		var cantidadAPromediar = calificaciones.length()
		var puntajesAPromediar = calificaciones.map[calif | calif.getPuntaje()]
		for(puntaje:puntajesAPromediar)
		{suma = suma + puntaje}
		return suma/cantidadAPromediar
		}
	}
	
	def Boolean tieneInfracciones(){
		return this.infracciones.length>0
	}
}