package test

import domain.Jugador
import domain.Partido
import domain.enviadorDeMails.InterfazDistribuidorDeMails
import domain.inscripcion.InscripcionEstandar
import domain.notificaciones.NotificarAdminObserver
import domain.notificaciones.NotificarAmigosObserver
import java.util.Date
import org.junit.Assert
import org.junit.Test

import static org.mockito.Matchers.*
import static org.mockito.Mockito.*
import static test.Creaciones.*

public class PruebasDeEnvioDeNotificacionesMedianteObserver 
{
	@Test
	def public void CuandoHagoAmigosADosJugadoresAmbosSeTienenDeAmigos()
	//este test en realidad no necesariamente va acá, pero es parte de lo necesario para probar las notificaciones
	//siendo estrictos debería ir en otra clase PruebasDeAmistad o algo así, pero como no hay caso de uso de eso... no sé, lo dejo acá?
	{
		//setup
		var	jugadorJuan = new Jugador("Juan", 18, new InscripcionEstandar());	//ahora recordemos que no existen los jugadores sin un tipo de inscripción asignada
		var jugadorPedro = new Jugador("Pedro", 20, new InscripcionEstandar());
		
		//accion
		jugadorJuan.hacerseAmigoDe(jugadorPedro);
		
		//verificacion
		Assert.assertTrue(jugadorJuan.tieneAlAmigo(jugadorPedro));
		Assert.assertTrue(jugadorPedro.tieneAlAmigo(jugadorJuan));
	}
	
	
	
	@Test
	def public void CuandoUnPartidoEsConfirmadoElAdministradorEsNotificado()
	{
		var partido = crearPartidoCon9Estandar();
		val mockedDistribuidor = mock(typeof(InterfazDistribuidorDeMails))
		partido.distribuidor = mockedDistribuidor
		
		//esto es medio trucho porque primero aprovecho el método que tengo para armar un partido con 9 estándar,  después le meto los observadores y el distribuidor, y finalmente agrego al último a ver si se manda el mail
		//la posta sería tener un método "poblarPartidoCon9Estandar()" que puede tranquilamente ser llamado por crearPartidoCon9Estandar()
		//será cuestión de refinarlo cuando haya tiempo
		
		
		//Se agregan los observers
		partido.agregarObsever(new NotificarAdminObserver)
		partido.agregarObsever(new NotificarAmigosObserver)
		
		//JUGADORES
		var p10 = new Jugador("Lucas",20, new InscripcionEstandar());
		
		//Inscripciones
		p10.inscribirse(partido);
		
		verify(mockedDistribuidor, times(1)).enviarMail(eq("admin@admin.com"),eq("Partido Confirmado"),any(typeof(String)))
		//cambié esto para que verifique que el avisado es el admin
		//sin embargo, quedó hardcodeado!
	}
	
	@Test
	def public void CuandoUnPartidoDejaDeTener10ConfirmadosElAdministradorEsNotificado()
	{
		//FIXME copypasta
		var partido = crearPartidoCon9Estandar();
		val mockedDistribuidor = mock(typeof(InterfazDistribuidorDeMails))
		partido.distribuidor = mockedDistribuidor
		
		//Se agregan los observers
		partido.agregarObsever(new NotificarAdminObserver)
		partido.agregarObsever(new NotificarAmigosObserver)
		
		//JUGADORES
		var p10 = new Jugador("Lucas",20, new InscripcionEstandar());
		
		//Inscripciones
		p10.inscribirse(partido);
		
		//Hasta acá llega el setup
		
		p10.bajarse(partido); //esta es la acción
		
		//y acá viene el assert		
		verify(mockedDistribuidor, times(1)).enviarMail(eq("admin@admin.com"),eq("Partido Indefinido"),any(typeof(String)));
		
	}
	
	@Test
	def public void CuandoUnJugadorSeBajaNoSeMandaMailsAMenosQueDejeDeEstarConfirmadoElPartido()
	{
		var partido = new Partido (new Date)
		val mockedDistribuidor = mock(typeof(InterfazDistribuidorDeMails))
		partido.distribuidor = mockedDistribuidor
		
		//Se agregan los observers
		partido.agregarObsever(new NotificarAdminObserver)
		partido.agregarObsever(new NotificarAmigosObserver)
		
		//JUGADORES
		var p1 = new Jugador("Pepe",20, new InscripcionEstandar());
		p1.inscribirse(partido);
		
		p1.bajarse(partido);
		
		verify(mockedDistribuidor, times(0)).enviarMail(eq("admin@admin.com"),eq("Partido Indefinido"),any(typeof(String)));
		
		
	}
	
	@Test
	def public void CuandoUnJugadorSeInscribeSusAmigosSonNotificados()
	{
		//setup
		var partido = new Partido (new Date);
		var jugadorPepe = new Jugador("Pepe",20, new InscripcionEstandar());
		//var partPepe = new Participante(new Jugador("Pepe",20));
		//partPepe.setModalidad(new InscripcionEstandar(partPepe));
		var	jugadorLuis = new Jugador("Luis", 18, new InscripcionEstandar());
		var jugadorPedro = new Jugador("Pedro", 20, new InscripcionEstandar());
		jugadorPepe.hacerseAmigoDe(jugadorLuis);
		jugadorPepe.hacerseAmigoDe(jugadorPedro);
		
		jugadorLuis.email="luisito@gmail.com";
		jugadorPedro.email="pedrito@gmail.com";
		
		partido.agregarObsever(new NotificarAmigosObserver);
		
		val mockedDistribuidor = mock(typeof(InterfazDistribuidorDeMails));
		partido.distribuidor = mockedDistribuidor;
		
		
		//accion
		jugadorPepe.inscribirse(partido);
		
		//verificacion
		verify(mockedDistribuidor, times(1)).enviarMail(eq("luisito@gmail.com"),eq("Me anote a un partido!"),any(typeof(String)));
		verify(mockedDistribuidor, times(1)).enviarMail(eq("pedrito@gmail.com"),eq("Me anote a un partido!"),any(typeof(String)));
		
	}
	
}
