package test

import org.junit.Test
import org.junit.Assert
import domain.Partido
import java.util.Date
import domain.Jugador
import domain.Participante
import domain.InscripcionEstandar

class PruebasDeBajaDeJugadores 
{
	
	//TODO AVERIGUAR COMO COMPARTIR EL SETUP DE ESTOS DOS ESCENARIOS!
	
	@Test
	def public void cuandoUnJugadorSeBajaDejaDeEstarInscripto()
	{
		var partido = new Partido(new Date());
		var jugadorJuan = new Jugador("Juan", 18);
		var partJuan = new Participante(jugadorJuan);		
		partJuan.setModalidad(new InscripcionEstandar(partJuan));
		partJuan.inscribirse(partido);
		
		partJuan.bajarse(partido);
		
		Assert.assertFalse(partido.estaInscripto(jugadorJuan));	
	}
	
	@Test
	def public void cuandoUnJugadorSeBajaYNoDesignaUnReemplazanteSeLeGeneraUnaInfraccion()
	{
		var partido = new Partido(new Date());
		var jugadorJuan = new Jugador("Juan", 18);
		var partJuan = new Participante(jugadorJuan);		
		partJuan.setModalidad(new InscripcionEstandar(partJuan));
		partJuan.inscribirse(partido);
		
		partJuan.bajarse(partido);
		
		Assert.assertTrue(jugadorJuan.getInfracciones().length == 1);
	}
	
}