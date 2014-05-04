package test

//import static org.junit.Assert.*;


import org.junit.Test
import org.junit.Assert
import domain.Participante
import domain.InscripcionEstandar
import domain.Jugador
import domain.Partido
import domain.InscripcionSolidaria
import domain.InscripcionCondicional
import domain.ImposibleAnotarseException
import java.util.Date
import domain.Condicion_LimiteDeEdad

public class PruebasDeInscripcionDeJugadores
{
	@Test
	def public void inscriboUnJugadorAUnPartidoYQuedaInscripto()
	{
		var partido = new Partido(new Date);
		
		var jugador = new Jugador("Pedrito",23);
		var participante = new Participante(jugador, new InscripcionEstandar());
		
		participante.inscribirse(partido);
		
		Assert.assertTrue(partido.estaInscripto(jugador));
	}
	
	@Test
	def public void cuandoUnJugadorDesplazaAOtroElDesplazadorQuedaInscriptoYElDesplazadoSale()
	{
		var partido = new Partido(new Date);
		var saliente = new Participante( new Jugador("Juancito",25), new InscripcionEstandar());
		var entrante = new Participante(new Jugador("Jorgito",20), new InscripcionEstandar());

		partido.reemplazar(entrante, saliente);
		
		Assert.assertTrue(partido.estaInscripto(entrante.jugador)); //esta inscripto juancito, no me importa como
		Assert.assertFalse(partido.estaInscripto(saliente.jugador));
	}
	
	@Test 
	def public void noSePuedeAnotarNadieAUnPartidoCon10Estandar() //TODO agregar excepcion
	{
		var partidoEstandar = Creaciones.crearPartidoLlenoCon10Estandar();
		var colgado = new Participante(new Jugador("Jorgito",20), new InscripcionEstandar());
		Assert.assertFalse(colgado.inscribirse(partidoEstandar));
		
		//try
		//{		
		//	colgado.inscribirse(partidoEstandar); 
		//	Assert.fail("No falló la inscripción aunque el partido estaba lleno, algo anda mal");
		//}
		//catch(ImposibleAnotarseException excepcion)
		//{
		//	Assert.assertFalse(partidoEstandar.estaInscripto(colgado.jugador));
		//}
		
	}
	
	@Test
	def public void enUnaListaCon9EstandarY1SolidarioPuedeEntrarOtroEstandarDesplazandoAlSolidario() 
	{
	var partido = Creaciones.crearPartidoCon9Estandar();
	var jugadorSolidario = new Participante(new Jugador("Marquitos",20), new InscripcionSolidaria);
	var	jugadorNuevo = new Participante(new Jugador("Miguelito",20),new InscripcionEstandar);
		
	jugadorSolidario.inscribirse(partido);
	jugadorNuevo.inscribirse(partido);
		
	Assert.assertTrue(partido.estaInscripto(jugadorNuevo.jugador));
	Assert.assertFalse(partido.estaInscripto(jugadorSolidario.jugador));
		//esto podrían ser dos casos de prueba pero recordar que el mecanismo de desplazamiento ya se prueba en detalle en otros test. si esos test dan bien entonces estos dos assert van a tener que fallar o tener éxito siempre juntos
	}
	
	@Test
	def public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoEstandarDesplazaAlCondicional() 
	{
	var partido = Creaciones.crearPartidoCon8Estandar();
	var jugadorCondicional = new Participante(new Jugador("Josecito",34), new InscripcionCondicional(new Condicion_LimiteDeEdad(20,2,true,true)));
	var jugadorSolidario = new Participante(new Jugador("Marquitos",20), new InscripcionSolidaria);
	jugadorSolidario.inscribirse(partido);
	jugadorCondicional.inscribirse(partido);	
	var jugadorNuevo = new Participante( new Jugador("Pablito",20), new InscripcionEstandar);
		
	jugadorNuevo.inscribirse(partido);

	Assert.assertTrue(partido.estaInscripto(jugadorNuevo.jugador));
	Assert.assertTrue(partido.estaInscripto(jugadorSolidario.jugador));
	Assert.assertFalse(partido.estaInscripto(jugadorCondicional.jugador));
	}
	
	//TODO FIXME HORRIBLE REPETICION DE CODIGO ACA!
	
	@Test
	def public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoSolidarioDesplazaAlCondicional() 
	{
		var partido = Creaciones.crearPartidoCon8Estandar();
		var jugadorSolidario = new Participante(new Jugador("Ricardito",25), new InscripcionSolidaria);
		var jugadorCondicional = new Participante(new Jugador("Josecito",34), new InscripcionCondicional(new Condicion_LimiteDeEdad(20,2,true,true)));

		jugadorSolidario.inscribirse(partido);
		jugadorCondicional.inscribirse(partido);
		var jugadorNuevoSolidario = new Participante(new Jugador("Pablito",20), new InscripcionSolidaria);
		
		jugadorNuevoSolidario.inscribirse(partido);
		
		Assert.assertTrue(partido.estaInscripto(jugadorNuevoSolidario.jugador));
		Assert.assertTrue(partido.estaInscripto(jugadorSolidario.jugador));
		Assert.assertFalse(partido.estaInscripto(jugadorCondicional.jugador));
		
	}
	
	@Test
	def public void noSePuedeAnotarAlMismoJugadorDosVeces()
	{
		var jugador = new Jugador("Manuelito",24);
		var participante = new Participante(jugador, new InscripcionEstandar);
		var partido = new Partido(new Date);
		
		participante.inscribirse(partido);
		participante.inscribirse(partido);		
		
		//Assert.assertEquals(1,partido.obtenerCantidadDeInscriptos());
		Assert.assertEquals(1,partido.participantesConfirmados.size);
	}
	
	@Test
	def public void alHaberDosSolidariosParaDesplazarSeDesplazaAlQueSeAnotoPrimero() 
	{
		var partido = Creaciones.crearPartidoCon8Estandar();
		var primerJugador = new Participante(new Jugador("Danielito",25), new InscripcionSolidaria);
		var segundoJugador = new Participante(new Jugador("Fernandito",24), new InscripcionSolidaria);		
		primerJugador.inscribirse(partido);
		segundoJugador.inscribirse(partido);
		var nuevoJugador = new Participante(new Jugador("Dieguito",18), new InscripcionEstandar());
		
		nuevoJugador.inscribirse(partido);
		
		Assert.assertTrue(partido.estaInscripto(nuevoJugador.jugador))
		Assert.assertTrue(partido.estaInscripto(segundoJugador.jugador))
		Assert.assertFalse(partido.estaInscripto(primerJugador.jugador))
		
	}
}

	
