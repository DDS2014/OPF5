package domain.sugerencias

import domain.Jugador
import java.util.HashSet
import domain.inscripcion.TipoDeInscripcion

public class Comunidad {
	@Property HashSet<Jugador> aprobados
	@Property HashSet<Sugerencia> pendientes
	@Property HashSet<Denegacion> rechazados
	
	new(){
		this.aprobados=new HashSet();
		this.pendientes=new HashSet();
		this.rechazados=new HashSet();
	}
	
	def sugerir(Sugerencia sugerencia){
		this.pendientes.add(sugerencia)
	}
	
	def aprobar(Sugerencia sugerencia,TipoDeInscripcion modalidad){
		this.pendientes.remove(sugerencia)//Debe volver uno solo porque es un hashSet
		val jugador = sugerencia.aprobar(modalidad)
		this.aprobados.add(jugador)
	}
	
	def rechazar(Sugerencia sugerencia, String motivo){
		this.pendientes.remove(sugerencia)
		val denegacion = new Denegacion(sugerencia,motivo)
		this.rechazados.add(denegacion)
	}
}