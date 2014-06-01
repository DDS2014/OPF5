package test;

import domain.Jugador;
import domain.Partido;
import domain.inscripcion.InscripcionEstandar;
import domain.inscripcion.InscripcionSolidaria;
import domain.sugerencias.Comunidad;
import domain.sugerencias.Denegacion;
import domain.sugerencias.Sugerencia;
import java.util.Date;
import java.util.HashSet;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class PruebasDeSugerencias {
  /**
   * Pruebas a realizarse:
   * Si sugiero un jugador, y se aprueba, queda dentro de la comunidad
   * Si sugiero un jugador, y se rechaza, no queda en la comunidad
   * Si sugiero un jugador, queda pendiente
   * Si sugiero un jugador y se rechaza, queda registrada la denegación
   * Si sugiero un jugador, y se aprueba, este jugador después puede anotarse a los partidos lo más bien
   */
  private Comunidad losMuchachos = new Function0<Comunidad>() {
    public Comunidad apply() {
      Comunidad _comunidad = new Comunidad();
      return _comunidad;
    }
  }.apply();
  
  private Partido partidoDelDomingo = new Function0<Partido>() {
    public Partido apply() {
      Date _date = new Date();
      Partido _partido = new Partido(_date);
      return _partido;
    }
  }.apply();
  
  @Before
  public void setup() {
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador _jugador = new Jugador("Martin", 40, _inscripcionEstandar);
    Jugador martin = _jugador;
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Jugador _jugador_1 = new Jugador("Roman", 35, _inscripcionEstandar_1);
    Jugador roman = _jugador_1;
    this.losMuchachos.agregar(martin);
    this.losMuchachos.agregar(roman);
    this.losMuchachos.organizarPartido(this.partidoDelDomingo);
  }
  
  @Test
  public void cuandoAprueboUnJugadorQuedaEnLaComunidad() {
    Sugerencia _sugerencia = new Sugerencia("Rodrigo", 32);
    Sugerencia rodrigo = _sugerencia;
    this.losMuchachos.sugerir(rodrigo);
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    this.losMuchachos.aprobar(rodrigo, _inscripcionSolidaria);
    HashSet<Jugador> _aprobados = this.losMuchachos.getAprobados();
    int _length = ((Object[])Conversions.unwrapArray(_aprobados, Object.class)).length;
    boolean _equals = (_length == 3);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void cuandoRechazoUnJugadorNoQuedaEnLaComunidad() {
    Sugerencia _sugerencia = new Sugerencia("Hernan", 38);
    Sugerencia hernan = _sugerencia;
    this.losMuchachos.sugerir(hernan);
    this.losMuchachos.rechazar(hernan, "No se lleva bien con el resto de los muchachos");
    HashSet<Jugador> _aprobados = this.losMuchachos.getAprobados();
    int _length = ((Object[])Conversions.unwrapArray(_aprobados, Object.class)).length;
    boolean _equals = (_length == 2);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void cuandoSugieroUnJugadorQuedaPendiente() {
    Sugerencia _sugerencia = new Sugerencia("Hernan", 38);
    Sugerencia hernan = _sugerencia;
    this.losMuchachos.sugerir(hernan);
    HashSet<Sugerencia> _pendientes = this.losMuchachos.getPendientes();
    int _length = ((Object[])Conversions.unwrapArray(_pendientes, Object.class)).length;
    boolean _equals = (_length == 1);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void cuandoRechazoUnJugadorSeRegistraLaDenegacion() {
    Sugerencia _sugerencia = new Sugerencia("Hernan", 38);
    Sugerencia hernan = _sugerencia;
    this.losMuchachos.sugerir(hernan);
    this.losMuchachos.rechazar(hernan, "No se lleva bien con el resto de los muchachos");
    HashSet<Denegacion> _rechazados = this.losMuchachos.getRechazados();
    int _length = ((Object[])Conversions.unwrapArray(_rechazados, Object.class)).length;
    boolean _equals = (_length == 1);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void cuandoAprueboUnJugadorEntoncesSePuedeAnotarAlPartido() {
    Sugerencia _sugerencia = new Sugerencia("Guillermo", 41);
    Sugerencia amigoDeMartin = _sugerencia;
    this.losMuchachos.sugerir(amigoDeMartin);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador guillermo = this.losMuchachos.aprobar(amigoDeMartin, _inscripcionEstandar);
    guillermo.inscribirse(this.partidoDelDomingo);
    boolean _estaInscripto = this.partidoDelDomingo.estaInscripto(guillermo);
    Assert.assertTrue(_estaInscripto);
  }
}
