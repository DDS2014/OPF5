package test

import domain.Jugador
import domain.Participante
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
	Participante partJuan;
	
	@Before
	def public void setup()
	{
		partido = new Partido(new Date());
		jugadorJuan = new Jugador("Juan", 18);
		partJuan = new Participante(jugadorJuan);	
		
		partido.inscribir(new InscripcionEstandar(partJuan))
		
		/*
		partJuan = new Participante(jugadorJuan);		
		partJuan.setModalidad(new InscripcionEstandar(partJuan));
		partJuan.inscribirse(partido);
		*/
	}
	
	@Test
	def public void cuandoUnJugadorSeBajaDejaDeEstarInscripto()
	{
		partJuan.bajarse(partido);
		
		Assert.assertFalse(partido.estaInscripto(jugadorJuan));	
	}
	
	@Test
	def public void cuandoUnJugadorSeBajaYNoDesignaUnReemplazanteSeLeGeneraUnaInfraccion()
	{
		partJuan.bajarse(partido);
		
		Assert.assertTrue(jugadorJuan.getInfracciones().length == 1);
	}
	
}