package test;

import domain.Jugador;
import domain.Partido;
import domain.calificaciones.Calificacion;
import domain.excepciones.ImposibleCalificarException;
import domain.inscripcion.InscripcionEstandar;
import domain.inscripcion.InscripcionSolidaria;
import java.util.Date;
import java.util.HashSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class PruebasDeCalificaciones {
  private Partido partido1;
  
  private Partido partido2;
  
  private Jugador jugador1;
  
  private Jugador jugador2;
  
  @Before
  public void setup() {
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    this.partido1 = _partido;
    Date _date_1 = new Date();
    Partido _partido_1 = new Partido(_date_1);
    this.partido2 = _partido_1;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador _jugador = new Jugador("Juan", 18, _inscripcionEstandar);
    this.jugador1 = _jugador;
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    Jugador _jugador_1 = new Jugador("Pedro", 25, _inscripcionSolidaria);
    this.jugador2 = _jugador_1;
    this.jugador1.inscribirse(this.partido1);
    this.jugador1.inscribirse(this.partido2);
    this.jugador2.inscribirse(this.partido2);
    this.jugador1.calificar(8, "Muy bueno", this.partido1, this.jugador2);
    this.jugador1.calificar(5, "Regular", this.partido2, this.jugador2);
    this.jugador2.calificar(3, "Pesimo", this.partido2, this.jugador1);
  }
  
  @Test(expected = ImposibleCalificarException.class)
  public void NoSePuedeCalificarAUnJugadorNoInscripto() {
    this.jugador2.calificar(10, "Excelente", this.partido1, this.jugador1);
  }
  
  @Test(expected = ImposibleCalificarException.class)
  public void NoSePuedeCalificarAUnJugadorMasDeUnaVezEnElMismoPartido() {
    this.jugador1.calificar(10, "Excelente", this.partido1, this.jugador2);
  }
  
  @Test
  public void NoSePuedeCalificarAUnJugadorSiElPartidoNoSeJugo() {
    Date _date = new Date();
    final Date fecha = _date;
    final int proximoMes = fecha.getMonth();
    fecha.setMonth(proximoMes);
    Partido _partido = new Partido(fecha);
    Partido partido = _partido;
    this.jugador2.inscribirse(partido);
    this.jugador2.calificar(10, "Excelente", partido, this.jugador1);
  }
  
  @Test
  public void SeCalificaAUnJugadorEnVariosPartidos() {
    this.jugador2.inscribirse(this.partido1);
    this.jugador2.calificar(10, "Excelente", this.partido1, this.jugador1);
    HashSet<Calificacion> _calificaciones = this.jugador2.getCalificaciones();
    int _size = _calificaciones.size();
    Assert.assertEquals(_size, 2);
  }
  
  @Test(expected = ImposibleCalificarException.class)
  public void unJugadorNoPuedeCalificarseASiMismo() {
    this.jugador1.calificar(10, "Majestuoso, increible, telefono para Sabella", this.partido1, this.jugador1);
  }
}
