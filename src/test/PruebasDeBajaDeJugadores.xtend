package test

import org.junit.Test
import org.junit.Assert
import domain.Partido
import java.util.Date
import domain.Jugador
import domain.Participante
import domain.InscripcionEstandar
import org.junit.Before

class PruebasDeBajaDeJugadores 
{
	Partido partido;
	Jugador jugadorJuan;
	Participante partJuan;
	
	@Before
	def public void setup()
	{
		partido = new Partido(new Date());
		jugadorJuan = new Jugador("Juan", 18);
		partJuan = new Participante(jugadorJuan);		
		partJuan.setModalidad(new InscripcionEstandar(partJuan));
		partJuan.inscribirse(partido);
	}
	
	@Test
	def public void cuandoUnJugadorSeBajaDejaDeEstarInscripto()
	{
//		var partido = new Partido(new Date());
//		var jugadorJuan = new Jugador("Juan", 18);
//		var partJuan = new Participante(jugadorJuan);		
//		partJuan.setModalidad(new InscripcionEstandar(partJuan));
//		partJuan.inscribirse(partido);
		
		partJuan.bajarse(partido);
		
		Assert.assertFalse(partido.estaInscripto(jugadorJuan));	
	}
	
	@Test
	def public void cuandoUnJugadorSeBajaYNoDesignaUnReemplazanteSeLeGeneraUnaInfraccion()
	{
//		var partido = new Partido(new Date());
//		var jugadorJuan = new Jugador("Juan", 18);
//		var partJuan = new Participante(jugadorJuan);		
//		partJuan.setModalidad(new InscripcionEstandar(partJuan));
//		partJuan.inscribirse(partido);
//		
		partJuan.bajarse(partido);
		
		Assert.assertTrue(jugadorJuan.getInfracciones().length == 1);
	}
	
}