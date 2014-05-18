package domain.inscripcion.condiciones

import domain.Jugador
import domain.Partido
import java.util.HashSet
import java.util.Set

public class Condicion_LimiteDeEdad implements Condicion {
	@Property int edad
	@Property int cantidadJugadores
	@Property boolean minimoDeEdad
	@Property boolean minimoDeJugadores
	
	new(int edad,int cantidadJugadores,boolean minimoDeEdad, boolean minimoDeJugadores){
		this.edad=edad
		this.cantidadJugadores=cantidadJugadores
		this.minimoDeEdad=minimoDeEdad
		this.minimoDeJugadores=minimoDeJugadores
	}
	
	override seCumple(Partido partido) {
		var Set<Jugador> jugadores = partido.participantesConfirmados.map[p|p.jugador].toSet
		var Set<Jugador> jugadoresQueCumplen=new HashSet
		
		if(minimoDeEdad){
			jugadoresQueCumplen=jugadores.filter[j|j.edad>=this.edad].toSet
		}
		else{
			jugadoresQueCumplen=jugadores.filter[j|j.edad<=this.edad].toSet
		}
		
		if(minimoDeJugadores){
			return jugadoresQueCumplen.size>=this.cantidadJugadores
		}
		else{		
			return jugadoresQueCumplen.size<=this.cantidadJugadores
		}
	}
}