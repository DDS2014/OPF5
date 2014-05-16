package test

import org.junit.Test
import org.junit.Assert
import domain.Jugador

public class PruebasDeEnvioDeNotificaciones 
{
	@Test
	def public void CuandoHagoAmigosADosJugadoresAmbosSeTienenDeAmigos()
	//este test en realidad no necesariamente va acá, pero es parte de lo necesario para probar las notificaciones
	//siendo estrictos debería ir en otra clase PruebasDeAmistad o algo así, pero como no hay caso de uso de eso... no sé, lo dejo acá?
	{
		//setup
		var	jugadorJuan = new Jugador("Juan", 18);	
		var jugadorPedro = new Jugador("Pedro", 20);
		
		//accion
		jugadorJuan.hacerseAmigoDe(jugadorPedro);
		
		//verificacion
		Assert.assertTrue(jugadorJuan.tieneAlAmigo(jugadorPedro));
		Assert.assertTrue(jugadorPedro.tieneAlAmigo(jugadorJuan));
		
	}
	
	
	
	@Test
	def public void CuandoUnPartidoEsConfirmadoElAdministradorEsNotificado()
	{
		Assert.fail();	
	}
	
	@Test
	def public void CuandoUnPartidoDejaDeTener10ConfirmadosElAdministradorEsNotificado()
	{
		Assert.fail();
	}
	
	@Test
	def public void CuandoUnJugadorSeInscribeSusAmigosSonNotificados()
	{
		Assert.fail();
	}
	
}