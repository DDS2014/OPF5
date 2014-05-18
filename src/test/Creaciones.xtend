package test

import domain.Jugador
import domain.Partido
import domain.inscripcion.InscripcionEstandar
import java.util.Date
import domain.Participante

public class Creaciones 
{
	def static crearPartidoCon8Estandar()
	{
		var partido = new Partido (new Date)
		
		//JUGADORES
		var p1 = new Participante(new Jugador("Pepe",20))
		var p2 = new Participante(new Jugador("Luis",35))
		var p3 = new Participante(new Jugador("Juan",27))
		var p4 = new Participante(new Jugador("Alberto",20))
		var p5 = new Participante(new Jugador("Fabio",20))
		var p6 = new Participante(new Jugador("Alejo",26))
		var p7 = new Participante(new Jugador("Casio",29))
		var p8 = new Participante(new Jugador("Alan",30))
		
		//Inscripciones
		partido.inscribir( new InscripcionEstandar(p1))
		partido.inscribir( new InscripcionEstandar(p2))
		partido.inscribir( new InscripcionEstandar(p3))
		partido.inscribir( new InscripcionEstandar(p4))
		partido.inscribir( new InscripcionEstandar(p5))
		partido.inscribir( new InscripcionEstandar(p6))
		partido.inscribir( new InscripcionEstandar(p7))
		partido.inscribir( new InscripcionEstandar(p8))
		
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
		var p9 = new Participante(new Jugador("Carlos",20))
		
		//Inscripciones
		partido.inscribir( new InscripcionEstandar(p9))
		
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
		var p10 = new Participante(new Jugador("Lucas",20))
		
		//Inscripciones
		partido.inscribir( new InscripcionEstandar(p10))
		
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