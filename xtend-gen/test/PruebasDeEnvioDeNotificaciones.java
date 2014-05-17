package test;

import domain.InscripcionEstandar;
import domain.Jugador;
import domain.NotificarAmigosObserver;
import domain.Participante;
import domain.Partido;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class PruebasDeEnvioDeNotificaciones {
  @Test
  public void CuandoHagoAmigosADosJugadoresAmbosSeTienenDeAmigos() {
    Jugador jugadorJuan = new Jugador("Juan", 18);
    Jugador jugadorPedro = new Jugador("Pedro", 20);
    jugadorJuan.hacerseAmigoDe(jugadorPedro);
    boolean _tieneAlAmigo = jugadorJuan.tieneAlAmigo(jugadorPedro);
    Assert.assertTrue(_tieneAlAmigo);
    boolean _tieneAlAmigo_1 = jugadorPedro.tieneAlAmigo(jugadorJuan);
    Assert.assertTrue(_tieneAlAmigo_1);
  }
  
  @Test
  public void CuandoUnPartidoEsConfirmadoElAdministradorEsNotificado() {
    Assert.fail();
  }
  
  @Test
  public void CuandoUnPartidoDejaDeTener10ConfirmadosElAdministradorEsNotificado() {
    Assert.fail();
  }
  
  @Test
  public void CuandoUnJugadorSeInscribeSusAmigosSonNotificados() {
    Date _date = new Date();
    Partido partido = new Partido(_date);
    Jugador _jugador = new Jugador("Pepe", 20);
    Participante partPepe = new Participante(_jugador);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(partPepe);
    partPepe.setModalidad(_inscripcionEstandar);
    Jugador jugadorLuis = new Jugador("Luis", 18);
    Jugador jugadorPedro = new Jugador("Pedro", 20);
    Jugador _jugador_1 = partPepe.getJugador();
    _jugador_1.hacerseAmigoDe(jugadorLuis);
    Jugador _jugador_2 = partPepe.getJugador();
    _jugador_2.hacerseAmigoDe(jugadorPedro);
    NotificarAmigosObserver notifAmigos = new NotificarAmigosObserver();
    partido.agregarObsever(notifAmigos);
    partPepe.inscribirse(partido);
    partido.notificarJugadorConfirmadoAObservers();
    boolean _amigosNotificados = partido.amigosNotificados();
    Assert.assertTrue(_amigosNotificados);
  }
}
