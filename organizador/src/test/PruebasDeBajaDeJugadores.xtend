package test

import domain.Jugador
import domain.Partido
import domain.inscripcion.InscripcionEstandar
import java.util.Date
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PruebasDeBajaDeJugadores 
{
	Partido partido;
	Jugador jugadorJuan;
	
	@Before
	def public void setup()
	{
		partido = new Partido(new Date());
		jugadorJuan = new Jugador("Juan", 18, new InscripcionEstandar());	
		
		jugadorJuan.inscribirse(partido);
	
		/*
		partJuan = new Participante(jugadorJuan);		
		partJuan.setModalidad(new InscripcionEstandar(partJuan));
		partJuan.inscribirse(partido);
		*/
	}
	
	@Test
	def public void cuandoUnJugadorSeBajaDejaDeEstarInscripto()
	{
		jugadorJuan.bajarse(partido);
		
		Assert.assertFalse(partido.estaInscripto(jugadorJuan));	
	}
	
	@Test
	def public void cuandoUnJugadorSeBajaYNoDesignaUnReemplazanteSeLeGeneraUnaInfraccion()
	{
		jugadorJuan.bajarse(partido);
		
		Assert.assertTrue(jugadorJuan.getInfracciones().length == 1);
	}
	
}