package test;

import domain.Jugador;
import domain.Partido;
import domain.generacionDeEquipos.CriterioDelHandicap;
import domain.inscripcion.InscripcionEstandar;
import domain.sugerencias.Comunidad;
import java.util.Calendar;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class PruebasDeGenerarEquipos {
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
    this.federico.calificar(8, "Gran actuación, es fundamental para el equipo", this.segundoPartido, this.martin);
    this.federico.calificar(6, "Buenos arranques pero no terminó bien las jugadas", this.primerPartido, this.martin);
  }
  
  @Test
  public void evaluarPorHandicapDevuelveResultadoCorrecto() {
    CriterioDelHandicap _criterioDelHandicap = new CriterioDelHandicap();
    CriterioDelHandicap criterio = _criterioDelHandicap;
    double _evaluarJugador = criterio.evaluarJugador(this.federico);
    Assert.assertEquals("", _evaluarJugador, 9.0, 0.05);
  }
}
