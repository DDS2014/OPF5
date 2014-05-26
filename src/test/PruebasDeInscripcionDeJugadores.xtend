package test

//import static org.junit.Assert.*;

import domain.Jugador
import domain.Participante
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

public class PruebasDeInscripcionDeJugadores
{
	@Test
	def public void inscriboUnJugadorAUnPartidoYQuedaInscripto()
	{
		var partido = new Partido(new Date);
		var jugador = new Jugador("Pedrito",23);
		var participante = new Participante(jugador)
		partido.inscribir(new InscripcionEstandar(participante))
		
		Assert.assertTrue(partido.estaInscripto(jugador));
	}
	
	@Test
	def public void cuandoUnJugadorDesplazaAOtroElDesplazadorQuedaInscriptoYElDesplazadoSale()
	{
		var partido = new Partido(new Date);
		var saliente = new Participante( new Jugador("Juancito",25));
		saliente.setModalidad(new InscripcionEstandar(saliente))
		var entrante = new Participante(new Jugador("Jorgito",20))
		entrante.setModalidad(new InscripcionEstandar(entrante))

		partido.reemplazar(entrante, saliente);
		
		Assert.assertTrue(partido.estaInscripto(entrante.jugador)); //esta inscripto juancito, no me importa como
		Assert.assertFalse(partido.estaInscripto(saliente.jugador));
	}
	
	@Test (expected = NoHayLugarParaAnotarseException)
	def public void noSePuedeAnotarNadieAUnPartidoCon10Estandar() //TODO agregar excepcion
	{
		var partidoEstandar = Creaciones.crearPartidoLlenoCon10Estandar();
		
		var colgado = new Participante(new Jugador("Jorgito",20));
		
		//colgado.setModalidad(new InscripcionEstandar(colgado));
		partidoEstandar.inscribir(new InscripcionEstandar(colgado));
		
		Assert.assertFalse(partidoEstandar.estaInscripto(colgado.jugador));
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
	var jugadorSolidario = new Participante(new Jugador("Marquitos",20));
	var	jugadorNuevo = new Participante(new Jugador("Miguelito",20))
	
	jugadorNuevo.setModalidad(new InscripcionEstandar(jugadorNuevo));
	
	partido.inscribir(new InscripcionSolidaria(jugadorSolidario))
	partido.inscribir(new InscripcionEstandar(jugadorNuevo))
		
	Assert.assertTrue(partido.estaInscripto(jugadorNuevo.jugador));
	Assert.assertFalse(partido.estaInscripto(jugadorSolidario.jugador));
		//esto podrían ser dos casos de prueba pero recordar que el mecanismo de desplazamiento ya se prueba en detalle en otros test. si esos test dan bien entonces estos dos assert van a tener que fallar o tener éxito siempre juntos
	}
	
	@Test
	def public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoEstandarDesplazaAlCondicional() 
	{
		var partido = Creaciones.crearPartidoCon8Estandar();
		//Inscripcion de un condicional
		var jugadorCondicional = new Participante(new Jugador("Josecito",34));
		jugadorCondicional.setModalidad(new InscripcionCondicional(jugadorCondicional, new Condicion_LimiteDeEdad(20,2,true,true)));
		partido.inscribir(new InscripcionCondicional(jugadorCondicional, new Condicion_LimiteDeEdad(20,2,true,true)))
		//Inscripcion de un solidario
		var jugadorSolidario = new Participante(new Jugador("Marquitos",20));
		partido.inscribir(new InscripcionSolidaria(jugadorSolidario))
		//Inscripcion de un estandar(ya esta lleno)
		var jugadorNuevo = new Participante(new Jugador("Pablito",20));
		partido.inscribir(new InscripcionEstandar(jugadorNuevo))
			
		Assert.assertTrue(partido.estaInscripto(jugadorNuevo.jugador));
		Assert.assertTrue(partido.estaInscripto(jugadorSolidario.jugador));
		Assert.assertFalse(partido.estaInscripto(jugadorCondicional.jugador));
	}
	
	//TODO FIXME HORRIBLE REPETICION DE CODIGO ACA!
	
	@Test
	def public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoSolidarioDesplazaAlCondicional() 
	{
		var partido = Creaciones.crearPartidoCon8Estandar();
		//Inscripcion de un solidario
		var jugadorSolidario = new Participante(new Jugador("Ricardito",25));
		partido.inscribir(new InscripcionSolidaria(jugadorSolidario))
		//Inscripcion de un condicional
		var jugadorCondicional = new Participante(new Jugador("Josecito",34));
		partido.inscribir(new InscripcionCondicional(jugadorCondicional, new Condicion_LimiteDeEdad(20,2,true,true)))
		//Inscripcion de otro solidario(ya esta lleno)
		var jugadorNuevoSolidario = new Participante(new Jugador("Pablito",20));
		partido.inscribir(new InscripcionSolidaria(jugadorNuevoSolidario))
		
		Assert.assertTrue(partido.estaInscripto(jugadorNuevoSolidario.jugador));
		Assert.assertTrue(partido.estaInscripto(jugadorSolidario.jugador));
		Assert.assertFalse(partido.estaInscripto(jugadorCondicional.jugador));
		
	}
	
	@Test (expected = JugadorNoFueAnotadoException)
	def public void noSePuedeAnotarAlMismoJugadorDosVeces()
	{
		var partido = new Partido(new Date);
		var jugador = new Jugador("Manuelito",24);
		var participante = new Participante(jugador);
		partido.inscribir(new InscripcionEstandar(participante))
		partido.inscribir(new InscripcionEstandar(participante))
		
		//Assert.assertEquals(1,partido.obtenerCantidadDeInscriptos());
		Assert.assertEquals(1,partido.participantesConfirmados.size);
	}
	
	@Test
	def public void alHaberDosSolidariosParaDesplazarSeDesplazaAlQueSeAnotoPrimero() 
	{
		var partido = Creaciones.crearPartidoCon8Estandar();
		var primerJugador = new Participante(new Jugador("Danielito",25));
		partido.inscribir(new InscripcionSolidaria(primerJugador))
		
		var segundoJugador = new Participante(new Jugador("Fernandito",24));
		partido.inscribir(new InscripcionSolidaria(segundoJugador))

		var nuevoJugador = new Participante(new Jugador("Dieguito",18));
		partido.inscribir(new InscripcionEstandar(nuevoJugador))
				
				
		Assert.assertTrue(partido.estaInscripto(nuevoJugador.jugador))
		Assert.assertTrue(partido.estaInscripto(segundoJugador.jugador))
		Assert.assertFalse(partido.estaInscripto(primerJugador.jugador))
		
	}
}

	
