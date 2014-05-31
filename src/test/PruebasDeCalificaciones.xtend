package test

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import domain.Jugador
import domain.Partido
import java.util.Date
import domain.inscripcion.InscripcionEstandar
import domain.inscripcion.InscripcionSolidaria
import domain.excepciones.ImposibleCalificarException
import java.util.Calendar

public class PruebasDeCalificaciones {
	Partido partido1;
	Partido partido2;
	Jugador jugador1;
	Jugador jugador2;
	
	@Before
	def public void setup()
	{
		//Partidos
		partido1 = new Partido(new Date());
		partido2 = new Partido(new Date());
		
		//Jugadores
		jugador1 = new Jugador("Juan", 18, new InscripcionEstandar());
		jugador2 = new Jugador("Pedro", 25, new InscripcionSolidaria());	
		
		//Inscripciones
		//Jugador1
		jugador1.inscribirse(partido1);
		jugador1.inscribirse(partido2)
		//Jugador2
		jugador2.inscribirse(partido2);
		
		//Calificaciones
		jugador1.calificar(8,"Muy bueno",partido1,jugador2)
		jugador1.calificar(5,"Regular",partido2,jugador2)
		
		jugador2.calificar(3,"Pesimo",partido2,jugador1)
	}
	
	@Test (expected = ImposibleCalificarException)
	def public void NoSePuedeCalificarAUnJugadorNoInscripto()
	{
		jugador2.calificar(10,"Excelente",partido1,jugador1)
	}
	
	@Test (expected = ImposibleCalificarException)
	def public void NoSePuedeCalificarAUnJugadorMasDeUnaVezEnElMismoPartido()
	{
		jugador1.calificar(10,"Excelente",partido1,jugador2)
	}
	

	@Test
	def public void NoSePuedeCalificarAUnJugadorSiElPartidoNoSeJugo(){
		val fecha = new Date()
		val proximoMes =fecha.getMonth()
		fecha.setMonth(proximoMes)
		var partido = new Partido(fecha)
		jugador2.inscribirse(partido)
		
		jugador2.calificar(10,"Excelente",partido,jugador1)
	}

	
	@Test
	def public void SeCalificaAUnJugadorEnVariosPartidos(){
		jugador2.inscribirse(partido1)
		jugador2.calificar(10,"Excelente",partido1,jugador1)
		
		Assert.assertEquals(jugador2.calificaciones.size,2)
	}
}