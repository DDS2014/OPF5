package test;

import domain.Jugador;
import domain.Partido;
import domain.inscripcion.InscripcionEstandar;
import java.util.Date;

@SuppressWarnings("all")
public class Creaciones {
  public static Partido crearPartidoCon8Estandar() {
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador _jugador = new Jugador("Pepe", 20, _inscripcionEstandar);
    Jugador p1 = _jugador;
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar();
    Jugador _jugador_1 = new Jugador("Luis", 35, _inscripcionEstandar_1);
    Jugador p2 = _jugador_1;
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar();
    Jugador _jugador_2 = new Jugador("Juan", 27, _inscripcionEstandar_2);
    Jugador p3 = _jugador_2;
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar();
    Jugador _jugador_3 = new Jugador("Alberto", 20, _inscripcionEstandar_3);
    Jugador p4 = _jugador_3;
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar();
    Jugador _jugador_4 = new Jugador("Fabio", 20, _inscripcionEstandar_4);
    Jugador p5 = _jugador_4;
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar();
    Jugador _jugador_5 = new Jugador("Alejo", 26, _inscripcionEstandar_5);
    Jugador p6 = _jugador_5;
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar();
    Jugador _jugador_6 = new Jugador("Casio", 29, _inscripcionEstandar_6);
    Jugador p7 = _jugador_6;
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar();
    Jugador _jugador_7 = new Jugador("Alan", 30, _inscripcionEstandar_7);
    Jugador p8 = _jugador_7;
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
    Jugador _jugador = new Jugador("Carlos", 20, _inscripcionEstandar);
    Jugador p9 = _jugador;
    p9.inscribirse(partido);
    return partido;
  }
  
  public static Partido crearPartidoLlenoCon10Estandar() {
    Partido partido = Creaciones.crearPartidoCon9Estandar();
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador _jugador = new Jugador("Lucas", 20, _inscripcionEstandar);
    Jugador p10 = _jugador;
    p10.inscribirse(partido);
    return partido;
  }
}
