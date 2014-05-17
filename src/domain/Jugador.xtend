package domain

import java.util.HashSet

public class Jugador
{
	@Property String nombre
	@Property String apellido
	@Property int edad
	@Property String documento
	@Property String email
	HashSet<Jugador> amigos;
	@Property HashSet<Infraccion> infracciones;
	
	new(String nombre,int edad)
	{
		this.nombre=nombre
		this.edad=edad
		this.amigos = new HashSet();
		this.infracciones = new HashSet();
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

	def aplicarInfraccion(Infraccion infraccion) 
	{
		this.infracciones.add(infraccion);
	}

}