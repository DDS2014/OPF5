package test;

import domain.Jugador;
import domain.Partido;
import domain.excepciones.JugadorNoFueAnotadoException;
import domain.excepciones.NoHayLugarParaAnotarseException;
import domain.excepciones.NoSeCumpleLaCondicionParaAnotarseException;
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
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador _jugador = new Jugador("Pedrito", 23, _inscripcionEstandar);
    Jugador jugador = _jugador;
    jugador.inscribirse(partido);
    boolean _estaInscripto = partido.estaInscripto(jugador);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test
  public void cuandoUnJugadorDesplazaAOtroElDesplazadorQuedaInscriptoYElDesplazadoSale() {
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador _jugador = new Jugador("Juancito", 25, _inscripcionEstandar);
    Jugador saliente = _jugador;
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Jugador _jugador_1 = new Jugador("Jorgito", 20, _inscripcionEstandar_1);
    Jugador entrante = _jugador_1;
    partido.reemplazar(entrante, saliente);
    boolean _estaInscripto = partido.estaInscripto(entrante);
    Assert.assertTrue(_estaInscripto);
    boolean _estaInscripto_1 = partido.estaInscripto(saliente);
    Assert.assertFalse(_estaInscripto_1);
  }
  
  @Test(expected = NoHayLugarParaAnotarseException.class)
  public void noSePuedeAnotarNadieAUnPartidoCon10Estandar() {
    Partido partidoEstandar = Creaciones.crearPartidoLlenoCon10Estandar();
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador _jugador = new Jugador("Jorgito", 20, _inscripcionEstandar);
    Jugador colgado = _jugador;
    colgado.inscribirse(partidoEstandar);
    boolean _estaInscripto = partidoEstandar.estaInscripto(colgado);
    Assert.assertFalse(_estaInscripto);
  }
  
  @Test
  public void enUnaListaCon9EstandarY1SolidarioPuedeEntrarOtroEstandarDesplazandoAlSolidario() {
    Partido partido = Creaciones.crearPartidoCon9Estandar();
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Jugador _jugador = new Jugador("Marquitos", 20, _inscripcionSolidaria);
    Jugador jugadorSolidario = _jugador;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador _jugador_1 = new Jugador("Miguelito", 20, _inscripcionEstandar);
    Jugador jugadorNuevo = _jugador_1;
    jugadorSolidario.inscribirse(partido);
    jugadorNuevo.inscribirse(partido);
    boolean _estaInscripto = partido.estaInscripto(jugadorNuevo);
    Assert.assertTrue(_estaInscripto);
    boolean _estaInscripto_1 = partido.estaInscripto(jugadorSolidario);
    Assert.assertFalse(_estaInscripto_1);
  }
  
  @Test
  public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoEstandarDesplazaAlCondicional() {
    Partido partido = Creaciones.crearPartidoCon8Estandar();
    Condicion_LimiteDeEdad _condicion_LimiteDeEdad = new Condicion_LimiteDeEdad(20, 2, true, true);
    InscripcionCondicional _inscripcionCondicional = new InscripcionCondicional(_condicion_LimiteDeEdad);
    Jugador _jugador = new Jugador("Josecito", 34, _inscripcionCondicional);
    Jugador jugadorCondicional = _jugador;
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Jugador _jugador_1 = new Jugador("Marquitos", 20, _inscripcionSolidaria);
    Jugador jugadorSolidario = _jugador_1;
    jugadorSolidario.inscribirse(partido);
    jugadorCondicional.inscribirse(partido);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador _jugador_2 = new Jugador("Pablito", 20, _inscripcionEstandar);
    Jugador jugadorNuevo = _jugador_2;
    jugadorNuevo.inscribirse(partido);
    boolean _estaInscripto = partido.estaInscripto(jugadorNuevo);
    Assert.assertTrue(_estaInscripto);
    boolean _estaInscripto_1 = partido.estaInscripto(jugadorSolidario);
    Assert.assertTrue(_estaInscripto_1);
    boolean _estaInscripto_2 = partido.estaInscripto(jugadorCondicional);
    Assert.assertFalse(_estaInscripto_2);
  }
  
  @Test
  public void enUnaListaCon8Estandar1Solidarioy1CondicionalUnNuevoSolidarioDesplazaAlCondicional() {
    Partido partido = Creaciones.crearPartidoCon8Estandar();
    Condicion_LimiteDeEdad _condicion_LimiteDeEdad = new Condicion_LimiteDeEdad(20, 2, true, true);
    InscripcionCondicional _inscripcionCondicional = new InscripcionCondicional(_condicion_LimiteDeEdad);
    Jugador _jugador = new Jugador("Josecito", 34, _inscripcionCondicional);
    Jugador jugadorCondicional = _jugador;
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Jugador _jugador_1 = new Jugador("Marquitos", 20, _inscripcionSolidaria);
    Jugador jugadorSolidario = _jugador_1;
    jugadorSolidario.inscribirse(partido);
    jugadorCondicional.inscribirse(partido);
    InscripcionSolidaria _inscripcionSolidaria_1 = new InscripcionSolidaria();
    Jugador _jugador_2 = new Jugador("Pablito", 20, _inscripcionSolidaria_1);
    Jugador jugadorNuevo = _jugador_2;
    jugadorNuevo.inscribirse(partido);
    boolean _estaInscripto = partido.estaInscripto(jugadorNuevo);
    Assert.assertTrue(_estaInscripto);
    boolean _estaInscripto_1 = partido.estaInscripto(jugadorSolidario);
    Assert.assertTrue(_estaInscripto_1);
    boolean _estaInscripto_2 = partido.estaInscripto(jugadorCondicional);
    Assert.assertFalse(_estaInscripto_2);
  }
  
  @Test(expected = JugadorNoFueAnotadoException.class)
  public void noSePuedeAnotarAlMismoJugadorDosVeces() {
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador _jugador = new Jugador("Manuelito", 24, _inscripcionEstandar);
    Jugador jugador = _jugador;
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    jugador.inscribirse(partido);
    jugador.inscribirse(partido);
    List<Jugador> _jugadoresConfirmados = partido.getJugadoresConfirmados();
    int _size = _jugadoresConfirmados.size();
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void alHaberDosSolidariosParaDesplazarSeDesplazaAlQueSeAnotoPrimero() {
    Partido partido = Creaciones.crearPartidoCon8Estandar();
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Jugador _jugador = new Jugador("Danielito", 25, _inscripcionSolidaria);
    Jugador primerJugador = _jugador;
    InscripcionSolidaria _inscripcionSolidaria_1 = new InscripcionSolidaria();
    Jugador _jugador_1 = new Jugador("Fernandito", 24, _inscripcionSolidaria_1);
    Jugador segundoJugador = _jugador_1;
    primerJugador.inscribirse(partido);
    segundoJugador.inscribirse(partido);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador _jugador_2 = new Jugador("Dieguito", 18, _inscripcionEstandar);
    Jugador nuevoJugador = _jugador_2;
    nuevoJugador.inscribirse(partido);
    boolean _estaInscripto = partido.estaInscripto(nuevoJugador);
    Assert.assertTrue(_estaInscripto);
    boolean _estaInscripto_1 = partido.estaInscripto(segundoJugador);
    Assert.assertTrue(_estaInscripto_1);
    boolean _estaInscripto_2 = partido.estaInscripto(primerJugador);
    Assert.assertFalse(_estaInscripto_2);
  }
  
  public Partido crearPartidoParaPruebasDeCondicional() {
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Jugador _jugador = new Jugador("Danielito", 29, _inscripcionSolidaria);
    Jugador primerJugador = _jugador;
    InscripcionSolidaria _inscripcionSolidaria_1 = new InscripcionSolidaria();
    Jugador _jugador_1 = new Jugador("Fernandito", 24, _inscripcionSolidaria_1);
    Jugador segundoJugador = _jugador_1;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador _jugador_2 = new Jugador("Dieguito", 18, _inscripcionEstandar);
    Jugador tercerJugador = _jugador_2;
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Jugador _jugador_3 = new Jugador("Omarcito", 42, _inscripcionEstandar_1);
    Jugador cuartoJugador = _jugador_3;
    primerJugador.inscribirse(partido);
    segundoJugador.inscribirse(partido);
    tercerJugador.inscribirse(partido);
    cuartoJugador.inscribirse(partido);
    return partido;
  }
  
  @Test
  public void alCumplirseLaCondicionElCondicionalSeAnota() {
    Partido partido = this.crearPartidoParaPruebasDeCondicional();
    Condicion_LimiteDeEdad _condicion_LimiteDeEdad = new Condicion_LimiteDeEdad(20, 3, true, true);
    InscripcionCondicional _inscripcionCondicional = new InscripcionCondicional(_condicion_LimiteDeEdad);
    Jugador _jugador = new Jugador("Josue", 25, _inscripcionCondicional);
    Jugador jugadorCondicional = _jugador;
    jugadorCondicional.inscribirse(partido);
    boolean _estaInscripto = partido.estaInscripto(jugadorCondicional);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test(expected = NoSeCumpleLaCondicionParaAnotarseException.class)
  public void alNoCumplirseLaCondicionElCondicionalNoSeAnota() {
    Partido partido = this.crearPartidoParaPruebasDeCondicional();
    Condicion_LimiteDeEdad _condicion_LimiteDeEdad = new Condicion_LimiteDeEdad(25, 2, false, false);
    InscripcionCondicional _inscripcionCondicional = new InscripcionCondicional(_condicion_LimiteDeEdad);
    Jugador _jugador = new Jugador("Josue", 25, _inscripcionCondicional);
    Jugador jugadorCondicional = _jugador;
    jugadorCondicional.inscribirse(partido);
  }
}
