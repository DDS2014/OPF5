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
		/*
		var part1 = new Participante(new Jugador("Pepe",20));
		part1.setModalidad(new InscripcionEstandar(part1));
		var	part2 = new Participante(new Jugador("Luis",35));
		part2.setModalidad(new InscripcionEstandar(part2));
		var	part3 = new Participante(new Jugador("Juan",27));
		part3.setModalidad(new InscripcionEstandar(part3));
		var	part4 = new Participante(new Jugador("Alberto",20));
		part4.setModalidad(new InscripcionEstandar(part4));
		var	part5 = new Participante(new Jugador("Fabio",20));
		part5.setModalidad(new InscripcionEstandar(part5));
		var	part6 = new Participante(new Jugador("Alejo",26));
		part6.setModalidad(new InscripcionEstandar(part6));
		var	part7 = new Participante(new Jugador("Casio",29));
		part7.setModalidad(new InscripcionEstandar(part7));
		var	part8 = new Participante(new Jugador("Alan",30));
		part8.setModalidad(new InscripcionEstandar(part8));
		
		part1.inscribirse(partido);
		part2.inscribirse(partido);
		part3.inscribirse(partido);
		part4.inscribirse(partido);
		part5.inscribirse(partido);
		part6.inscribirse(partido);
		part7.inscribirse(partido);
		part8.inscribirse(partido);
		 */
}
	
	def static crearPartidoCon9Estandar()
	{
		var partido = crearPartidoCon8Estandar()
		
		//JUGADORES
		var p9 = new Jugador("Carlos",20, new InscripcionEstandar());
		
		//Inscripciones
		p9.inscribirse(partido);
		
		return partido;	
		
		/*
		var	part9 = new Participante(new Jugador("Carlos",20));
		part9.setModalidad(new InscripcionEstandar(part9));
		part9.inscribirse(partido);
		*/
	}
	
	def static crearPartidoLlenoCon10Estandar()
	{
		var partido = crearPartidoCon9Estandar()
		
		//JUGADORES
		var p10 = new Jugador("Lucas",20, new InscripcionEstandar());
		
		//Inscripciones
		p10.inscribirse(partido);
		
		return partido;	
		
		/*
		var partido = crearPartidoCon9Estandar()
		
		var	part10 = new Participante(new Jugador("Lucas",20));
		part10.setModalidad(new InscripcionEstandar(part10));
		part10.inscribirse(partido);	
		
		return partido;
		 */
	}
}