package domain.sugerencias

import domain.Jugador
import java.util.HashSet
import domain.inscripcion.TipoDeInscripcion
import domain.Partido

public class Comunidad {
	@Property HashSet<Jugador> aprobados
	@Property HashSet<Sugerencia> pendientes
	@Property HashSet<Denegacion> rechazados
	@Property HashSet<Partido> partidos
	
	new(){
		this.aprobados=new HashSet();
		this.pendientes=new HashSet();
		this.rechazados=new HashSet();
		this.partidos = new HashSet();
	}
	
	def agregar(Jugador jugador) //para agregar jugadores "por decreto", sin pasar por el sistema de sugerencias
	{
		this.aprobados.add(jugador); 
	}
	
	def organizarPartido(Partido partido)
	{
		this.partidos.add(partido);
	}
	
	def sugerir(Sugerencia sugerencia){
		this.pendientes.add(sugerencia)
	}
	
	def aprobar(Sugerencia sugerencia,TipoDeInscripcion modalidad){
		this.pendientes.remove(sugerencia)//Debe volver uno solo porque es un hashSet
		val jugador = sugerencia.aprobar(modalidad)
		this.aprobados.add(jugador)
		return jugador
	}
	
	def rechazar(Sugerencia sugerencia, String motivo){
		this.pendientes.remove(sugerencia)
		val denegacion = sugerencia.denegar(motivo);
		this.rechazados.add(denegacion)
	}
}