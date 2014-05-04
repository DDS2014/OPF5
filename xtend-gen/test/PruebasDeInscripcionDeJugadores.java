package test;

import domain.Condicion_LimiteDeEdad;
import domain.InscripcionCondicional;
import domain.InscripcionEstandar;
import domain.InscripcionSolidaria;
import domain.Jugador;
import domain.Participante;
import domain.Partido;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import test.Creaciones;

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
    partido.reemplazar(entrante, saliente);
    Jugador _jugador_2 = entrante.getJugador();
    boolean _estaInscripto = partido.estaInscripto(_jugador_2);
    Assert.assertTrue(_estaInscripto);
    Jugador _jugador_3 = saliente.getJugador();
    boolean _estaInscripto_1 = partido.estaInscripto(_jugador_3);
    Assert.assertFalse(_estaInscripto_1);
  }
  
  @Test
  public void noSePuedeAnotarNadieAUnPartidoCon10Estandar() {
    Partido partidoEstandar = Creaciones.crearPartidoLlenoCon10Estandar();
    Jugador _jugador = new Jugador("Jorgito", 20);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante = new Participante(_jugador, _inscripcionEstandar);
    Participante colgado = _participante;
    boolean _inscribirse = colgado.inscribirse(partidoEstandar);
    Assert.assertFalse(_inscribirse);
  }
  
  @Test
  public void enUnaListaCon9EstandarY1SolidarioPuedeEntrarOtroEstandarDesplazandoAlSolidario() {
    Partido partido = Creaciones.crearPartidoCon9Estandar();
    Jugador _jugador = new Jugador("Marquitos", 20);
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Participante _participante = new Participante(_jugador, _inscripcionSolidaria);
    Participante jugadorSolidario = _participante;
    Jugador _jugador_1 = new Jugador("Miguelito", 20);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante_1 = new Participante(_jugador_1, _inscripcionEstandar);
    Participante jugadorNuevo = _participante_1;
    jugadorSolidario.inscribirse(partido);
    jugadorNuevo.inscribirse(partido);
    Jugador _jugador_2 = jugadorNuevo.getJugador();
    boolean _estaInscripto = partido.estaInscripto(_jugador_2);
    Assert.assertTrue(_estaInscripto);
    Jugador _jugador_3 = jugadorSolidario.getJugador();
    boolean _estaInscripto_1 = partido.estaInscripto(_jugador_3);
    Assert.assertFalse(_estaInscripto_1);
  }
  
  @Test
  public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoEstandarDesplazaAlCondicional() {
    Partido partido = Creaciones.crearPartidoCon8Estandar();
    Jugador _jugador = new Jugador("Josecito", 34);
    Condicion_LimiteDeEdad _condicion_LimiteDeEdad = new Condicion_LimiteDeEdad(20, 2, true, true);
    InscripcionCondicional _inscripcionCondicional = new InscripcionCondicional(_condicion_LimiteDeEdad);
    Participante _participante = new Participante(_jugador, _inscripcionCondicional);
    Participante jugadorCondicional = _participante;
    Jugador _jugador_1 = new Jugador("Marquitos", 20);
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Participante _participante_1 = new Participante(_jugador_1, _inscripcionSolidaria);
    Participante jugadorSolidario = _participante_1;
    jugadorSolidario.inscribirse(partido);
    jugadorCondicional.inscribirse(partido);
    Jugador _jugador_2 = new Jugador("Pablito", 20);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante_2 = new Participante(_jugador_2, _inscripcionEstandar);
    Participante jugadorNuevo = _participante_2;
    jugadorNuevo.inscribirse(partido);
    Jugador _jugador_3 = jugadorNuevo.getJugador();
    boolean _estaInscripto = partido.estaInscripto(_jugador_3);
    Assert.assertTrue(_estaInscripto);
    Jugador _jugador_4 = jugadorSolidario.getJugador();
    boolean _estaInscripto_1 = partido.estaInscripto(_jugador_4);
    Assert.assertTrue(_estaInscripto_1);
    Jugador _jugador_5 = jugadorCondicional.getJugador();
    boolean _estaInscripto_2 = partido.estaInscripto(_jugador_5);
    Assert.assertFalse(_estaInscripto_2);
  }
  
  @Test
  public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoSolidarioDesplazaAlCondicional() {
    Partido partido = Creaciones.crearPartidoCon8Estandar();
    Jugador _jugador = new Jugador("Ricardito", 25);
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Participante _participante = new Participante(_jugador, _inscripcionSolidaria);
    Participante jugadorSolidario = _participante;
    Jugador _jugador_1 = new Jugador("Josecito", 34);
    Condicion_LimiteDeEdad _condicion_LimiteDeEdad = new Condicion_LimiteDeEdad(20, 2, true, true);
    InscripcionCondicional _inscripcionCondicional = new InscripcionCondicional(_condicion_LimiteDeEdad);
    Participante _participante_1 = new Participante(_jugador_1, _inscripcionCondicional);
    Participante jugadorCondicional = _participante_1;
    jugadorSolidario.inscribirse(partido);
    jugadorCondicional.inscribirse(partido);
    Jugador _jugador_2 = new Jugador("Pablito", 20);
    InscripcionSolidaria _inscripcionSolidaria_1 = new InscripcionSolidaria();
    Participante _participante_2 = new Participante(_jugador_2, _inscripcionSolidaria_1);
    Participante jugadorNuevoSolidario = _participante_2;
    jugadorNuevoSolidario.inscribirse(partido);
    Jugador _jugador_3 = jugadorNuevoSolidario.getJugador();
    boolean _estaInscripto = partido.estaInscripto(_jugador_3);
    Assert.assertTrue(_estaInscripto);
    Jugador _jugador_4 = jugadorSolidario.getJugador();
    boolean _estaInscripto_1 = partido.estaInscripto(_jugador_4);
    Assert.assertTrue(_estaInscripto_1);
    Jugador _jugador_5 = jugadorCondicional.getJugador();
    boolean _estaInscripto_2 = partido.estaInscripto(_jugador_5);
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
    Partido partido = Creaciones.crearPartidoCon8Estandar();
    Jugador _jugador = new Jugador("Danielito", 25);
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Participante _participante = new Participante(_jugador, _inscripcionSolidaria);
    Participante primerJugador = _participante;
    Jugador _jugador_1 = new Jugador("Fernandito", 24);
    InscripcionSolidaria _inscripcionSolidaria_1 = new InscripcionSolidaria();
    Participante _participante_1 = new Participante(_jugador_1, _inscripcionSolidaria_1);
    Participante segundoJugador = _participante_1;
    primerJugador.inscribirse(partido);
    segundoJugador.inscribirse(partido);
    Jugador _jugador_2 = new Jugador("Dieguito", 18);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Participante _participante_2 = new Participante(_jugador_2, _inscripcionEstandar);
    Participante nuevoJugador = _participante_2;
    nuevoJugador.inscribirse(partido);
    Jugador _jugador_3 = nuevoJugador.getJugador();
    boolean _estaInscripto = partido.estaInscripto(_jugador_3);
    Assert.assertTrue(_estaInscripto);
    Jugador _jugador_4 = segundoJugador.getJugador();
    boolean _estaInscripto_1 = partido.estaInscripto(_jugador_4);
    Assert.assertTrue(_estaInscripto_1);
    Jugador _jugador_5 = primerJugador.getJugador();
    boolean _estaInscripto_2 = partido.estaInscripto(_jugador_5);
    Assert.assertFalse(_estaInscripto_2);
  }
}
