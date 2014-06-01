package test

import org.junit.Test
import domain.sugerencias.Comunidad
import org.junit.Before
import domain.inscripcion.InscripcionEstandar
import domain.Jugador
import java.util.Date
import domain.Partido
import domain.sugerencias.Sugerencia
import domain.inscripcion.InscripcionSolidaria
import org.junit.Assert

class PruebasDeSugerencias 
{
	/*Pruebas a realizarse:
	 * Si sugiero un jugador, y se aprueba, queda dentro de la comunidad
	 * Si sugiero un jugador, y se rechaza, no queda en la comunidad
	 * Si sugiero un jugador, queda pendiente
	 * Si sugiero un jugador y se rechaza, queda registrada la denegación
	 * Si sugiero un jugador, y se aprueba, este jugador después puede anotarse a los partidos lo más bien
	 */
	
	Comunidad losMuchachos = new Comunidad();
	var partidoDelDomingo = new Partido(new Date()); //no se preocupen, esto lo codeé un domingo
//	Jugador martin
//	Jugador roman
//	Partido partidoDelDomingo
	
	@Before
	def void setup()
	{
		var martin = new Jugador("Martin", 40, new InscripcionEstandar())
		var roman = new Jugador("Roman", 35, new InscripcionEstandar());
		losMuchachos.agregar(martin);
		losMuchachos.agregar(roman);
		losMuchachos.organizarPartido(partidoDelDomingo);
		
	}
	
	@Test
	def void cuandoAprueboUnJugadorQuedaEnLaComunidad()
	{
		var rodrigo = new Sugerencia("Rodrigo", 32);
		losMuchachos.sugerir(rodrigo);
		losMuchachos.aprobar(rodrigo, new InscripcionSolidaria()); //FIXME por qué estoy poniendo la modalidad dos veces?
		Assert.assertTrue(losMuchachos.aprobados.length == 3) //3 porque recordar que ya estaban martín y román		
	}
	
	@Test
	def void cuandoRechazoUnJugadorNoQuedaEnLaComunidad()
	{
		var hernan = new Sugerencia("Hernan", 38);
		losMuchachos.sugerir(hernan);
		losMuchachos.rechazar(hernan, "No se lleva bien con el resto de los muchachos"); //FIXME por qué estoy poniendo la modalidad dos veces?
		Assert.assertTrue(losMuchachos.aprobados.length == 2) //martín y román	
	}

	@Test
	def void cuandoSugieroUnJugadorQuedaPendiente()
	{
		var hernan = new Sugerencia("Hernan", 38);
		losMuchachos.sugerir(hernan);
		
		Assert.assertTrue(losMuchachos.pendientes.length == 1)
	}
	
	@Test
	def void cuandoRechazoUnJugadorSeRegistraLaDenegacion()
	{
		var hernan = new Sugerencia("Hernan", 38);
		losMuchachos.sugerir(hernan);
		losMuchachos.rechazar(hernan, "No se lleva bien con el resto de los muchachos");
		Assert.assertTrue(losMuchachos.rechazados.length == 1)
	}
	
	@Test
	def void cuandoAprueboUnJugadorEntoncesSePuedeAnotarAlPartido()
	{
		var amigoDeMartin = new Sugerencia("Guillermo", 41);
		losMuchachos.sugerir(amigoDeMartin);
		var guillermo = losMuchachos.aprobar(amigoDeMartin, new InscripcionEstandar());
		guillermo.inscribirse(partidoDelDomingo);
		Assert.assertTrue(partidoDelDomingo.estaInscripto(guillermo));
	}
	
}