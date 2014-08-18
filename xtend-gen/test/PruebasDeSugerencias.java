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
  private Comunidad losMuchachos = new Comunidad();
  
  private Partido partidoDelDomingo = new Partido(new Date());
  
  @Before
  public void setup() {
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador martin = new Jugador("Martin", 40, _inscripcionEstandar);
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Jugador roman = new Jugador("Roman", 35, _inscripcionEstandar_1);
    this.losMuchachos.agregar(martin);
    this.losMuchachos.agregar(roman);
    this.losMuchachos.organizarPartido(this.partidoDelDomingo);
  }
  
  @Test
  public void cuandoAprueboUnJugadorQuedaEnLaComunidad() {
    Sugerencia rodrigo = new Sugerencia("Rodrigo", 32);
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
    Sugerencia hernan = new Sugerencia("Hernan", 38);
    this.losMuchachos.sugerir(hernan);
    this.losMuchachos.rechazar(hernan, "No se lleva bien con el resto de los muchachos");
    HashSet<Jugador> _aprobados = this.losMuchachos.getAprobados();
    int _length = ((Object[])Conversions.unwrapArray(_aprobados, Object.class)).length;
    boolean _equals = (_length == 2);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void cuandoSugieroUnJugadorQuedaPendiente() {
    Sugerencia hernan = new Sugerencia("Hernan", 38);
    this.losMuchachos.sugerir(hernan);
    HashSet<Sugerencia> _pendientes = this.losMuchachos.getPendientes();
    int _length = ((Object[])Conversions.unwrapArray(_pendientes, Object.class)).length;
    boolean _equals = (_length == 1);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void cuandoRechazoUnJugadorSeRegistraLaDenegacion() {
    Sugerencia hernan = new Sugerencia("Hernan", 38);
    this.losMuchachos.sugerir(hernan);
    this.losMuchachos.rechazar(hernan, "No se lleva bien con el resto de los muchachos");
    HashSet<Denegacion> _rechazados = this.losMuchachos.getRechazados();
    int _length = ((Object[])Conversions.unwrapArray(_rechazados, Object.class)).length;
    boolean _equals = (_length == 1);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void cuandoAprueboUnJugadorEntoncesSePuedeAnotarAlPartido() {
    Sugerencia amigoDeMartin = new Sugerencia("Guillermo", 41);
    this.losMuchachos.sugerir(amigoDeMartin);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador guillermo = this.losMuchachos.aprobar(amigoDeMartin, _inscripcionEstandar);
    guillermo.inscribirse(this.partidoDelDomingo);
    boolean _estaInscripto = this.partidoDelDomingo.estaInscripto(guillermo);
    Assert.assertTrue(_estaInscripto);
  }
}
