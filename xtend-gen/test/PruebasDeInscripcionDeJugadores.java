package test;

import domain.InscripcionEstandar;
import domain.Jugador;
import domain.Participante;
import domain.Partido;
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
  }
  
  @Test
  public void cuandoUnJugadorDesplazaAOtroElDesplazadorQuedaInscripto() {
  }
  
  @Test
  public void cuandoUnJugadorDesplazaAOtroElDesplazadoNoQuedaInscripto() {
  }
  
  @Test
  public void noSePuedeAnotarNadieAUnPartidoCon10Estandar() {
  }
  
  @Test
  public void enUnaListaCon9EstandarY1SolidarioPuedeEntrarOtroEstandarDesplazandoAlSolidario() {
  }
  
  @Test
  public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoEstandarDesplazaAlCondicional() {
  }
  
  @Test
  public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoSolidarioDesplazaAlCondicional() {
  }
  
  @Test
  public void noSePuedeAnotarAlMismoJugadorDosVeces() {
  }
  
  @Test
  public void alHaberDosSolidariosParaDesplazarSeDesplazaAlQueSeAnotoPrimero() {
  }
}
