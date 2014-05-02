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

		partido.reemplazar(saliente, entrante);
		
		Assert.assertTrue(partido.estaInscripto(entrante.jugador)); //esta inscripto juancito, no me importa como
		Assert.assertFalse(partido.estaInscripto(saliente.jugador));
	}
	
	@Test 
	def public void noSePuedeAnotarNadieAUnPartidoCon10Estandar() //TODO agregar excepcion //TODO Refactor
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
		var colgado = new Participante(new Jugador("Jorgito",20), new InscripcionEstandar());
		
		try
		{		
			colgado.inscribirse(partidoEstandar); 
			Assert.fail("No falló la inscripción aunque el partido estaba lleno, algo anda mal");
		}
		catch(ImposibleAnotarseException excepcion)
		{
			Assert.assertFalse(partidoEstandar.estaInscripto(colgado.jugador));
		}
		
	}
	
	@Test
	def public void enUnaListaCon9EstandarY1SolidarioPuedeEntrarOtroEstandarDesplazandoAlSolidario() //TODO Refactor
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
	var jugadorSolidario = new Participante(new Jugador("Marquitos",20), new InscripcionSolidaria);
	part1.inscribirse(partido);
	part2.inscribirse(partido);
	part3.inscribirse(partido);
	part4.inscribirse(partido);
	part5.inscribirse(partido);
	part6.inscribirse(partido);
	part7.inscribirse(partido);
	part8.inscribirse(partido);
	part9.inscribirse(partido);
	jugadorSolidario.inscribirse(partido);
	var	jugadorNuevo = new Participante(new Jugador("Miguelito",20),new InscripcionEstandar);
		
	jugadorNuevo.inscribirse(partido);
		
	Assert.assertTrue(partido.estaInscripto(jugadorNuevo.jugador));
	Assert.assertFalse(partido.estaInscripto(jugadorSolidario.jugador));
		//esto podrían ser dos casos de prueba pero recordar que el mecanismo de desplazamiento ya se prueba en detalle en otros test. si esos test dan bien entonces estos dos assert van a tener que fallar o tener éxito siempre juntos
		}
	
	@Test
	def public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoEstandarDesplazaAlCondicional() //TODO Refactor
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
	var jugadorCondicional = new Participante(new Jugador("Josecito",34), new InscripcionCondicional(new Condicion_LimiteDeEdad(20,2,true,true)));
	var jugadorSolidario = new Participante(new Jugador("Marquitos",20), new InscripcionSolidaria);
	part1.inscribirse(partido);
	part2.inscribirse(partido);
	part3.inscribirse(partido);
	part4.inscribirse(partido);
	part5.inscribirse(partido);
	part6.inscribirse(partido);
	part7.inscribirse(partido);
	part8.inscribirse(partido);
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
	def public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoSolidarioDesplazaAlCondicional() //TODO Refactor
	{
		var partido = new Partido (new Date);
		var jugadorSolidario = new Participante(new Jugador("Ricardito",25), new InscripcionSolidaria);
		var jugadorCondicional = new Participante(new Jugador("Josecito",34), new InscripcionCondicional(new Condicion_LimiteDeEdad(20,2,true,true)));
		var	part3 = new Participante(new Jugador("Juan",27), new InscripcionEstandar());
		var	part4 = new Participante(new Jugador("Alberto",20), new InscripcionEstandar());
		var	part5 = new Participante(new Jugador("Fabio",20), new InscripcionEstandar());
		var	part6 = new Participante(new Jugador("Alejo",26), new InscripcionEstandar());
		var	part7 = new Participante(new Jugador("Casio",29), new InscripcionEstandar());
		var	part8 = new Participante(new Jugador("Alan",30), new InscripcionEstandar());
		var	part9 = new Participante(new Jugador("Carlos",20), new InscripcionEstandar());
		var	part10 = new Participante(new Jugador("Lucas",22), new InscripcionEstandar());
		part3.inscribirse(partido);
		part4.inscribirse(partido);
		part5.inscribirse(partido);
		part6.inscribirse(partido);
		part7.inscribirse(partido);
		part8.inscribirse(partido);
		part9.inscribirse(partido);
		part10.inscribirse(partido);
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
	def public void alHaberDosSolidariosParaDesplazarSeDesplazaAlQueSeAnotoPrimero() //TODO Refactor
	{
		var partido = new Partido (new Date);
		var primerJugador = new Participante(new Jugador("Danielito",25), new InscripcionSolidaria);
		var segundoJugador = new Participante(new Jugador("Fernandito",24), new InscripcionSolidaria);
		var	part3 = new Participante(new Jugador("Juan",27), new InscripcionEstandar());
		var	part4 = new Participante(new Jugador("Alberto",20), new InscripcionEstandar());
		var	part5 = new Participante(new Jugador("Fabio",20), new InscripcionEstandar());
		var	part6 = new Participante(new Jugador("Alejo",26), new InscripcionEstandar());
		var	part7 = new Participante(new Jugador("Casio",29), new InscripcionEstandar());
		var	part8 = new Participante(new Jugador("Alan",30), new InscripcionEstandar());
		var	part9 = new Participante(new Jugador("Carlos",20), new InscripcionEstandar());
		var	part10 = new Participante(new Jugador("Lucas",22), new InscripcionEstandar());
		part3.inscribirse(partido);
		part4.inscribirse(partido);
		part5.inscribirse(partido);
		part6.inscribirse(partido);
		part7.inscribirse(partido);
		part8.inscribirse(partido);
		part9.inscribirse(partido);
		part10.inscribirse(partido);
		
		primerJugador.inscribirse(partido);
		segundoJugador.inscribirse(partido);
		var nuevoJugador = new Participante(new Jugador("Dieguito",18), new InscripcionEstandar());
		
		nuevoJugador.inscribirse(partido);
		
		Assert.assertTrue(partido.estaInscripto(nuevoJugador.jugador))
		Assert.assertTrue(partido.estaInscripto(segundoJugador.jugador))
		Assert.assertFalse(partido.estaInscripto(primerJugador.jugador))
		
	}
}

	
