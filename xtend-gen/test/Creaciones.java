package test;

import domain.Jugador;
import domain.Partido;
import domain.inscripcion.InscripcionEstandar;
import java.util.Date;

@SuppressWarnings("all")
public class Creaciones {
  public static Partido crearPartidoCon8Estandar() {
    Date _date = new Date();
    Partido partido = new Partido(_date);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador p1 = new Jugador("Pepe", 20, _inscripcionEstandar);
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Jugador p2 = new Jugador("Luis", 35, _inscripcionEstandar_1);
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar();
    Jugador p3 = new Jugador("Juan", 27, _inscripcionEstandar_2);
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar();
    Jugador p4 = new Jugador("Alberto", 20, _inscripcionEstandar_3);
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar();
    Jugador p5 = new Jugador("Fabio", 20, _inscripcionEstandar_4);
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar();
    Jugador p6 = new Jugador("Alejo", 26, _inscripcionEstandar_5);
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar();
    Jugador p7 = new Jugador("Casio", 29, _inscripcionEstandar_6);
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar();
    Jugador p8 = new Jugador("Alan", 30, _inscripcionEstandar_7);
    p1.setHandicap(3);
    p2.setHandicap(5);
    p3.setHandicap(6);
    p4.setHandicap(1);
    p5.setHandicap(8);
    p6.setHandicap(9);
    p7.setHandicap(7);
    p8.setHandicap(4);
    p1.inscribirse(partido);
    p2.inscribirse(partido);
    p3.inscribirse(partido);
    p4.inscribirse(partido);
    p5.inscribirse(partido);
    p6.inscribirse(partido);
    p7.inscribirse(partido);
    p8.inscribirse(partido);
    return partido;
  }
  
  public static Partido crearPartidoCon9Estandar() {
    Partido partido = Creaciones.crearPartidoCon8Estandar();
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador p9 = new Jugador("Carlos", 20, _inscripcionEstandar);
    p9.setHandicap(2);
    p9.inscribirse(partido);
    return partido;
  }
  
  public static Partido crearPartidoLlenoCon10Estandar() {
    Partido partido = Creaciones.crearPartidoCon9Estandar();
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador p10 = new Jugador("Lucas", 20, _inscripcionEstandar);
    p10.inscribirse(partido);
    return partido;
  }
}
