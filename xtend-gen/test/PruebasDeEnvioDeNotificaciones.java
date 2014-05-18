package test;

import domain.Jugador;
import domain.Partido;
import domain.notificaciones.NotificarAmigosObserver;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

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
    throw new Error("Unresolved compilation problems:"
      + "\nDistribuidorStub cannot be resolved to a type."
      + "\nThe method enviarMail is undefined for the type PruebasDeEnvioDeNotificaciones"
      + "\nType mismatch: cannot convert from void to InterfazDistribuidorDeMails");
  }
  
  @Test
  public void CuandoUnPartidoDejaDeTener10ConfirmadosElAdministradorEsNotificado() {
    Assert.fail();
  }
  
  @Test
  public void CuandoUnJugadorSeInscribeSusAmigosSonNotificados() {
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
    NotificarAmigosObserver _notificarAmigosObserver = new NotificarAmigosObserver();
    partido.agregarObsever(_notificarAmigosObserver);
    Assert.fail();
  }
}
