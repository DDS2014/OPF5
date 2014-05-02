package test;

import domain.Condicion_LimiteDeEdad;
import domain.ImposibleAnotarseException;
import domain.InscripcionCondicional;
import domain.InscripcionEstandar;
import domain.InscripcionSolidaria;
import domain.Jugador;
import domain.Participante;
import domain.Partido;
import java.util.Date;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class PruebasDeInscripcionDeJugadores {
  @Test
  public void inscriboUnJugadorAUnPartidoYQuedaInscripto() {
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    Jugador _jugador = new Jugador("Pedrito", 23);
    Jugador jugador = _jugador;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante = new Participante(jugador, _inscripcionEstandar);
    Participante participante = _participante;
    participante.inscribirse(partido);
    boolean _estaInscripto = partido.estaInscripto(jugador);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test
  public void cuandoUnJugadorDesplazaAOtroElDesplazadorQuedaInscriptoYElDesplazadoSale() {
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    Jugador _jugador = new Jugador("Juancito", 25);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante = new Participante(_jugador, _inscripcionEstandar);
    Participante saliente = _participante;
    Jugador _jugador_1 = new Jugador("Jorgito", 20);
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Participante _participante_1 = new Participante(_jugador_1, _inscripcionEstandar_1);
    Participante entrante = _participante_1;
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
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partidoEstandar = _partido;
    Jugador _jugador = new Jugador("Pepe", 20);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante = new Participante(_jugador, _inscripcionEstandar);
    Participante part1 = _participante;
    Jugador _jugador_1 = new Jugador("Luis", 35);
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Participante _participante_1 = new Participante(_jugador_1, _inscripcionEstandar_1);
    Participante part2 = _participante_1;
    Jugador _jugador_2 = new Jugador("Juan", 27);
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar();
    Participante _participante_2 = new Participante(_jugador_2, _inscripcionEstandar_2);
    Participante part3 = _participante_2;
    Jugador _jugador_3 = new Jugador("Alberto", 20);
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar();
    Participante _participante_3 = new Participante(_jugador_3, _inscripcionEstandar_3);
    Participante part4 = _participante_3;
    Jugador _jugador_4 = new Jugador("Fabio", 20);
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar();
    Participante _participante_4 = new Participante(_jugador_4, _inscripcionEstandar_4);
    Participante part5 = _participante_4;
    Jugador _jugador_5 = new Jugador("Alejo", 26);
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar();
    Participante _participante_5 = new Participante(_jugador_5, _inscripcionEstandar_5);
    Participante part6 = _participante_5;
    Jugador _jugador_6 = new Jugador("Casio", 29);
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar();
    Participante _participante_6 = new Participante(_jugador_6, _inscripcionEstandar_6);
    Participante part7 = _participante_6;
    Jugador _jugador_7 = new Jugador("Alan", 30);
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar();
    Participante _participante_7 = new Participante(_jugador_7, _inscripcionEstandar_7);
    Participante part8 = _participante_7;
    Jugador _jugador_8 = new Jugador("Carlos", 20);
    InscripcionEstandar _inscripcionEstandar_8 = new InscripcionEstandar();
    Participante _participante_8 = new Participante(_jugador_8, _inscripcionEstandar_8);
    Participante part9 = _participante_8;
    Jugador _jugador_9 = new Jugador("Lucas", 20);
    InscripcionEstandar _inscripcionEstandar_9 = new InscripcionEstandar();
    Participante _participante_9 = new Participante(_jugador_9, _inscripcionEstandar_9);
    Participante part10 = _participante_9;
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
    Jugador _jugador_10 = new Jugador("Jorgito", 20);
    InscripcionEstandar _inscripcionEstandar_10 = new InscripcionEstandar();
    Participante _participante_10 = new Participante(_jugador_10, _inscripcionEstandar_10);
    Participante colgado = _participante_10;
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
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    Jugador _jugador = new Jugador("Pepe", 20);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante = new Participante(_jugador, _inscripcionEstandar);
    Participante part1 = _participante;
    Jugador _jugador_1 = new Jugador("Luis", 35);
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Participante _participante_1 = new Participante(_jugador_1, _inscripcionEstandar_1);
    Participante part2 = _participante_1;
    Jugador _jugador_2 = new Jugador("Juan", 27);
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar();
    Participante _participante_2 = new Participante(_jugador_2, _inscripcionEstandar_2);
    Participante part3 = _participante_2;
    Jugador _jugador_3 = new Jugador("Alberto", 20);
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar();
    Participante _participante_3 = new Participante(_jugador_3, _inscripcionEstandar_3);
    Participante part4 = _participante_3;
    Jugador _jugador_4 = new Jugador("Fabio", 20);
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar();
    Participante _participante_4 = new Participante(_jugador_4, _inscripcionEstandar_4);
    Participante part5 = _participante_4;
    Jugador _jugador_5 = new Jugador("Alejo", 26);
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar();
    Participante _participante_5 = new Participante(_jugador_5, _inscripcionEstandar_5);
    Participante part6 = _participante_5;
    Jugador _jugador_6 = new Jugador("Casio", 29);
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar();
    Participante _participante_6 = new Participante(_jugador_6, _inscripcionEstandar_6);
    Participante part7 = _participante_6;
    Jugador _jugador_7 = new Jugador("Alan", 30);
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar();
    Participante _participante_7 = new Participante(_jugador_7, _inscripcionEstandar_7);
    Participante part8 = _participante_7;
    Jugador _jugador_8 = new Jugador("Carlos", 20);
    InscripcionEstandar _inscripcionEstandar_8 = new InscripcionEstandar();
    Participante _participante_8 = new Participante(_jugador_8, _inscripcionEstandar_8);
    Participante part9 = _participante_8;
    Jugador _jugador_9 = new Jugador("Marquitos", 20);
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Participante _participante_9 = new Participante(_jugador_9, _inscripcionSolidaria);
    Participante jugadorSolidario = _participante_9;
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
    Jugador _jugador_10 = new Jugador("Miguelito", 20);
    InscripcionEstandar _inscripcionEstandar_9 = new InscripcionEstandar();
    Participante _participante_10 = new Participante(_jugador_10, _inscripcionEstandar_9);
    Participante jugadorNuevo = _participante_10;
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
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    Jugador _jugador = new Jugador("Pepe", 20);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante = new Participante(_jugador, _inscripcionEstandar);
    Participante part1 = _participante;
    Jugador _jugador_1 = new Jugador("Luis", 35);
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Participante _participante_1 = new Participante(_jugador_1, _inscripcionEstandar_1);
    Participante part2 = _participante_1;
    Jugador _jugador_2 = new Jugador("Juan", 27);
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar();
    Participante _participante_2 = new Participante(_jugador_2, _inscripcionEstandar_2);
    Participante part3 = _participante_2;
    Jugador _jugador_3 = new Jugador("Alberto", 20);
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar();
    Participante _participante_3 = new Participante(_jugador_3, _inscripcionEstandar_3);
    Participante part4 = _participante_3;
    Jugador _jugador_4 = new Jugador("Fabio", 20);
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar();
    Participante _participante_4 = new Participante(_jugador_4, _inscripcionEstandar_4);
    Participante part5 = _participante_4;
    Jugador _jugador_5 = new Jugador("Alejo", 26);
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar();
    Participante _participante_5 = new Participante(_jugador_5, _inscripcionEstandar_5);
    Participante part6 = _participante_5;
    Jugador _jugador_6 = new Jugador("Casio", 29);
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar();
    Participante _participante_6 = new Participante(_jugador_6, _inscripcionEstandar_6);
    Participante part7 = _participante_6;
    Jugador _jugador_7 = new Jugador("Alan", 30);
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar();
    Participante _participante_7 = new Participante(_jugador_7, _inscripcionEstandar_7);
    Participante part8 = _participante_7;
    Jugador _jugador_8 = new Jugador("Josecito", 34);
    Condicion_LimiteDeEdad _condicion_LimiteDeEdad = new Condicion_LimiteDeEdad(20, 2, true, true);
    InscripcionCondicional _inscripcionCondicional = new InscripcionCondicional(_condicion_LimiteDeEdad);
    Participante _participante_8 = new Participante(_jugador_8, _inscripcionCondicional);
    Participante jugadorCondicional = _participante_8;
    Jugador _jugador_9 = new Jugador("Marquitos", 20);
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Participante _participante_9 = new Participante(_jugador_9, _inscripcionSolidaria);
    Participante jugadorSolidario = _participante_9;
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
    Jugador _jugador_10 = new Jugador("Pablito", 20);
    InscripcionEstandar _inscripcionEstandar_8 = new InscripcionEstandar();
    Participante _participante_10 = new Participante(_jugador_10, _inscripcionEstandar_8);
    Participante jugadorNuevo = _participante_10;
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
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    Jugador _jugador = new Jugador("Ricardito", 25);
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Participante _participante = new Participante(_jugador, _inscripcionSolidaria);
    Participante jugadorSolidario = _participante;
    Jugador _jugador_1 = new Jugador("Josecito", 34);
    Condicion_LimiteDeEdad _condicion_LimiteDeEdad = new Condicion_LimiteDeEdad(20, 2, true, true);
    InscripcionCondicional _inscripcionCondicional = new InscripcionCondicional(_condicion_LimiteDeEdad);
    Participante _participante_1 = new Participante(_jugador_1, _inscripcionCondicional);
    Participante jugadorCondicional = _participante_1;
    Jugador _jugador_2 = new Jugador("Juan", 27);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante_2 = new Participante(_jugador_2, _inscripcionEstandar);
    Participante part3 = _participante_2;
    Jugador _jugador_3 = new Jugador("Alberto", 20);
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Participante _participante_3 = new Participante(_jugador_3, _inscripcionEstandar_1);
    Participante part4 = _participante_3;
    Jugador _jugador_4 = new Jugador("Fabio", 20);
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar();
    Participante _participante_4 = new Participante(_jugador_4, _inscripcionEstandar_2);
    Participante part5 = _participante_4;
    Jugador _jugador_5 = new Jugador("Alejo", 26);
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar();
    Participante _participante_5 = new Participante(_jugador_5, _inscripcionEstandar_3);
    Participante part6 = _participante_5;
    Jugador _jugador_6 = new Jugador("Casio", 29);
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar();
    Participante _participante_6 = new Participante(_jugador_6, _inscripcionEstandar_4);
    Participante part7 = _participante_6;
    Jugador _jugador_7 = new Jugador("Alan", 30);
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar();
    Participante _participante_7 = new Participante(_jugador_7, _inscripcionEstandar_5);
    Participante part8 = _participante_7;
    Jugador _jugador_8 = new Jugador("Carlos", 20);
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar();
    Participante _participante_8 = new Participante(_jugador_8, _inscripcionEstandar_6);
    Participante part9 = _participante_8;
    Jugador _jugador_9 = new Jugador("Lucas", 22);
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar();
    Participante _participante_9 = new Participante(_jugador_9, _inscripcionEstandar_7);
    Participante part10 = _participante_9;
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
    Jugador _jugador_10 = new Jugador("Pablito", 20);
    InscripcionSolidaria _inscripcionSolidaria_1 = new InscripcionSolidaria();
    Participante _participante_10 = new Participante(_jugador_10, _inscripcionSolidaria_1);
    Participante jugadorNuevoSolidario = _participante_10;
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
    Jugador _jugador = new Jugador("Manuelito", 24);
    Jugador jugador = _jugador;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante = new Participante(jugador, _inscripcionEstandar);
    Participante participante = _participante;
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    participante.inscribirse(partido);
    participante.inscribirse(partido);
    List<Participante> _participantesConfirmados = partido.getParticipantesConfirmados();
    int _size = _participantesConfirmados.size();
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void alHaberDosSolidariosParaDesplazarSeDesplazaAlQueSeAnotoPrimero() {
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    Jugador _jugador = new Jugador("Danielito", 25);
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Participante _participante = new Participante(_jugador, _inscripcionSolidaria);
    Participante primerJugador = _participante;
    Jugador _jugador_1 = new Jugador("Fernandito", 24);
    InscripcionSolidaria _inscripcionSolidaria_1 = new InscripcionSolidaria();
    Participante _participante_1 = new Participante(_jugador_1, _inscripcionSolidaria_1);
    Participante segundoJugador = _participante_1;
    Jugador _jugador_2 = new Jugador("Juan", 27);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante_2 = new Participante(_jugador_2, _inscripcionEstandar);
    Participante part3 = _participante_2;
    Jugador _jugador_3 = new Jugador("Alberto", 20);
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Participante _participante_3 = new Participante(_jugador_3, _inscripcionEstandar_1);
    Participante part4 = _participante_3;
    Jugador _jugador_4 = new Jugador("Fabio", 20);
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar();
    Participante _participante_4 = new Participante(_jugador_4, _inscripcionEstandar_2);
    Participante part5 = _participante_4;
    Jugador _jugador_5 = new Jugador("Alejo", 26);
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar();
    Participante _participante_5 = new Participante(_jugador_5, _inscripcionEstandar_3);
    Participante part6 = _participante_5;
    Jugador _jugador_6 = new Jugador("Casio", 29);
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar();
    Participante _participante_6 = new Participante(_jugador_6, _inscripcionEstandar_4);
    Participante part7 = _participante_6;
    Jugador _jugador_7 = new Jugador("Alan", 30);
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar();
    Participante _participante_7 = new Participante(_jugador_7, _inscripcionEstandar_5);
    Participante part8 = _participante_7;
    Jugador _jugador_8 = new Jugador("Carlos", 20);
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar();
    Participante _participante_8 = new Participante(_jugador_8, _inscripcionEstandar_6);
    Participante part9 = _participante_8;
    Jugador _jugador_9 = new Jugador("Lucas", 22);
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar();
    Participante _participante_9 = new Participante(_jugador_9, _inscripcionEstandar_7);
    Participante part10 = _participante_9;
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
    Jugador _jugador_10 = new Jugador("Dieguito", 18);
    InscripcionEstandar _inscripcionEstandar_8 = new InscripcionEstandar();
    Participante _participante_10 = new Participante(_jugador_10, _inscripcionEstandar_8);
    Participante nuevoJugador = _participante_10;
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
