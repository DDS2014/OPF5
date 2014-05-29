package test;

import domain.Jugador;
import domain.Partido;
import domain.enviadorDeMails.InterfazDistribuidorDeMails;
import domain.inscripcion.InscripcionEstandar;
import domain.notificaciones.NotificarAdminObserver;
import domain.notificaciones.NotificarAmigosObserver;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import test.Creaciones;

@SuppressWarnings("all")
public class PruebasDeEnvioDeNotificaciones {
  @Test
  public void CuandoHagoAmigosADosJugadoresAmbosSeTienenDeAmigos() {
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador _jugador = new Jugador("Juan", 18, _inscripcionEstandar);
    Jugador jugadorJuan = _jugador;
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Jugador _jugador_1 = new Jugador("Pedro", 20, _inscripcionEstandar_1);
    Jugador jugadorPedro = _jugador_1;
    jugadorJuan.hacerseAmigoDe(jugadorPedro);
    boolean _tieneAlAmigo = jugadorJuan.tieneAlAmigo(jugadorPedro);
    Assert.assertTrue(_tieneAlAmigo);
    boolean _tieneAlAmigo_1 = jugadorPedro.tieneAlAmigo(jugadorJuan);
    Assert.assertTrue(_tieneAlAmigo_1);
  }
  
  @Test
  public void CuandoUnPartidoEsConfirmadoElAdministradorEsNotificado() {
    try {
      Partido partido = Creaciones.crearPartidoCon9Estandar();
      final InterfazDistribuidorDeMails mockedDistribuidor = Mockito.<InterfazDistribuidorDeMails>mock(InterfazDistribuidorDeMails.class);
      partido.setDistribuidor(mockedDistribuidor);
      NotificarAdminObserver _notificarAdminObserver = new NotificarAdminObserver();
      partido.agregarObsever(_notificarAdminObserver);
      NotificarAmigosObserver _notificarAmigosObserver = new NotificarAmigosObserver();
      partido.agregarObsever(_notificarAmigosObserver);
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Lucas", 20, _inscripcionEstandar);
      Jugador p10 = _jugador;
      p10.inscribirse(partido);
      VerificationMode _times = Mockito.times(1);
      InterfazDistribuidorDeMails _verify = Mockito.<InterfazDistribuidorDeMails>verify(mockedDistribuidor, _times);
      String _eq = Matchers.<String>eq("admin@admin.com");
      String _eq_1 = Matchers.<String>eq("Partido Confirmado");
      String _any = Matchers.<String>any(String.class);
      _verify.enviarMail(_eq, _eq_1, _any);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void CuandoUnPartidoDejaDeTener10ConfirmadosElAdministradorEsNotificado() {
    try {
      Partido partido = Creaciones.crearPartidoCon9Estandar();
      final InterfazDistribuidorDeMails mockedDistribuidor = Mockito.<InterfazDistribuidorDeMails>mock(InterfazDistribuidorDeMails.class);
      partido.setDistribuidor(mockedDistribuidor);
      NotificarAdminObserver _notificarAdminObserver = new NotificarAdminObserver();
      partido.agregarObsever(_notificarAdminObserver);
      NotificarAmigosObserver _notificarAmigosObserver = new NotificarAmigosObserver();
      partido.agregarObsever(_notificarAmigosObserver);
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Lucas", 20, _inscripcionEstandar);
      Jugador p10 = _jugador;
      p10.inscribirse(partido);
      p10.bajarse(partido);
      VerificationMode _times = Mockito.times(1);
      InterfazDistribuidorDeMails _verify = Mockito.<InterfazDistribuidorDeMails>verify(mockedDistribuidor, _times);
      String _eq = Matchers.<String>eq("admin@admin.com");
      String _eq_1 = Matchers.<String>eq("Partido Indefinido");
      String _any = Matchers.<String>any(String.class);
      _verify.enviarMail(_eq, _eq_1, _any);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void CuandoUnJugadorSeBajaNoSeMandaMailsAMenosQueDejeDeEstarConfirmadoElPartido() {
    try {
      Date _date = new Date();
      Partido _partido = new Partido(_date);
      Partido partido = _partido;
      final InterfazDistribuidorDeMails mockedDistribuidor = Mockito.<InterfazDistribuidorDeMails>mock(InterfazDistribuidorDeMails.class);
      partido.setDistribuidor(mockedDistribuidor);
      NotificarAdminObserver _notificarAdminObserver = new NotificarAdminObserver();
      partido.agregarObsever(_notificarAdminObserver);
      NotificarAmigosObserver _notificarAmigosObserver = new NotificarAmigosObserver();
      partido.agregarObsever(_notificarAmigosObserver);
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Pepe", 20, _inscripcionEstandar);
      Jugador p1 = _jugador;
      p1.inscribirse(partido);
      p1.bajarse(partido);
      VerificationMode _times = Mockito.times(0);
      InterfazDistribuidorDeMails _verify = Mockito.<InterfazDistribuidorDeMails>verify(mockedDistribuidor, _times);
      String _eq = Matchers.<String>eq("admin@admin.com");
      String _eq_1 = Matchers.<String>eq("Partido Indefinido");
      String _any = Matchers.<String>any(String.class);
      _verify.enviarMail(_eq, _eq_1, _any);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void CuandoUnJugadorSeInscribeSusAmigosSonNotificados() {
    try {
      Date _date = new Date();
      Partido _partido = new Partido(_date);
      Partido partido = _partido;
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Pepe", 20, _inscripcionEstandar);
      Jugador jugadorPepe = _jugador;
      InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
      Jugador _jugador_1 = new Jugador("Luis", 18, _inscripcionEstandar_1);
      Jugador jugadorLuis = _jugador_1;
      InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar();
      Jugador _jugador_2 = new Jugador("Pedro", 20, _inscripcionEstandar_2);
      Jugador jugadorPedro = _jugador_2;
      jugadorPepe.hacerseAmigoDe(jugadorLuis);
      jugadorPepe.hacerseAmigoDe(jugadorPedro);
      jugadorLuis.setEmail("luisito@gmail.com");
      jugadorPedro.setEmail("pedrito@gmail.com");
      NotificarAmigosObserver _notificarAmigosObserver = new NotificarAmigosObserver();
      partido.agregarObsever(_notificarAmigosObserver);
      final InterfazDistribuidorDeMails mockedDistribuidor = Mockito.<InterfazDistribuidorDeMails>mock(InterfazDistribuidorDeMails.class);
      partido.setDistribuidor(mockedDistribuidor);
      jugadorPepe.inscribirse(partido);
      VerificationMode _times = Mockito.times(1);
      InterfazDistribuidorDeMails _verify = Mockito.<InterfazDistribuidorDeMails>verify(mockedDistribuidor, _times);
      String _eq = Matchers.<String>eq("luisito@gmail.com");
      String _eq_1 = Matchers.<String>eq("Me anote a un partido!");
      String _any = Matchers.<String>any(String.class);
      _verify.enviarMail(_eq, _eq_1, _any);
      VerificationMode _times_1 = Mockito.times(1);
      InterfazDistribuidorDeMails _verify_1 = Mockito.<InterfazDistribuidorDeMails>verify(mockedDistribuidor, _times_1);
      String _eq_2 = Matchers.<String>eq("pedrito@gmail.com");
      String _eq_3 = Matchers.<String>eq("Me anote a un partido!");
      String _any_1 = Matchers.<String>any(String.class);
      _verify_1.enviarMail(_eq_2, _eq_3, _any_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
