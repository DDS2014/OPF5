package domain.sugerencias

import java.util.Date
import java.util.HashSet
import domain.Jugador
import domain.inscripcion.TipoDeInscripcion

public class Sugerencia {
	@Property String nombre
	@Property String apellido
	@Property int edad
	@Property String documento
	@Property String email
	@Property Date fechaInscripcion	//en realidad esto me está representando la fecha de inscripción a un partido, y por lo tanto no está bueno que esté acá
	@Property HashSet<Jugador> amigos;
	
	new(String nombre,int edad, TipoDeInscripcion modalidad)
	{
		this.nombre=nombre
		this.edad=edad
		this.amigos = new HashSet();
	}
	
	def Jugador aprobar(TipoDeInscripcion modalidad){
		val jugador = new Jugador(this.nombre,this.edad,modalidad)
		return jugador
	}
}