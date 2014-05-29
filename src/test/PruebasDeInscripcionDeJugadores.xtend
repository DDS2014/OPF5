package test

//import static org.junit.Assert.*;

import domain.Jugador
import domain.Partido
import domain.excepciones.JugadorNoFueAnotadoException
import domain.excepciones.NoHayLugarParaAnotarseException
import domain.inscripcion.InscripcionCondicional
import domain.inscripcion.InscripcionEstandar
import domain.inscripcion.InscripcionSolidaria
import domain.inscripcion.condiciones.Condicion_LimiteDeEdad
import java.util.Date
import org.junit.Assert
import org.junit.Test
import static test.Creaciones.*

public class PruebasDeInscripcionDeJugadores
{
	@Test
	def public void inscriboUnJugadorAUnPartidoYQuedaInscripto()
	{
		var partido = new Partido(new Date);
		var jugador = new Jugador("Pedrito",23, new InscripcionEstandar());
				
		jugador.inscribirse(partido);
		
		Assert.assertTrue(partido.estaInscripto(jugador));
	}
	
	@Test
	def public void cuandoUnJugadorDesplazaAOtroElDesplazadorQuedaInscriptoYElDesplazadoSale()
	{
		var partido = new Partido(new Date);
		var saliente = new Jugador("Juancito",25, new InscripcionEstandar());
		var entrante = new Jugador("Jorgito",20, new InscripcionEstandar());
		
		partido.reemplazar(entrante, saliente);
		
		Assert.assertTrue(partido.estaInscripto(entrante)); //esta inscripto juancito, no me importa como
		Assert.assertFalse(partido.estaInscripto(saliente));
	}
	
	@Test (expected = NoHayLugarParaAnotarseException)
	def public void noSePuedeAnotarNadieAUnPartidoCon10Estandar() //TODO agregar excepcion
	{
		var partidoEstandar = Creaciones.crearPartidoLlenoCon10Estandar();
		
		var colgado = new Jugador("Jorgito",20, new InscripcionEstandar());
		
		//colgado.setModalidad(new InscripcionEstandar(colgado));
		colgado.inscribirse(partidoEstandar);
		
		Assert.assertFalse(partidoEstandar.estaInscripto(colgado));
		//try
		//{		
		//	partidoEstandar.inscribir(new InscripcionEstandar(colgado))
		//	Assert.fail("No falló la inscripción aunque el partido estaba lleno, algo anda mal");
		//}
		//catch(NoHayLugarParaAnotarseException excepcion)
		//{
		//	Assert.assertFalse(partidoEstandar.estaInscripto(colgado.jugador));
		//}
		
	}
	
	@Test
	def public void enUnaListaCon9EstandarY1SolidarioPuedeEntrarOtroEstandarDesplazandoAlSolidario() 
	{
	var partido = Creaciones.crearPartidoCon9Estandar();
	var jugadorSolidario = new Jugador("Marquitos",20, new InscripcionSolidaria());
	var	jugadorNuevo = new Jugador("Miguelito",20, new InscripcionEstandar());
		
	jugadorSolidario.inscribirse(partido);
	jugadorNuevo.inscribirse(partido);
		
	Assert.assertTrue(partido.estaInscripto(jugadorNuevo));
	Assert.assertFalse(partido.estaInscripto(jugadorSolidario));
		//esto podrían ser dos casos de prueba pero recordar que el mecanismo de desplazamiento ya se prueba en detalle en otros test. si esos test dan bien entonces estos dos assert van a tener que fallar o tener éxito siempre juntos
	}
	
	@Test
	def public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoEstandarDesplazaAlCondicional() 
	{
		var partido = Creaciones.crearPartidoCon8Estandar();
		var jugadorCondicional = new Jugador("Josecito",34, new InscripcionCondicional(new Condicion_LimiteDeEdad(20,2,true,true))); //(sí, se lee un poco feo)
		var jugadorSolidario = new Jugador("Marquitos",20, new InscripcionSolidaria());
	
		jugadorSolidario.inscribirse(partido);
		jugadorCondicional.inscribirse(partido);	
		
		var jugadorNuevo = new Jugador("Pablito",20, new InscripcionEstandar());
			
		jugadorNuevo.inscribirse(partido);
	
		Assert.assertTrue(partido.estaInscripto(jugadorNuevo));
		Assert.assertTrue(partido.estaInscripto(jugadorSolidario));
		Assert.assertFalse(partido.estaInscripto(jugadorCondicional));
	}
	
	//TODO FIXME HORRIBLE REPETICION DE CODIGO ACA!
	
	@Test
	def public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoSolidarioDesplazaAlCondicional() 
	{
		var partido = Creaciones.crearPartidoCon8Estandar();
		var jugadorCondicional = new Jugador("Josecito",34, new InscripcionCondicional(new Condicion_LimiteDeEdad(20,2,true,true))); //(sí, se lee un poco feo)
		var jugadorSolidario = new Jugador("Marquitos",20, new InscripcionSolidaria());
	
		jugadorSolidario.inscribirse(partido);
		jugadorCondicional.inscribirse(partido);	
		
		var jugadorNuevo = new Jugador("Pablito",20, new InscripcionSolidaria());
			
		jugadorNuevo.inscribirse(partido);
	
		Assert.assertTrue(partido.estaInscripto(jugadorNuevo));
		Assert.assertTrue(partido.estaInscripto(jugadorSolidario));
		Assert.assertFalse(partido.estaInscripto(jugadorCondicional));
	}
	
	@Test (expected = JugadorNoFueAnotadoException)
	def public void noSePuedeAnotarAlMismoJugadorDosVeces()
	{
		var jugador = new Jugador("Manuelito",24, new InscripcionEstandar());
		var partido = new Partido(new Date);
		
		jugador.inscribirse(partido);
		jugador.inscribirse(partido);		
		
		//Assert.assertEquals(1,partido.obtenerCantidadDeInscriptos());
		Assert.assertEquals(1,partido.jugadoresConfirmados.size);
	}
	
	@Test
	def public void alHaberDosSolidariosParaDesplazarSeDesplazaAlQueSeAnotoPrimero() 
	{
		var partido = Creaciones.crearPartidoCon8Estandar();
		var primerJugador = new Jugador("Danielito",25, new InscripcionSolidaria());
		var segundoJugador =new Jugador("Fernandito",24, new InscripcionSolidaria());

		primerJugador.inscribirse(partido);
		segundoJugador.inscribirse(partido);
		var nuevoJugador = new Jugador("Dieguito",18, new InscripcionEstandar());
		
		nuevoJugador.inscribirse(partido);
		
		Assert.assertTrue(partido.estaInscripto(nuevoJugador))
		Assert.assertTrue(partido.estaInscripto(segundoJugador))
		Assert.assertFalse(partido.estaInscripto(primerJugador))
		
	}
}

	
