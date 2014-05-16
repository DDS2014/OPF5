package domain

import java.util.HashSet

public class Jugador 
{
	@Property String nombre
	@Property String apellido
	@Property int edad
	@Property String documento
	HashSet<Jugador> amigos;
	
	new(String nombre,int edad)
	{
		this.nombre=nombre
		this.edad=edad
		this.amigos = new HashSet();
	}
}