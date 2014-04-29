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
    Partido _partido = new Partido("25/06/2014", "08:30");
    Partido partido = _partido;
    Jugador _jugador = new Jugador("Juancito");
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante = new Participante(_jugador, _inscripcionEstandar);
    Participante saliente = _participante;
    Jugador _jugador_1 = new Jugador("Jorgito");
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Participante _participante_1 = new Participante(_jugador_1, _inscripcionEstandar_1);
    Participante entrante = _participante_1;
    partido.reemplazar(saliente, entrante);
    Jugador _jugador_2 = entrante.getJugador();
    boolean _estaInscripto = partido.estaInscripto(_jugador_2);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test
  public void cuandoUnJugadorDesplazaAOtroElDesplazadoNoQuedaInscripto() {
    Partido _partido = new Partido("25/06/2014", "08:30");
    Partido partido = _partido;
    Jugador _jugador = new Jugador("Juancito");
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante = new Participante(_jugador, _inscripcionEstandar);
    Participante saliente = _participante;
    Jugador _jugador_1 = new Jugador("Jorgito");
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Participante _participante_1 = new Participante(_jugador_1, _inscripcionEstandar_1);
    Participante entrante = _participante_1;
    partido.reemplazar(saliente, entrante);
    Jugador _jugador_2 = saliente.getJugador();
    boolean _estaInscripto = partido.estaInscripto(_jugador_2);
    Assert.assertFalse(_estaInscripto);
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
    Jugador _jugador = new Jugador("Manuelito");
    Jugador jugador = _jugador;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante = new Participante(jugador, _inscripcionEstandar);
    Participante participante = _participante;
    Partido _partido = new Partido("25/06/2014", "08:30");
    Partido partido = _partido;
    participante.inscribirse(partido);
    participante.inscribirse(partido);
    int _obtenerCantidadDeInscriptos = partido.obtenerCantidadDeInscriptos();
    boolean _equals = (_obtenerCantidadDeInscriptos == 1);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void alHaberDosSolidariosParaDesplazarSeDesplazaAlQueSeAnotoPrimero() {
    Assert.fail("Not implemented");
  }
}
