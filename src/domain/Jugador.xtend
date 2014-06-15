package domain

import domain.infracciones.Infraccion
import java.util.HashSet
import domain.inscripcion.TipoDeInscripcion
import domain.calificaciones.Calificacion
import domain.excepciones.ImposibleCalificarException
import domain.excepciones.ImposibleBajarseException
import java.util.ArrayList

public class Jugador
{
	@Property String nombre
	@Property String apellido
	@Property int edad
	@Property double handicap
	@Property String documento
	@Property String email
	@Property TipoDeInscripcion modalidad
	@Property HashSet<Jugador> amigos;
	@Property HashSet<Infraccion> infracciones;
	@Property ArrayList<Calificacion> calificaciones;
	
	new(String nombre,int edad, TipoDeInscripcion modalidad)
	{
		this.nombre=nombre
		this.edad=edad
		this.amigos = new HashSet();
		this.infracciones = new HashSet();
		this.modalidad = modalidad;
		modalidad.setCliente(this);
		this.calificaciones=new ArrayList();
	}


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
	}

	def boolean estaCalificado(Partido partido, Jugador calificador){
		this.calificaciones.exists[c|c.partido==partido && c.calificador==calificador]
	}
	
	
	
	
	
}