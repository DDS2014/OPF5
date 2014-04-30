package test;

import domain.ImposibleAnotarseException;
import domain.InscripcionCondicional;
import domain.InscripcionEstandar;
import domain.InscripcionSolidaria;
import domain.Jugador;
import domain.Participante;
import domain.Partido;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class PruebasDeInscripcionDeJugadores {
  @Test
  public void inscriboUnJugadorAUnPartidoYQuedaInscripto() {
    Partido partido = new Partido("25/05/2014", "16:00");
    Jugador jugador = new Jugador("Pedrito");
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante participante = new Participante(jugador, _inscripcionEstandar);
    participante.inscribirse(partido);
    boolean _estaInscripto = partido.estaInscripto(jugador);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test
  public void cuandoUnJugadorDesplazaAOtroElDesplazadorQuedaInscriptoYElDesplazadoSale() {
    Partido partido = new Partido("25/06/2014", "08:30");
    Jugador _jugador = new Jugador("Juancito");
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante saliente = new Participante(_jugador, _inscripcionEstandar);
    Jugador _jugador_1 = new Jugador("Jorgito");
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Participante entrante = new Participante(_jugador_1, _inscripcionEstandar_1);
    partido.reemplazar(saliente, entrante);
    Jugador _jugador_2 = entrante.getJugador();
    boolean _estaInscripto = partido.estaInscripto(_jugador_2);
    Assert.assertTrue(_estaInscripto);
    Jugador _jugador_3 = saliente.getJugador();
    boolean _estaInscripto_1 = partido.estaInscripto(_jugador_3);
    Assert.assertFalse(_estaInscripto_1);
  }
  
  @Test
  public void noSePuedeAnotarNadieAUnPartidoCon10Estandar() {
    Partido partidoEstandar = new Partido("25/06/2014", "08:30");
    Jugador _jugador = new Jugador("Pepe");
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante part1 = new Participante(_jugador, _inscripcionEstandar);
    Jugador _jugador_1 = new Jugador("Luis");
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Participante part2 = new Participante(_jugador_1, _inscripcionEstandar_1);
    Jugador _jugador_2 = new Jugador("Juan");
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar();
    Participante part3 = new Participante(_jugador_2, _inscripcionEstandar_2);
    Jugador _jugador_3 = new Jugador("Alberto");
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar();
    Participante part4 = new Participante(_jugador_3, _inscripcionEstandar_3);
    Jugador _jugador_4 = new Jugador("Fabio");
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar();
    Participante part5 = new Participante(_jugador_4, _inscripcionEstandar_4);
    Jugador _jugador_5 = new Jugador("Alejo");
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar();
    Participante part6 = new Participante(_jugador_5, _inscripcionEstandar_5);
    Jugador _jugador_6 = new Jugador("Casio");
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar();
    Participante part7 = new Participante(_jugador_6, _inscripcionEstandar_6);
    Jugador _jugador_7 = new Jugador("Alan");
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar();
    Participante part8 = new Participante(_jugador_7, _inscripcionEstandar_7);
    Jugador _jugador_8 = new Jugador("Carlos");
    InscripcionEstandar _inscripcionEstandar_8 = new InscripcionEstandar();
    Participante part9 = new Participante(_jugador_8, _inscripcionEstandar_8);
    Jugador _jugador_9 = new Jugador("Lucas");
    InscripcionEstandar _inscripcionEstandar_9 = new InscripcionEstandar();
    Participante part10 = new Participante(_jugador_9, _inscripcionEstandar_9);
    part1.inscribirse(partidoEstandar);
    part2.inscribirse(partidoEstandar);
    part3.inscribirse(partidoEstandar);
    part4.inscribirse(partidoEstandar);
    part5.inscribirse(partidoEstandar);
    part6.inscribirse(partidoEstandar);
    part7.inscribirse(partidoEstandar);
    part8.inscribirse(partidoEstandar);
    part9.inscribirse(partidoEstandar);
    part10.inscribirse(partidoEstandar);
    Jugador _jugador_10 = new Jugador("Jorgito");
    InscripcionEstandar _inscripcionEstandar_10 = new InscripcionEstandar();
    Participante colgado = new Participante(_jugador_10, _inscripcionEstandar_10);
    try {
      colgado.inscribirse(partidoEstandar);
      Assert.fail("No falló la inscripción aunque el partido estaba lleno, algo anda mal");
    } catch (final Throwable _t) {
      if (_t instanceof ImposibleAnotarseException) {
        final ImposibleAnotarseException excepcion = (ImposibleAnotarseException)_t;
        Jugador _jugador_11 = colgado.getJugador();
        boolean _estaInscripto = partidoEstandar.estaInscripto(_jugador_11);
        Assert.assertFalse(_estaInscripto);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void enUnaListaCon9EstandarY1SolidarioPuedeEntrarOtroEstandarDesplazandoAlSolidario() {
    Partido partido = new Partido("25/06/2014", "08:30");
    Jugador _jugador = new Jugador("Pepe");
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante part1 = new Participante(_jugador, _inscripcionEstandar);
    Jugador _jugador_1 = new Jugador("Luis");
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Participante part2 = new Participante(_jugador_1, _inscripcionEstandar_1);
    Jugador _jugador_2 = new Jugador("Juan");
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar();
    Participante part3 = new Participante(_jugador_2, _inscripcionEstandar_2);
    Jugador _jugador_3 = new Jugador("Alberto");
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar();
    Participante part4 = new Participante(_jugador_3, _inscripcionEstandar_3);
    Jugador _jugador_4 = new Jugador("Fabio");
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar();
    Participante part5 = new Participante(_jugador_4, _inscripcionEstandar_4);
    Jugador _jugador_5 = new Jugador("Alejo");
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar();
    Participante part6 = new Participante(_jugador_5, _inscripcionEstandar_5);
    Jugador _jugador_6 = new Jugador("Casio");
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar();
    Participante part7 = new Participante(_jugador_6, _inscripcionEstandar_6);
    Jugador _jugador_7 = new Jugador("Alan");
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar();
    Participante part8 = new Participante(_jugador_7, _inscripcionEstandar_7);
    Jugador _jugador_8 = new Jugador("Carlos");
    InscripcionEstandar _inscripcionEstandar_8 = new InscripcionEstandar();
    Participante part9 = new Participante(_jugador_8, _inscripcionEstandar_8);
    Jugador _jugador_9 = new Jugador("Marquitos");
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Participante jugadorSolidario = new Participante(_jugador_9, _inscripcionSolidaria);
    part1.inscribirse(partido);
    part2.inscribirse(partido);
    part3.inscribirse(partido);
    part4.inscribirse(partido);
    part5.inscribirse(partido);
    part6.inscribirse(partido);
    part7.inscribirse(partido);
    part8.inscribirse(partido);
    part9.inscribirse(partido);
    jugadorSolidario.inscribirse(partido);
    Jugador _jugador_10 = new Jugador("Miguelito");
    InscripcionEstandar _inscripcionEstandar_9 = new InscripcionEstandar();
    Participante jugadorNuevo = new Participante(_jugador_10, _inscripcionEstandar_9);
    jugadorNuevo.inscribirse(partido);
    Jugador _jugador_11 = jugadorNuevo.getJugador();
    boolean _estaInscripto = partido.estaInscripto(_jugador_11);
    Assert.assertTrue(_estaInscripto);
    Jugador _jugador_12 = jugadorSolidario.getJugador();
    boolean _estaInscripto_1 = partido.estaInscripto(_jugador_12);
    Assert.assertFalse(_estaInscripto_1);
  }
  
  @Test
  public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoEstandarDesplazaAlCondicional() {
    Partido partido = new Partido("25/06/2014", "08:30");
    Jugador _jugador = new Jugador("Pepe");
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante part1 = new Participante(_jugador, _inscripcionEstandar);
    Jugador _jugador_1 = new Jugador("Luis");
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Participante part2 = new Participante(_jugador_1, _inscripcionEstandar_1);
    Jugador _jugador_2 = new Jugador("Juan");
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar();
    Participante part3 = new Participante(_jugador_2, _inscripcionEstandar_2);
    Jugador _jugador_3 = new Jugador("Alberto");
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar();
    Participante part4 = new Participante(_jugador_3, _inscripcionEstandar_3);
    Jugador _jugador_4 = new Jugador("Fabio");
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar();
    Participante part5 = new Participante(_jugador_4, _inscripcionEstandar_4);
    Jugador _jugador_5 = new Jugador("Alejo");
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar();
    Participante part6 = new Participante(_jugador_5, _inscripcionEstandar_5);
    Jugador _jugador_6 = new Jugador("Casio");
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar();
    Participante part7 = new Participante(_jugador_6, _inscripcionEstandar_6);
    Jugador _jugador_7 = new Jugador("Alan");
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar();
    Participante part8 = new Participante(_jugador_7, _inscripcionEstandar_7);
    Jugador _jugador_8 = new Jugador("Josecito");
    InscripcionCondicional _inscripcionCondicional = new InscripcionCondicional();
    Participante jugadorCondicional = new Participante(_jugador_8, _inscripcionCondicional);
    Jugador _jugador_9 = new Jugador("Marquitos");
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Participante jugadorSolidario = new Participante(_jugador_9, _inscripcionSolidaria);
    part1.inscribirse(partido);
    part2.inscribirse(partido);
    part3.inscribirse(partido);
    part4.inscribirse(partido);
    part5.inscribirse(partido);
    part6.inscribirse(partido);
    part7.inscribirse(partido);
    part8.inscribirse(partido);
    jugadorSolidario.inscribirse(partido);
    jugadorCondicional.inscribirse(partido);
    Jugador _jugador_10 = new Jugador("Pablito");
    InscripcionEstandar _inscripcionEstandar_8 = new InscripcionEstandar();
    Participante jugadorNuevo = new Participante(_jugador_10, _inscripcionEstandar_8);
    jugadorNuevo.inscribirse(partido);
    Jugador _jugador_11 = jugadorNuevo.getJugador();
    boolean _estaInscripto = partido.estaInscripto(_jugador_11);
    Assert.assertTrue(_estaInscripto);
    Jugador _jugador_12 = jugadorSolidario.getJugador();
    boolean _estaInscripto_1 = partido.estaInscripto(_jugador_12);
    Assert.assertTrue(_estaInscripto_1);
    Jugador _jugador_13 = jugadorCondicional.getJugador();
    boolean _estaInscripto_2 = partido.estaInscripto(_jugador_13);
    Assert.assertFalse(_estaInscripto_2);
  }
  
  @Test
  public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoSolidarioDesplazaAlCondicional() {
    Partido partido = new Partido("25/06/2014", "08:30");
    Jugador _jugador = new Jugador("Ricardito");
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Participante jugadorSolidario = new Participante(_jugador, _inscripcionSolidaria);
    Jugador _jugador_1 = new Jugador("Josecito");
    InscripcionCondicional _inscripcionCondicional = new InscripcionCondicional();
    Participante jugadorCondicional = new Participante(_jugador_1, _inscripcionCondicional);
    Jugador _jugador_2 = new Jugador("Juan");
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante part3 = new Participante(_jugador_2, _inscripcionEstandar);
    Jugador _jugador_3 = new Jugador("Alberto");
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Participante part4 = new Participante(_jugador_3, _inscripcionEstandar_1);
    Jugador _jugador_4 = new Jugador("Fabio");
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar();
    Participante part5 = new Participante(_jugador_4, _inscripcionEstandar_2);
    Jugador _jugador_5 = new Jugador("Alejo");
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar();
    Participante part6 = new Participante(_jugador_5, _inscripcionEstandar_3);
    Jugador _jugador_6 = new Jugador("Casio");
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar();
    Participante part7 = new Participante(_jugador_6, _inscripcionEstandar_4);
    Jugador _jugador_7 = new Jugador("Alan");
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar();
    Participante part8 = new Participante(_jugador_7, _inscripcionEstandar_5);
    Jugador _jugador_8 = new Jugador("Carlos");
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar();
    Participante part9 = new Participante(_jugador_8, _inscripcionEstandar_6);
    Jugador _jugador_9 = new Jugador("Lucas");
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar();
    Participante part10 = new Participante(_jugador_9, _inscripcionEstandar_7);
    part3.inscribirse(partido);
    part4.inscribirse(partido);
    part5.inscribirse(partido);
    part6.inscribirse(partido);
    part7.inscribirse(partido);
    part8.inscribirse(partido);
    part9.inscribirse(partido);
    part10.inscribirse(partido);
    jugadorSolidario.inscribirse(partido);
    jugadorCondicional.inscribirse(partido);
    Jugador _jugador_10 = new Jugador("Pablito");
    InscripcionSolidaria _inscripcionSolidaria_1 = new InscripcionSolidaria();
    Participante jugadorNuevoSolidario = new Participante(_jugador_10, _inscripcionSolidaria_1);
    jugadorNuevoSolidario.inscribirse(partido);
    Jugador _jugador_11 = jugadorNuevoSolidario.getJugador();
    boolean _estaInscripto = partido.estaInscripto(_jugador_11);
    Assert.assertTrue(_estaInscripto);
    Jugador _jugador_12 = jugadorSolidario.getJugador();
    boolean _estaInscripto_1 = partido.estaInscripto(_jugador_12);
    Assert.assertTrue(_estaInscripto_1);
    Jugador _jugador_13 = jugadorCondicional.getJugador();
    boolean _estaInscripto_2 = partido.estaInscripto(_jugador_13);
    Assert.assertFalse(_estaInscripto_2);
  }
  
  @Test
  public void noSePuedeAnotarAlMismoJugadorDosVeces() {
    Jugador jugador = new Jugador("Manuelito");
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante participante = new Participante(jugador, _inscripcionEstandar);
    Partido partido = new Partido("25/06/2014", "08:30");
    participante.inscribirse(partido);
    participante.inscribirse(partido);
    int _obtenerCantidadDeInscriptos = partido.obtenerCantidadDeInscriptos();
    Assert.assertEquals(1, _obtenerCantidadDeInscriptos);
  }
  
  @Test
  public void alHaberDosSolidariosParaDesplazarSeDesplazaAlQueSeAnotoPrimero() {
    Partido partido = new Partido("25/06/2014", "08:30");
    Jugador _jugador = new Jugador("Danielito");
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Participante primerJugador = new Participante(_jugador, _inscripcionSolidaria);
    Jugador _jugador_1 = new Jugador("Fernandito");
    InscripcionSolidaria _inscripcionSolidaria_1 = new InscripcionSolidaria();
    Participante segundoJugador = new Participante(_jugador_1, _inscripcionSolidaria_1);
    Jugador _jugador_2 = new Jugador("Juan");
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante part3 = new Participante(_jugador_2, _inscripcionEstandar);
    Jugador _jugador_3 = new Jugador("Alberto");
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Participante part4 = new Participante(_jugador_3, _inscripcionEstandar_1);
    Jugador _jugador_4 = new Jugador("Fabio");
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar();
    Participante part5 = new Participante(_jugador_4, _inscripcionEstandar_2);
    Jugador _jugador_5 = new Jugador("Alejo");
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar();
    Participante part6 = new Participante(_jugador_5, _inscripcionEstandar_3);
    Jugador _jugador_6 = new Jugador("Casio");
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar();
    Participante part7 = new Participante(_jugador_6, _inscripcionEstandar_4);
    Jugador _jugador_7 = new Jugador("Alan");
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar();
    Participante part8 = new Participante(_jugador_7, _inscripcionEstandar_5);
    Jugador _jugador_8 = new Jugador("Carlos");
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar();
    Participante part9 = new Participante(_jugador_8, _inscripcionEstandar_6);
    Jugador _jugador_9 = new Jugador("Lucas");
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar();
    Participante part10 = new Participante(_jugador_9, _inscripcionEstandar_7);
    part3.inscribirse(partido);
    part4.inscribirse(partido);
    part5.inscribirse(partido);
    part6.inscribirse(partido);
    part7.inscribirse(partido);
    part8.inscribirse(partido);
    part9.inscribirse(partido);
    part10.inscribirse(partido);
    primerJugador.inscribirse(partido);
    segundoJugador.inscribirse(partido);
    Jugador _jugador_10 = new Jugador("Dieguito");
    InscripcionEstandar _inscripcionEstandar_8 = new InscripcionEstandar();
    Participante nuevoJugador = new Participante(_jugador_10, _inscripcionEstandar_8);
    nuevoJugador.inscribirse(partido);
    Jugador _jugador_11 = nuevoJugador.getJugador();
    boolean _estaInscripto = partido.estaInscripto(_jugador_11);
    Assert.assertTrue(_estaInscripto);
    Jugador _jugador_12 = segundoJugador.getJugador();
    boolean _estaInscripto_1 = partido.estaInscripto(_jugador_12);
    Assert.assertTrue(_estaInscripto_1);
    Jugador _jugador_13 = primerJugador.getJugador();
    boolean _estaInscripto_2 = partido.estaInscripto(_jugador_13);
    Assert.assertFalse(_estaInscripto_2);
  }
}
