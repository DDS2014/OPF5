package test

import static org.junit.Assert.*;
import junit.framework.Assert;

import domain.*;

import org.junit.Test;

public class PruebasDeInscripcionDeJugadores
{
	@Test
	def public void inscriboUnJugadorAUnPartidoYQuedaInscripto()
	{
		//Partido partido = new Partido(fecha, hora);
		//Jugador jugador = new Jugador("Pedrito");
		
		//partido.inscribir(jugador, new Estandar());
		
		//Assert.assertTrue(partido.estaInscripto(jugador));
	}
	
	@Test
	def public void cuandoUnJugadorDesplazaAOtroElDesplazadorQuedaInscripto()
	{
		//Partido partido = new Partido(fecha, hora);
		//Jugador saliente = new Jugador("Juancito");
		//Jugador entrante = new Jugador("Jorgito");
		
		//partido.reemplazarJugadorPorOtro(saliente, entrante);
		
		//Assert.assertTrue(partido.estaInscripto(entrante));
	}
	
	//TODO FIXME: EL CODIGO DE ESTOS DOS MÉTODOS ES EXACTAMENTE IGUAL!
	//agregar un metodo intermedio que ejecute el desplazamiento? o por ahí no sea tan grave meter las dos cosas en el mismo test
	
	@Test
	def public void cuandoUnJugadorDesplazaAOtroElDesplazadoNoQuedaInscripto()
	{
		//Partido partido = new Partido(fecha, hora);
		//Jugador saliente = new Jugador("Juancito");
		//Jugador entrante = new Jugador("Jorgito");

		//partido.reemplazarJugadorPorOtro(saliente, entrante);
		
		//Assert.assertFalse(partido.estaInscripto(saliente));
	}
	
	@Test
	def public void noSePuedeAnotarNadieAUnPartidoCon10Estandar()
	{
		//Partido partido = Creacion.crearPartidoLlenoDeEstandares(); 
		//Jugador colgado = new Jugador ("Fulanito");
		
		//partido.inscribir(colgado, new Estandar()); 
		
		//Assert.assertFalse(partido.estaInscripto(colgado));
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
	}
	
	//TODO FIXME HORRIBLE REPETICION DE CODIGO ACA!
	
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
	}
}

	
