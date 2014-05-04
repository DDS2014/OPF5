package test

import domain.Partido
import domain.Participante
import domain.Jugador
import domain.InscripcionEstandar
import java.util.Date

public class Creaciones 
{
	def static crearPartidoLlenoCon10Estandar()
	{
		var partidoEstandar = new Partido (new Date);
		
		var part1 = new Participante(new Jugador("Pepe",20), new InscripcionEstandar());
		var	part2 = new Participante(new Jugador("Luis",35), new InscripcionEstandar());
		var	part3 = new Participante(new Jugador("Juan",27), new InscripcionEstandar());
		var	part4 = new Participante(new Jugador("Alberto",20), new InscripcionEstandar());
		var	part5 = new Participante(new Jugador("Fabio",20), new InscripcionEstandar());
		var	part6 = new Participante(new Jugador("Alejo",26), new InscripcionEstandar());
		var	part7 = new Participante(new Jugador("Casio",29), new InscripcionEstandar());
		var	part8 = new Participante(new Jugador("Alan",30), new InscripcionEstandar());
		var	part9 = new Participante(new Jugador("Carlos",20), new InscripcionEstandar());
		var	part10 = new Participante(new Jugador("Lucas",20), new InscripcionEstandar());
		part1.inscribirse(partidoEstandar);
		part2.inscribirse(partidoEstandar);
		part3.inscribirse(partidoEstandar);
		part4.inscribirse(partidoEstandar);
		part5.inscribirse(partidoEstandar);
		part6.inscribirse(partidoEstandar);
		part7.inscribirse(partidoEstandar);
		part8.inscribirse(partidoEstandar);
		part9.inscribirse(partidoEstandar);		
		part10.inscribirse(partidoEstandar);	
		
		return partidoEstandar;	
	}
	
	def static crearPartidoCon9Estandar()
	{
		var partido = new Partido (new Date)	
		var part1 = new Participante(new Jugador("Pepe",20), new InscripcionEstandar());
		var	part2 = new Participante(new Jugador("Luis",35), new InscripcionEstandar());
		var	part3 = new Participante(new Jugador("Juan",27), new InscripcionEstandar());
		var	part4 = new Participante(new Jugador("Alberto",20), new InscripcionEstandar());
		var	part5 = new Participante(new Jugador("Fabio",20), new InscripcionEstandar());
		var	part6 = new Participante(new Jugador("Alejo",26), new InscripcionEstandar());
		var	part7 = new Participante(new Jugador("Casio",29), new InscripcionEstandar());
		var	part8 = new Participante(new Jugador("Alan",30), new InscripcionEstandar());
		var	part9 = new Participante(new Jugador("Carlos",20), new InscripcionEstandar());
		part1.inscribirse(partido);
		part2.inscribirse(partido);
		part3.inscribirse(partido);
		part4.inscribirse(partido);
		part5.inscribirse(partido);
		part6.inscribirse(partido);
		part7.inscribirse(partido);
		part8.inscribirse(partido);
		part9.inscribirse(partido);
		
		return partido;
	}
	
	def static crearPartidoCon8Estandar()
	{
		var partido = new Partido (new Date)	
		var part1 = new Participante(new Jugador("Pepe",20), new InscripcionEstandar());
		var	part2 = new Participante(new Jugador("Luis",35), new InscripcionEstandar());
		var	part3 = new Participante(new Jugador("Juan",27), new InscripcionEstandar());
		var	part4 = new Participante(new Jugador("Alberto",20), new InscripcionEstandar());
		var	part5 = new Participante(new Jugador("Fabio",20), new InscripcionEstandar());
		var	part6 = new Participante(new Jugador("Alejo",26), new InscripcionEstandar());
		var	part7 = new Participante(new Jugador("Casio",29), new InscripcionEstandar());
		var	part8 = new Participante(new Jugador("Alan",30), new InscripcionEstandar());
		part1.inscribirse(partido);
		part2.inscribirse(partido);
		part3.inscribirse(partido);
		part4.inscribirse(partido);
		part5.inscribirse(partido);
		part6.inscribirse(partido);
		part7.inscribirse(partido);
		part8.inscribirse(partido);
		
		return partido;		
	}
}