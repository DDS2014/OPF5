package test;

import domain.Jugador;
import domain.Partido;
import domain.excepciones.ImposibleGenerarEquiposException;
import domain.generacionDeEquipos.algoritmosDeGeneracion.GeneracionConcreta;
import domain.generacionDeEquipos.algoritmosDeGeneracion.GeneracionParImpar;
import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio;
import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDelHandicap;
import domain.inscripcion.InscripcionEstandar;
import java.util.Date;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.Creaciones;

@SuppressWarnings("all")
public class PruebasDeGenerarEquipos {
  private Partido partido;
  
  private Partido partido2;
  
  private Criterio criterio;
  
  private Jugador diego = new Function0<Jugador>() {
    public Jugador apply() {
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Diego", 22, _inscripcionEstandar);
      return _jugador;
    }
  }.apply();
  
  private Jugador facundo = new Function0<Jugador>() {
    public Jugador apply() {
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Facundo", 26, _inscripcionEstandar);
      return _jugador;
    }
  }.apply();
  
  private Jugador marcos = new Function0<Jugador>() {
    public Jugador apply() {
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Marcos", 28, _inscripcionEstandar);
      return _jugador;
    }
  }.apply();
  
  private Jugador pepe = new Function0<Jugador>() {
    public Jugador apply() {
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Pepe", 42, _inscripcionEstandar);
      return _jugador;
    }
  }.apply();
  
  private Jugador leo = new Function0<Jugador>() {
    public Jugador apply() {
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Leo", 32, _inscripcionEstandar);
      return _jugador;
    }
  }.apply();
  
  private Jugador homero = new Function0<Jugador>() {
    public Jugador apply() {
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Homero", 29, _inscripcionEstandar);
      return _jugador;
    }
  }.apply();
  
  private Jugador esteban = new Function0<Jugador>() {
    public Jugador apply() {
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Esteban", 20, _inscripcionEstandar);
      return _jugador;
    }
  }.apply();
  
  private Jugador luis = new Function0<Jugador>() {
    public Jugador apply() {
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Luis", 17, _inscripcionEstandar);
      return _jugador;
    }
  }.apply();
  
  private Jugador alejandro = new Function0<Jugador>() {
    public Jugador apply() {
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Alejandro", 34, _inscripcionEstandar);
      return _jugador;
    }
  }.apply();
  
  private Jugador martin = new Function0<Jugador>() {
    public Jugador apply() {
      InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
      Jugador _jugador = new Jugador("Martin", 29, _inscripcionEstandar);
      return _jugador;
    }
  }.apply();
  
  @Before
  public void setup() {
    Partido _crearPartidoCon9Estandar = Creaciones.crearPartidoCon9Estandar();
    this.partido = _crearPartidoCon9Estandar;
    this.diego.setHandicap(10);
    this.facundo.setHandicap(3);
    this.marcos.setHandicap(5);
    this.pepe.setHandicap(6);
    this.leo.setHandicap(1);
    this.homero.setHandicap(8);
    this.esteban.setHandicap(9);
    this.luis.setHandicap(7);
    this.alejandro.setHandicap(4);
    this.martin.setHandicap(2);
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    this.partido2 = _partido;
    this.diego.inscribirse(this.partido2);
    this.facundo.inscribirse(this.partido2);
    this.marcos.inscribirse(this.partido2);
    this.pepe.inscribirse(this.partido2);
    this.leo.inscribirse(this.partido2);
    this.homero.inscribirse(this.partido2);
    this.esteban.inscribirse(this.partido2);
    this.luis.inscribirse(this.partido2);
    this.alejandro.inscribirse(this.partido2);
    this.martin.inscribirse(this.partido2);
    CriterioDelHandicap _criterioDelHandicap = new CriterioDelHandicap();
    this.criterio = _criterioDelHandicap;
    GeneracionParImpar _generacionParImpar = new GeneracionParImpar();
    this.partido.definirAlgoritmoGeneracion(_generacionParImpar);
    this.partido.setCriterioDeOrdenamiento(this.criterio);
    GeneracionParImpar _generacionParImpar_1 = new GeneracionParImpar();
    this.partido2.definirAlgoritmoGeneracion(_generacionParImpar_1);
    this.partido2.setCriterioDeOrdenamiento(this.criterio);
  }
  
  @Test(expected = ImposibleGenerarEquiposException.class)
  public void LosEquiposNoSePuedenGenerarPorqueTienenSolo9Jugadores() {
    this.partido.generarEquipos();
  }
  
  @Test
  public void LosEquiposGeneradosTienen5JugadoresCadaUno() {
    this.diego.inscribirse(this.partido);
    this.partido.generarEquipos();
    List<Jugador> _primerEquipo = this.partido.getPrimerEquipo();
    int _size = _primerEquipo.size();
    Assert.assertEquals(5, _size);
    List<Jugador> _segundoEquipo = this.partido.getSegundoEquipo();
    int _size_1 = _segundoEquipo.size();
    Assert.assertEquals(5, _size_1);
  }
  
  @Test
  public void LosJugadoresDeCadaEquipoEstanBienUbicadosConAlgortimoParImpar() {
    this.partido2.generarEquipos();
    List<Jugador> _segundoEquipo = this.partido2.getSegundoEquipo();
    boolean _contains = _segundoEquipo.contains(this.diego);
    Assert.assertTrue(_contains);
    List<Jugador> _segundoEquipo_1 = this.partido2.getSegundoEquipo();
    boolean _contains_1 = _segundoEquipo_1.contains(this.martin);
    Assert.assertTrue(_contains_1);
    List<Jugador> _segundoEquipo_2 = this.partido2.getSegundoEquipo();
    boolean _contains_2 = _segundoEquipo_2.contains(this.pepe);
    Assert.assertTrue(_contains_2);
    List<Jugador> _segundoEquipo_3 = this.partido2.getSegundoEquipo();
    boolean _contains_3 = _segundoEquipo_3.contains(this.homero);
    Assert.assertTrue(_contains_3);
    List<Jugador> _segundoEquipo_4 = this.partido2.getSegundoEquipo();
    boolean _contains_4 = _segundoEquipo_4.contains(this.alejandro);
    Assert.assertTrue(_contains_4);
    List<Jugador> _primerEquipo = this.partido2.getPrimerEquipo();
    boolean _contains_5 = _primerEquipo.contains(this.marcos);
    Assert.assertTrue(_contains_5);
    List<Jugador> _primerEquipo_1 = this.partido2.getPrimerEquipo();
    boolean _contains_6 = _primerEquipo_1.contains(this.esteban);
    Assert.assertTrue(_contains_6);
    List<Jugador> _primerEquipo_2 = this.partido2.getPrimerEquipo();
    boolean _contains_7 = _primerEquipo_2.contains(this.facundo);
    Assert.assertTrue(_contains_7);
    List<Jugador> _primerEquipo_3 = this.partido2.getPrimerEquipo();
    boolean _contains_8 = _primerEquipo_3.contains(this.leo);
    Assert.assertTrue(_contains_8);
    List<Jugador> _primerEquipo_4 = this.partido2.getPrimerEquipo();
    boolean _contains_9 = _primerEquipo_4.contains(this.luis);
    Assert.assertTrue(_contains_9);
  }
  
  @Test
  public void LosJugadoresDeCadaEquipoEstanBienUbicadosConAlgortimoDeGeneracionConcreto() {
    GeneracionConcreta _generacionConcreta = new GeneracionConcreta();
    this.partido2.definirAlgoritmoGeneracion(_generacionConcreta);
    this.partido2.generarEquipos();
    List<Jugador> _primerEquipo = this.partido2.getPrimerEquipo();
    boolean _contains = _primerEquipo.contains(this.diego);
    Assert.assertTrue(_contains);
    List<Jugador> _primerEquipo_1 = this.partido2.getPrimerEquipo();
    boolean _contains_1 = _primerEquipo_1.contains(this.luis);
    Assert.assertTrue(_contains_1);
    List<Jugador> _primerEquipo_2 = this.partido2.getPrimerEquipo();
    boolean _contains_2 = _primerEquipo_2.contains(this.pepe);
    Assert.assertTrue(_contains_2);
    List<Jugador> _primerEquipo_3 = this.partido2.getPrimerEquipo();
    boolean _contains_3 = _primerEquipo_3.contains(this.martin);
    Assert.assertTrue(_contains_3);
    List<Jugador> _primerEquipo_4 = this.partido2.getPrimerEquipo();
    boolean _contains_4 = _primerEquipo_4.contains(this.facundo);
    Assert.assertTrue(_contains_4);
    List<Jugador> _segundoEquipo = this.partido2.getSegundoEquipo();
    boolean _contains_5 = _segundoEquipo.contains(this.esteban);
    Assert.assertTrue(_contains_5);
    List<Jugador> _segundoEquipo_1 = this.partido2.getSegundoEquipo();
    boolean _contains_6 = _segundoEquipo_1.contains(this.homero);
    Assert.assertTrue(_contains_6);
    List<Jugador> _segundoEquipo_2 = this.partido2.getSegundoEquipo();
    boolean _contains_7 = _segundoEquipo_2.contains(this.marcos);
    Assert.assertTrue(_contains_7);
    List<Jugador> _segundoEquipo_3 = this.partido2.getSegundoEquipo();
    boolean _contains_8 = _segundoEquipo_3.contains(this.alejandro);
    Assert.assertTrue(_contains_8);
    List<Jugador> _segundoEquipo_4 = this.partido2.getSegundoEquipo();
    boolean _contains_9 = _segundoEquipo_4.contains(this.leo);
    Assert.assertTrue(_contains_9);
  }
  
  @Test(expected = RuntimeException.class)
  public void noMePuedoBajarDePartidoConEquiposConfirmados() {
    GeneracionConcreta _generacionConcreta = new GeneracionConcreta();
    this.partido2.definirAlgoritmoGeneracion(_generacionConcreta);
    this.partido2.generarEquipos();
    this.partido2.confirmarEquipos();
    this.diego.bajarse(this.partido2);
  }
}
