package test;

import domain.Jugador;
import domain.Participante;
import domain.Partido;
import domain.excepciones.JugadorNoFueAnotadoException;
import domain.excepciones.NoHayLugarParaAnotarseException;
import domain.inscripcion.InscripcionCondicional;
import domain.inscripcion.InscripcionEstandar;
import domain.inscripcion.InscripcionSolidaria;
import domain.inscripcion.condiciones.Condicion_LimiteDeEdad;
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
    Participante _participante = new Participante(jugador);
    Participante participante = _participante;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(participante);
    partido.inscribir(_inscripcionEstandar);
    boolean _estaInscripto = partido.estaInscripto(jugador);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test
  public void cuandoUnJugadorDesplazaAOtroElDesplazadorQuedaInscriptoYElDesplazadoSale() {
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    Jugador _jugador = new Jugador("Juancito", 25);
    Participante _participante = new Participante(_jugador);
    Participante saliente = _participante;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(saliente);
    saliente.setModalidad(_inscripcionEstandar);
    Jugador _jugador_1 = new Jugador("Jorgito", 20);
    Participante _participante_1 = new Participante(_jugador_1);
    Participante entrante = _participante_1;
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar(entrante);
    entrante.setModalidad(_inscripcionEstandar_1);
    partido.reemplazar(entrante, saliente);
    Jugador _jugador_2 = entrante.getJugador();
    boolean _estaInscripto = partido.estaInscripto(_jugador_2);
    Assert.assertTrue(_estaInscripto);
    Jugador _jugador_3 = saliente.getJugador();
    boolean _estaInscripto_1 = partido.estaInscripto(_jugador_3);
    Assert.assertFalse(_estaInscripto_1);
  }
  
  @Test(expected = NoHayLugarParaAnotarseException.class)
  public void noSePuedeAnotarNadieAUnPartidoCon10Estandar() {
    Partido partidoEstandar = Creaciones.crearPartidoLlenoCon10Estandar();
    Jugador _jugador = new Jugador("Jorgito", 20);
    Participante _participante = new Participante(_jugador);
    Participante colgado = _participante;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(colgado);
    partidoEstandar.inscribir(_inscripcionEstandar);
    Jugador _jugador_1 = colgado.getJugador();
    boolean _estaInscripto = partidoEstandar.estaInscripto(_jugador_1);
    Assert.assertFalse(_estaInscripto);
  }
  
  @Test
  public void enUnaListaCon9EstandarY1SolidarioPuedeEntrarOtroEstandarDesplazandoAlSolidario() {
    Partido partido = Creaciones.crearPartidoCon9Estandar();
    Jugador _jugador = new Jugador("Marquitos", 20);
    Participante _participante = new Participante(_jugador);
    Participante jugadorSolidario = _participante;
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria(jugadorSolidario);
    jugadorSolidario.setModalidad(_inscripcionSolidaria);
    Jugador _jugador_1 = new Jugador("Miguelito", 20);
    Participante _participante_1 = new Participante(_jugador_1);
    Participante jugadorNuevo = _participante_1;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(jugadorNuevo);
    jugadorNuevo.setModalidad(_inscripcionEstandar);
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
    Participante _participante = new Participante(_jugador);
    Participante jugadorCondicional = _participante;
    Condicion_LimiteDeEdad _condicion_LimiteDeEdad = new Condicion_LimiteDeEdad(20, 2, true, true);
    InscripcionCondicional _inscripcionCondicional = new InscripcionCondicional(jugadorCondicional, _condicion_LimiteDeEdad);
    jugadorCondicional.setModalidad(_inscripcionCondicional);
    Jugador _jugador_1 = new Jugador("Marquitos", 20);
    Participante _participante_1 = new Participante(_jugador_1);
    Participante jugadorSolidario = _participante_1;
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria(jugadorSolidario);
    jugadorSolidario.setModalidad(_inscripcionSolidaria);
    jugadorSolidario.inscribirse(partido);
    jugadorCondicional.inscribirse(partido);
    Jugador _jugador_2 = new Jugador("Pablito", 20);
    Participante _participante_2 = new Participante(_jugador_2);
    Participante jugadorNuevo = _participante_2;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(jugadorNuevo);
    jugadorNuevo.setModalidad(_inscripcionEstandar);
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
    Participante _participante = new Participante(_jugador);
    Participante jugadorSolidario = _participante;
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria(jugadorSolidario);
    jugadorSolidario.setModalidad(_inscripcionSolidaria);
    Jugador _jugador_1 = new Jugador("Josecito", 34);
    Participante _participante_1 = new Participante(_jugador_1);
    Participante jugadorCondicional = _participante_1;
    Condicion_LimiteDeEdad _condicion_LimiteDeEdad = new Condicion_LimiteDeEdad(20, 2, true, true);
    InscripcionCondicional _inscripcionCondicional = new InscripcionCondicional(jugadorCondicional, _condicion_LimiteDeEdad);
    jugadorCondicional.setModalidad(_inscripcionCondicional);
    jugadorSolidario.inscribirse(partido);
    jugadorCondicional.inscribirse(partido);
    Jugador _jugador_2 = new Jugador("Pablito", 20);
    Participante _participante_2 = new Participante(_jugador_2);
    Participante jugadorNuevoSolidario = _participante_2;
    InscripcionSolidaria _inscripcionSolidaria_1 = new InscripcionSolidaria(jugadorNuevoSolidario);
    jugadorNuevoSolidario.setModalidad(_inscripcionSolidaria_1);
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
  
  @Test(expected = JugadorNoFueAnotadoException.class)
  public void noSePuedeAnotarAlMismoJugadorDosVeces() {
    Jugador _jugador = new Jugador("Manuelito", 24);
    Jugador jugador = _jugador;
    Participante _participante = new Participante(jugador);
    Participante participante = _participante;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(participante);
    participante.setModalidad(_inscripcionEstandar);
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
    Participante _participante = new Participante(_jugador);
    Participante primerJugador = _participante;
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria(primerJugador);
    primerJugador.setModalidad(_inscripcionSolidaria);
    Jugador _jugador_1 = new Jugador("Fernandito", 24);
    Participante _participante_1 = new Participante(_jugador_1);
    Participante segundoJugador = _participante_1;
    InscripcionSolidaria _inscripcionSolidaria_1 = new InscripcionSolidaria(segundoJugador);
    segundoJugador.setModalidad(_inscripcionSolidaria_1);
    primerJugador.inscribirse(partido);
    segundoJugador.inscribirse(partido);
    Jugador _jugador_2 = new Jugador("Dieguito", 18);
    Participante _participante_2 = new Participante(_jugador_2);
    Participante nuevoJugador = _participante_2;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(nuevoJugador);
    nuevoJugador.setModalidad(_inscripcionEstandar);
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
