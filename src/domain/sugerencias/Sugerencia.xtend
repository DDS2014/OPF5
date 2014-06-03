package domain.sugerencias


import java.util.HashSet
import domain.Jugador
import domain.inscripcion.TipoDeInscripcion

public class Sugerencia {
	@Property String nombre
	@Property String apellido
	@Property int edad
	@Property String documento
	@Property String email
	@Property HashSet<Jugador> amigos;
	
	new(String nombre,int edad)
	{
		this.nombre=nombre
		this.edad=edad
		this.amigos = new HashSet();
	}
	
	def Jugador aprobar(TipoDeInscripcion modalidad){
		val jugador = new Jugador(this.nombre,this.edad,modalidad)
		return jugador;
	}
	
	def Denegacion denegar(String motivo)
	{
		val denegacion = new Denegacion(this.nombre, motivo);
		return denegacion;
	}
}