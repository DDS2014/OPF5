package test

import domain.Jugador
import domain.Partido
import domain.inscripcion.InscripcionEstandar
import java.util.Date


public class Creaciones 
{
	def static crearPartidoCon8Estandar()
	{
		var partido = new Partido (new Date)
		
		//JUGADORES
		var p1 = new Jugador("Pepe",20, new InscripcionEstandar());
		var p2 = new Jugador("Luis",35, new InscripcionEstandar());
		var p3 = new Jugador("Juan",27, new InscripcionEstandar());
		var p4 = new Jugador("Alberto",20, new InscripcionEstandar());
		var p5 = new Jugador("Fabio",20, new InscripcionEstandar());
		var p6 = new Jugador("Alejo",26, new InscripcionEstandar());
		var p7 = new Jugador("Casio",29, new InscripcionEstandar());
		var p8 = new Jugador("Alan",30, new InscripcionEstandar());
		
		//Inscripciones
		p1.inscribirse(partido);
		p2.inscribirse(partido);
		p3.inscribirse(partido);
		p4.inscribirse(partido);
		p5.inscribirse(partido);
		p6.inscribirse(partido);
		p7.inscribirse(partido);
		p8.inscribirse(partido);
		
		return partido;		
}
	
	def static crearPartidoCon9Estandar()
	{
		var partido = crearPartidoCon8Estandar()
		
		//JUGADORES
		var p9 = new Jugador("Carlos",20, new InscripcionEstandar());
		
		//Inscripciones
		p9.inscribirse(partido);
		
		return partido;	
	}
	
	def static crearPartidoLlenoCon10Estandar()
	{
		var partido = crearPartidoCon9Estandar()
		
		//JUGADORES
		var p10 = new Jugador("Lucas",20, new InscripcionEstandar());
		
		//Inscripciones
		p10.inscribirse(partido);
		
		return partido;	
	}
}