package test;

import domain.Jugador;
import domain.Partido;
import domain.excepciones.ImposibleEvaluarException;
import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioCompuesto;
import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDeLasUltimasCalificaciones;
import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDelHandicap;
import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDelUltimoPartido;
import domain.inscripcion.InscripcionEstandar;
import domain.sugerencias.Comunidad;
import java.util.Calendar;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class PruebasDeEvaluarJugadores {
  private Jugador martin = new Function0<Jugador>() {
    public Jugador apply() {
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Martin", 31, _inscripcionEstandar);
      return _jugador;
    }
  }.apply();
  
  private Jugador francisco = new Function0<Jugador>() {
    public Jugador apply() {
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Francisco", 22, _inscripcionEstandar);
      return _jugador;
    }
  }.apply();
  
  private Jugador federico = new Function0<Jugador>() {
    public Jugador apply() {
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Federico", 25, _inscripcionEstandar);
      return _jugador;
    }
  }.apply();
  
  private Comunidad losMuchachos = new Function0<Comunidad>() {
    public Comunidad apply() {
      Comunidad _comunidad = new Comunidad();
      return _comunidad;
    }
  }.apply();
  
  private Partido primerPartido;
  
  private Partido segundoPartido;
  
  private Calendar cal = new Function0<Calendar>() {
    public Calendar apply() {
      Calendar _instance = Calendar.getInstance();
      return _instance;
    }
  }.apply();
  
  @Before
  public void setup() {
    this.losMuchachos.agregar(this.martin);
    this.losMuchachos.agregar(this.francisco);
    this.losMuchachos.agregar(this.federico);
    this.martin.setHandicap(6);
    this.francisco.setHandicap(7);
    this.federico.setHandicap(9);
    Date _date = new Date();
    this.cal.setTime(_date);
    Date _time = this.cal.getTime();
    Partido _partido = new Partido(_time);
    this.primerPartido = _partido;
    this.cal.add(Calendar.DATE, 5);
    Date _time_1 = this.cal.getTime();
    Partido _partido_1 = new Partido(_time_1);
    this.segundoPartido = _partido_1;
    this.losMuchachos.organizarPartido(this.primerPartido);
    this.losMuchachos.organizarPartido(this.segundoPartido);
    this.martin.inscribirse(this.primerPartido);
    this.francisco.inscribirse(this.primerPartido);
    this.federico.inscribirse(this.primerPartido);
    this.martin.inscribirse(this.segundoPartido);
    this.francisco.inscribirse(this.segundoPartido);
    this.federico.inscribirse(this.segundoPartido);
    this.federico.calificar(9, "Dejó todo, sólo faltó el gol", this.segundoPartido, this.francisco);
    try {
      Thread.sleep(200);
    } catch (final Throwable _t) {
      if (_t instanceof InterruptedException) {
        final InterruptedException ex = (InterruptedException)_t;
        Thread _currentThread = Thread.currentThread();
        _currentThread.interrupt();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    this.federico.calificar(8, "Gran actuación, es fundamental para el equipo", this.segundoPartido, this.martin);
    try {
      Thread.sleep(200);
    } catch (final Throwable _t_1) {
      if (_t_1 instanceof InterruptedException) {
        final InterruptedException ex_1 = (InterruptedException)_t_1;
        Thread _currentThread_1 = Thread.currentThread();
        _currentThread_1.interrupt();
      } else {
        throw Exceptions.sneakyThrow(_t_1);
      }
    }
    this.federico.calificar(6, "Buenos arranques pero no terminó bien las jugadas", this.primerPartido, this.martin);
  }
  
  @Test
  public void evaluarPorHandicapDevuelveResultadoCorrecto() {
    CriterioDelHandicap _criterioDelHandicap = new CriterioDelHandicap();
    CriterioDelHandicap criterio = _criterioDelHandicap;
    double _evaluarJugador = criterio.evaluarJugador(this.federico);
    Assert.assertEquals("", 9.0, _evaluarJugador, 0.05);
  }
  
  @Test
  public void evaluarPorNUltimasCalificacionesDevuelveResultadoCorrecto() {
    CriterioDeLasUltimasCalificaciones _criterioDeLasUltimasCalificaciones = new CriterioDeLasUltimasCalificaciones(1);
    CriterioDeLasUltimasCalificaciones criterio1UltimaCalificacion = _criterioDeLasUltimasCalificaciones;
    CriterioDeLasUltimasCalificaciones _criterioDeLasUltimasCalificaciones_1 = new CriterioDeLasUltimasCalificaciones(2);
    CriterioDeLasUltimasCalificaciones criterio2UltimasCalificaciones = _criterioDeLasUltimasCalificaciones_1;
    CriterioDeLasUltimasCalificaciones _criterioDeLasUltimasCalificaciones_2 = new CriterioDeLasUltimasCalificaciones(3);
    CriterioDeLasUltimasCalificaciones criterio3UltimasCalificaciones = _criterioDeLasUltimasCalificaciones_2;
    double _evaluarJugador = criterio1UltimaCalificacion.evaluarJugador(this.federico);
    Assert.assertEquals("", 6.0, _evaluarJugador, 0.05);
    double _evaluarJugador_1 = criterio2UltimasCalificaciones.evaluarJugador(this.federico);
    Assert.assertEquals("", 7.0, _evaluarJugador_1, 0.05);
    double _evaluarJugador_2 = criterio3UltimasCalificaciones.evaluarJugador(this.federico);
    Assert.assertEquals("", 7.67, _evaluarJugador_2, 0.05);
  }
  
  @Test(expected = ImposibleEvaluarException.class)
  public void evaluarPorMasCalificacionesDeLasQueHayRompe() {
    CriterioDeLasUltimasCalificaciones _criterioDeLasUltimasCalificaciones = new CriterioDeLasUltimasCalificaciones(4);
    CriterioDeLasUltimasCalificaciones criterio = _criterioDeLasUltimasCalificaciones;
    criterio.evaluarJugador(this.federico);
  }
  
  @Test
  public void evaluarPorPromedioDelUltimoPartidoDevuelveResultadoCorrecto() {
    CriterioDelUltimoPartido _criterioDelUltimoPartido = new CriterioDelUltimoPartido(this.losMuchachos);
    CriterioDelUltimoPartido criterio = _criterioDelUltimoPartido;
    double _evaluarJugador = criterio.evaluarJugador(this.federico);
    Assert.assertEquals("", 8.50, _evaluarJugador, 0.05);
  }
  
  @Test
  public void evaluarPorCriterioCompuestoDevuelveResultadoCorrecto() {
    CriterioCompuesto _criterioCompuesto = new CriterioCompuesto();
    CriterioCompuesto criterio = _criterioCompuesto;
    CriterioDelHandicap _criterioDelHandicap = new CriterioDelHandicap();
    CriterioDelHandicap subCriterioHandicap = _criterioDelHandicap;
    CriterioDeLasUltimasCalificaciones _criterioDeLasUltimasCalificaciones = new CriterioDeLasUltimasCalificaciones(2);
    CriterioDeLasUltimasCalificaciones subCriterioUltimasDosCriticas = _criterioDeLasUltimasCalificaciones;
    criterio.agregarSubcriterio(subCriterioHandicap);
    criterio.agregarSubcriterio(subCriterioUltimasDosCriticas);
    double _evaluarJugador = criterio.evaluarJugador(this.federico);
    Assert.assertEquals("", 8, _evaluarJugador, 0.05);
  }
}
