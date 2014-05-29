package domain

import domain.infracciones.Infraccion
import java.util.HashSet
import domain.inscripcion.TipoDeInscripcion
import java.util.Date
import domain.excepciones.ImposibleBajarseException

public class Jugador
{
	@Property String nombre
	@Property String apellido
	@Property int edad
	@Property String documento
	@Property String email
	@Property TipoDeInscripcion modalidad
	@Property Date fechaInscripcion	//en realidad esto me está representando la fecha de inscripción a un partido, y por lo tanto no está bueno que esté acá
	@Property HashSet<Jugador> amigos;
	@Property HashSet<Infraccion> infracciones;
	
	new(String nombre,int edad, TipoDeInscripcion modalidad)
	{
		this.nombre=nombre
		this.edad=edad
		this.amigos = new HashSet();
		this.infracciones = new HashSet();
		this.modalidad = modalidad;
		modalidad.setCliente(this);
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
		if (!partido.estaInscripto(this)) throw new ImposibleBajarseException("El jugador no está inscripto a ese partido", partido, this);
		partido.quitarSinReemplazo(this);
	}
	
	def bajarse(Partido partido, Jugador reemplazante)
	{
		if (!partido.estaInscripto(this)) throw new ImposibleBajarseException("El jugador no está inscripto a ese partido", partido, this);
		partido.reemplazar(reemplazante, this);
	}
	
	

	def aplicarInfraccion(Infraccion infraccion) 
	{
		this.infracciones.add(infraccion);
	}



}