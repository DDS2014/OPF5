package test;

import domain.InscripcionEstandar;
import domain.Jugador;
import domain.Participante;
import domain.Partido;
import junit.framework.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class PruebasDeInscripcionDeJugadores {
  @Test
  public void inscriboUnJugadorAUnPartidoYQuedaInscripto() {
    Partido _partido = new Partido("25/05/2014", "16:00");
    Partido partido = _partido;
    Jugador _jugador = new Jugador("Pedrito");
    Jugador jugador = _jugador;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante = new Participante(jugador, _inscripcionEstandar);
    Participante participante = _participante;
    participante.inscribirse(partido);
    boolean _estaInscripto = partido.estaInscripto(jugador);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test
  public void cuandoUnJugadorDesplazaAOtroElDesplazadorQuedaInscripto() {
    Assert.fail("Not implemented");
  }
  
  @Test
  public void cuandoUnJugadorDesplazaAOtroElDesplazadoNoQuedaInscripto() {
    Assert.fail("Not implemented");
  }
  
  @Test
  public void noSePuedeAnotarNadieAUnPartidoCon10Estandar() {
    Assert.fail("Not implemented");
  }
  
  @Test
  public void enUnaListaCon9EstandarY1SolidarioPuedeEntrarOtroEstandarDesplazandoAlSolidario() {
    Assert.fail("Not implemented");
  }
  
  @Test
  public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoEstandarDesplazaAlCondicional() {
    Assert.fail("Not implemented");
  }
  
  @Test
  public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoSolidarioDesplazaAlCondicional() {
    Assert.fail("Not implemented");
  }
  
  @Test
  public void noSePuedeAnotarAlMismoJugadorDosVeces() {
    Assert.fail("Not implemented");
  }
  
  @Test
  public void alHaberDosSolidariosParaDesplazarSeDesplazaAlQueSeAnotoPrimero() {
    Assert.fail("Not implemented");
  }
}
