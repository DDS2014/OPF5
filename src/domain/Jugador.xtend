package domain

public class Jugador {
	@Property String nombre
	@Property String apellido
	@Property int edad
	@Property String documento
	
	new(String nombre,int edad){
		this.nombre=nombre
		this.edad=edad
	}
}