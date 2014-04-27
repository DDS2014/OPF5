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
		
		//Assert.assertFalse(partido.estaInscripto(colgado);
	}

	
}