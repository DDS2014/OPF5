package domain.calificaciones

import domain.Partido
import domain.Jugador
import java.util.Date

public class Calificacion {
	@Property int puntaje
	@Property String critica
	@Property Partido partido
	@Property Jugador calificador
	@Property Date fecha
	
	new(int puntaje,String critica,Partido partido,Jugador calificador){
		this.puntaje=puntaje
		this.critica=critica
		this.partido=partido
		this.calificador=calificador
		this.fecha = new Date();
	} 
}