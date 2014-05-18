package test

import domain.Jugador

import domain.Participante
import domain.Partido
import domain.inscripcion.InscripcionEstandar
import domain.notificaciones.NotificarAmigosObserver
import java.util.Date
import org.junit.Assert
import org.junit.Test
import domain.enviadorDeMails.distribuidor.DistribuidorStub
import static org.mockito.Mockito.*
import domain.notificaciones.NotificarAdminObserver

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
		var partido = new Partido (new Date)
		val mockedDistribuidor = mock(typeof(DistribuidorStub))
		partido.distribuidor = mockedDistribuidor
		
		//Se agregan los observers
		partido.agregarObsever(new NotificarAdminObserver)
		partido.agregarObsever(new NotificarAmigosObserver)
		
		//JUGADORES
		var p1 = new Participante(new Jugador("Pepe",20))
		var p2 = new Participante(new Jugador("Luis",35))
		var p3 = new Participante(new Jugador("Juan",27))
		var p4 = new Participante(new Jugador("Alberto",20))
		var p5 = new Participante(new Jugador("Fabio",20))
		var p6 = new Participante(new Jugador("Alejo",26))
		var p7 = new Participante(new Jugador("Casio",29))
		var p8 = new Participante(new Jugador("Alan",30))
		var p9 = new Participante(new Jugador("Carlos",20))
		var p10 = new Participante(new Jugador("Lucas",20))
		
		//Inscripciones
		partido.inscribir( new InscripcionEstandar(p1))
		partido.inscribir( new InscripcionEstandar(p2))
		partido.inscribir( new InscripcionEstandar(p3))
		partido.inscribir( new InscripcionEstandar(p4))
		partido.inscribir( new InscripcionEstandar(p5))
		partido.inscribir( new InscripcionEstandar(p6))
		partido.inscribir( new InscripcionEstandar(p7))
		partido.inscribir( new InscripcionEstandar(p8))
		partido.inscribir( new InscripcionEstandar(p9))
		partido.inscribir( new InscripcionEstandar(p10))
		
		verify(mockedDistribuidor, times(1)).enviarMail(any(typeof(String)),any(typeof(String)),any(typeof(String)))
	}
	
	@Test
	def public void CuandoUnPartidoDejaDeTener10ConfirmadosElAdministradorEsNotificado()
	{
		Assert.fail();//SIMULAR CON MOCKITO
	}
	
	@Test
	def public void CuandoUnJugadorSeInscribeSusAmigosSonNotificados()
	{
		var partido = new Partido (new Date);
		var jugadorPepe = new Jugador("Pepe",20)
		//var partPepe = new Participante(new Jugador("Pepe",20));
		//partPepe.setModalidad(new InscripcionEstandar(partPepe));
		var	jugadorLuis = new Jugador("Luis", 18);
		var jugadorPedro = new Jugador("Pedro", 20);
		jugadorPepe.hacerseAmigoDe(jugadorLuis);
		jugadorPepe.hacerseAmigoDe(jugadorPedro);
		
		partido.agregarObsever(new NotificarAmigosObserver);
		
		//partido.inscribir(new InscripcionEstandar(new Participante(jugadorPepe)))
		
		//SIMULAR CON MOCKITO
		
		//partPepe.inscribirse(partido);
		//partido.notificarJugadorConfirmadoAObservers();
		
		//Assert.assertTrue(partido.amigosNotificados())
		Assert.fail();
	}
	
}
