package test

//import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import domain.Partido
import domain.Jugador
import domain.InscripcionEstandar
import domain.Participante

public class PruebasDeInscripcionDeJugadores
{
	@Test
	def public void inscriboUnJugadorAUnPartidoYQuedaInscripto()
	{
		var partido = new Partido("25/05/2014", "16:00");
		
		var jugador = new Jugador("Pedrito");
		var participante = new Participante(jugador, new InscripcionEstandar());
		
		participante.inscribirse(partido);
		
		Assert.assertTrue(partido.estaInscripto(jugador));
	}
	
	@Test
	def public void cuandoUnJugadorDesplazaAOtroElDesplazadorQuedaInscripto()
	{
		var partido = new Partido("25/06/2014", "08:30");
		var saliente = new Participante( new Jugador("Juancito"), new InscripcionEstandar());
		var entrante = new Participante(new Jugador("Jorgito"), new InscripcionEstandar());

		partido.reemplazar(saliente, entrante);
		
		Assert.assertTrue(partido.estaInscripto(entrante.jugador)); //esta inscripto juancito, no me importa como
	}
	
	//TODO FIXME: EL CODIGO DE ESTOS DOS MÉTODOS ES EXACTAMENTE IGUAL!
	//agregar un metodo intermedio que ejecute el desplazamiento? o por ahí no sea tan grave meter las dos cosas en el mismo test
	
	@Test
	def public void cuandoUnJugadorDesplazaAOtroElDesplazadoNoQuedaInscripto()
	{
		var partido = new Partido("25/06/2014", "08:30");
		var saliente = new Participante( new Jugador("Juancito"), new InscripcionEstandar());
		var entrante = new Participante(new Jugador("Jorgito"), new InscripcionEstandar());

		partido.reemplazar(saliente, entrante);
		
		Assert.assertFalse(partido.estaInscripto(saliente.jugador)); //esta inscripto juancito, no me importa como
	}
	
	@Test ()
	def public void noSePuedeAnotarNadieAUnPartidoCon10Estandar() //TODO agregar excepcion
	{
		//Partido partido = Creacion.crearPartidoLlenoDeEstandares(); 
		//Jugador colgado = new Jugador ("Fulanito");
		
		//partido.inscribir(colgado, new Estandar()); 
		
		//Assert.assertFalse(partido.estaInscripto(colgado));
		Assert.fail("Not implemented");
	}
	
	@Test
	def public void enUnaListaCon9EstandarY1SolidarioPuedeEntrarOtroEstandarDesplazandoAlSolidario()
	{
		//Jugador jugadorSolidario = new Jugador("Marquitos");
		//Partido partido = Creacion.crearPartidoCon9EstandarY1Solidario(jugadorSolidario); //lo que se pasa por parámetro es el jugador solidario para verificar después que se lo relegó
		//Jugador jugadorNuevo = new Jugador("Miguelito");
		
		//partido.inscribir(jugadorNuevo, new Estandar());
		
		//Assert.assertTrue(partido.estaInscripto(jugadorNuevo));
		//Assert.assertFasle(partido.estaInscripto(jugadorSolidario));
		//esto podrían ser dos casos de prueba pero recordar que el mecanismo de desplazamiento ya se prueba en detalle en otros test. si esos test dan bien entonces estos dos assert van a tener que fallar o tener éxito siempre juntos
		Assert.fail("Not implemented");
	}
	
	@Test
	def public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoEstandarDesplazaAlCondicional()
	{
		//Jugador jugadorCondicional = new Jugador("Josecito");
		//Jugador jugadorSolidario = new Jugador("Ricardito");
		//Partido partido = Creacion.crearPartidoCon8Estandar1Solidarioy1Condicional(jugadorSolidario, jugadorCondicional);
		//Jugador jugadorNuevo = new Jugador("Pablito");
		
		//partido.inscribir(jugadorNuevo, new Estandar());
		
		//Assert.assertTrue(partido.estaInscripto(jugadorNuevo));
		//Assert.assertTrue(partido.estaInscripto(jugadorSolidario));
		//Assert.assertFalse(partido.estaInscripto(jugadorCondicional));
		Assert.fail("Not implemented");
	}
	
	//TODO FIXME HORRIBLE REPETICION DE CODIGO ACA!
	
	@Test
	def public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoSolidarioDesplazaAlCondicional()
	{
		//Jugador jugadorCondicional = new Jugador("Josecito");
		//Jugador jugadorSolidario = new Jugador("Ricardito");
		//Partido partido = Creacion.crearPartidoCon8Estandar1Solidarioy1Condicional(jugadorSolidario, jugadorCondicional);
		//Jugador jugadorNuevo = new Jugador("Pablito");
		
		//partido.inscribir(jugadorNuevo, new Solidario());
		
		//Assert.assertTrue(partido.estaInscripto(jugadorNuevo));
		//Assert.assertTrue(partido.estaInscripto(jugadorSolidario));
		//Assert.assertFalse(partido.estaInscripto(jugadorCondicional));
		Assert.fail("Not implemented");
	}
	
	@Test
	def public void noSePuedeAnotarAlMismoJugadorDosVeces()
	{
		var jugador = new Jugador("Manuelito");
		var participante = new Participante(jugador, new InscripcionEstandar);
		var partido = new Partido("25/06/2014", "08:30");
		
		participante.inscribirse(partido);
		participante.inscribirse(partido);		
		
		Assert.assertTrue(partido.obtenerCantidadDeInscriptos() == 1);
	}
	
	@Test
	def public void alHaberDosSolidariosParaDesplazarSeDesplazaAlQueSeAnotoPrimero()
	{
		//Jugador primerJugador = new Jugador("Danielito");
		//Jugador segundoJugador = new Jugador("Fernandito");
		//Partido partido = Creacion.crearPartidoCon8JugadoresEstandar();
		//partido.inscribir(primerJugador, new Solidario());
		//partido.inscribir(segundoJugador, new Solidario());
		//Jugador nuevoJugador = new Jugador("Dieguito");
		
		//partido.inscribir(nuevoJugador, new Estandar());
		
		//Assert.assertTrue(partido.estaInscripto(nuevoJugador))
		//Assert.assertTrue(partido.estaInscripto(segundoJugador))
		//Assert.assertFalse(partido.estaInscripto(primerJugador))
		Assert.fail("Not implemented");
	}
}

	
