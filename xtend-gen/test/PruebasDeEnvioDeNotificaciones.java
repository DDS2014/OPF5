package test;

import domain.Jugador;
import domain.Participante;
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

@SuppressWarnings("all")
public class PruebasDeEnvioDeNotificaciones {
  @Test
  public void CuandoHagoAmigosADosJugadoresAmbosSeTienenDeAmigos() {
    Jugador _jugador = new Jugador("Juan", 18);
    Jugador jugadorJuan = _jugador;
    Jugador _jugador_1 = new Jugador("Pedro", 20);
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
      Date _date = new Date();
      Partido _partido = new Partido(_date);
      Partido partido = _partido;
      final InterfazDistribuidorDeMails mockedDistribuidor = Mockito.<InterfazDistribuidorDeMails>mock(InterfazDistribuidorDeMails.class);
      partido.setDistribuidor(mockedDistribuidor);
      NotificarAdminObserver _notificarAdminObserver = new NotificarAdminObserver();
      partido.agregarObsever(_notificarAdminObserver);
      NotificarAmigosObserver _notificarAmigosObserver = new NotificarAmigosObserver();
      partido.agregarObsever(_notificarAmigosObserver);
      Jugador _jugador = new Jugador("Pepe", 20);
      Participante _participante = new Participante(_jugador);
      Participante p1 = _participante;
      Jugador _jugador_1 = new Jugador("Luis", 35);
      Participante _participante_1 = new Participante(_jugador_1);
      Participante p2 = _participante_1;
      Jugador _jugador_2 = new Jugador("Juan", 27);
      Participante _participante_2 = new Participante(_jugador_2);
      Participante p3 = _participante_2;
      Jugador _jugador_3 = new Jugador("Alberto", 20);
      Participante _participante_3 = new Participante(_jugador_3);
      Participante p4 = _participante_3;
      Jugador _jugador_4 = new Jugador("Fabio", 20);
      Participante _participante_4 = new Participante(_jugador_4);
      Participante p5 = _participante_4;
      Jugador _jugador_5 = new Jugador("Alejo", 26);
      Participante _participante_5 = new Participante(_jugador_5);
      Participante p6 = _participante_5;
      Jugador _jugador_6 = new Jugador("Casio", 29);
      Participante _participante_6 = new Participante(_jugador_6);
      Participante p7 = _participante_6;
      Jugador _jugador_7 = new Jugador("Alan", 30);
      Participante _participante_7 = new Participante(_jugador_7);
      Participante p8 = _participante_7;
      Jugador _jugador_8 = new Jugador("Carlos", 20);
      Participante _participante_8 = new Participante(_jugador_8);
      Participante p9 = _participante_8;
      Jugador _jugador_9 = new Jugador("Lucas", 20);
      Participante _participante_9 = new Participante(_jugador_9);
      Participante p10 = _participante_9;
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(p1);
      partido.inscribir(_inscripcionEstandar);
      InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar(p2);
      partido.inscribir(_inscripcionEstandar_1);
      InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar(p3);
      partido.inscribir(_inscripcionEstandar_2);
      InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar(p4);
      partido.inscribir(_inscripcionEstandar_3);
      InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar(p5);
      partido.inscribir(_inscripcionEstandar_4);
      InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar(p6);
      partido.inscribir(_inscripcionEstandar_5);
      InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar(p7);
      partido.inscribir(_inscripcionEstandar_6);
      InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar(p8);
      partido.inscribir(_inscripcionEstandar_7);
      InscripcionEstandar _inscripcionEstandar_8 = new InscripcionEstandar(p9);
      partido.inscribir(_inscripcionEstandar_8);
      InscripcionEstandar _inscripcionEstandar_9 = new InscripcionEstandar(p10);
      partido.inscribir(_inscripcionEstandar_9);
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
      Date _date = new Date();
      Partido _partido = new Partido(_date);
      Partido partido = _partido;
      final InterfazDistribuidorDeMails mockedDistribuidor = Mockito.<InterfazDistribuidorDeMails>mock(InterfazDistribuidorDeMails.class);
      partido.setDistribuidor(mockedDistribuidor);
      NotificarAdminObserver _notificarAdminObserver = new NotificarAdminObserver();
      partido.agregarObsever(_notificarAdminObserver);
      NotificarAmigosObserver _notificarAmigosObserver = new NotificarAmigosObserver();
      partido.agregarObsever(_notificarAmigosObserver);
      Jugador _jugador = new Jugador("Pepe", 20);
      Participante _participante = new Participante(_jugador);
      Participante p1 = _participante;
      Jugador _jugador_1 = new Jugador("Luis", 35);
      Participante _participante_1 = new Participante(_jugador_1);
      Participante p2 = _participante_1;
      Jugador _jugador_2 = new Jugador("Juan", 27);
      Participante _participante_2 = new Participante(_jugador_2);
      Participante p3 = _participante_2;
      Jugador _jugador_3 = new Jugador("Alberto", 20);
      Participante _participante_3 = new Participante(_jugador_3);
      Participante p4 = _participante_3;
      Jugador _jugador_4 = new Jugador("Fabio", 20);
      Participante _participante_4 = new Participante(_jugador_4);
      Participante p5 = _participante_4;
      Jugador _jugador_5 = new Jugador("Alejo", 26);
      Participante _participante_5 = new Participante(_jugador_5);
      Participante p6 = _participante_5;
      Jugador _jugador_6 = new Jugador("Casio", 29);
      Participante _participante_6 = new Participante(_jugador_6);
      Participante p7 = _participante_6;
      Jugador _jugador_7 = new Jugador("Alan", 30);
      Participante _participante_7 = new Participante(_jugador_7);
      Participante p8 = _participante_7;
      Jugador _jugador_8 = new Jugador("Carlos", 20);
      Participante _participante_8 = new Participante(_jugador_8);
      Participante p9 = _participante_8;
      Jugador _jugador_9 = new Jugador("Lucas", 20);
      Participante _participante_9 = new Participante(_jugador_9);
      Participante p10 = _participante_9;
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(p1);
      partido.inscribir(_inscripcionEstandar);
      InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar(p2);
      partido.inscribir(_inscripcionEstandar_1);
      InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar(p3);
      partido.inscribir(_inscripcionEstandar_2);
      InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar(p4);
      partido.inscribir(_inscripcionEstandar_3);
      InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar(p5);
      partido.inscribir(_inscripcionEstandar_4);
      InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar(p6);
      partido.inscribir(_inscripcionEstandar_5);
      InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar(p7);
      partido.inscribir(_inscripcionEstandar_6);
      InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar(p8);
      partido.inscribir(_inscripcionEstandar_7);
      InscripcionEstandar _inscripcionEstandar_8 = new InscripcionEstandar(p9);
      partido.inscribir(_inscripcionEstandar_8);
      InscripcionEstandar _inscripcionEstandar_9 = new InscripcionEstandar(p10);
      partido.inscribir(_inscripcionEstandar_9);
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
      Jugador _jugador = new Jugador("Pepe", 20);
      Participante _participante = new Participante(_jugador);
      Participante p1 = _participante;
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(p1);
      partido.inscribir(_inscripcionEstandar);
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
      Jugador _jugador = new Jugador("Pepe", 20);
      Jugador jugadorPepe = _jugador;
      Jugador _jugador_1 = new Jugador("Luis", 18);
      Jugador jugadorLuis = _jugador_1;
      Jugador _jugador_2 = new Jugador("Pedro", 20);
      Jugador jugadorPedro = _jugador_2;
      jugadorPepe.hacerseAmigoDe(jugadorLuis);
      jugadorPepe.hacerseAmigoDe(jugadorPedro);
      jugadorLuis.setEmail("luisito@gmail.com");
      jugadorPedro.setEmail("pedrito@gmail.com");
      NotificarAmigosObserver _notificarAmigosObserver = new NotificarAmigosObserver();
      partido.agregarObsever(_notificarAmigosObserver);
      final InterfazDistribuidorDeMails mockedDistribuidor = Mockito.<InterfazDistribuidorDeMails>mock(InterfazDistribuidorDeMails.class);
      partido.setDistribuidor(mockedDistribuidor);
      Participante _participante = new Participante(jugadorPepe);
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(_participante);
      partido.inscribir(_inscripcionEstandar);
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
