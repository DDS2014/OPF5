package test;

import domain.Jugador;
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
    Assert.fail();
  }
  
  @Test
  public void CuandoUnPartidoDejaDeTener10ConfirmadosElAdministradorEsNotificado() {
    Assert.fail();
  }
  
  @Test
  public void CuandoUnJugadorSeInscribeSusAmigosSonNotificados() {
    Assert.fail();
  }
}
