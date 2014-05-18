package test;

import domain.Jugador;
import domain.Participante;
import domain.Partido;
import domain.inscripcion.InscripcionEstandar;
import java.util.Date;

@SuppressWarnings("all")
public class Creaciones {
  public static Partido crearPartidoCon8Estandar() {
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    Jugador _jugador = new Jugador("Pepe", 20);
    Participante _participante = new Participante(_jugador);
    Participante p1 = _participante;
    Jugador _jugador_1 = new Jugador("Luis", 35);
    Participante _participante_1 = new Participante(_jugador_1);
    Participante p2 = _participante_1;
    Jugador _jugador_2 = new Jugador("Juan", 27);
    Participante _participante_2 = new Participante(_jugador_2);
    Participante p3 = _participante_2;
    Jugador _jugador_3 = new Jugador("Alberto", 20);
    Participante _participante_3 = new Participante(_jugador_3);
    Participante p4 = _participante_3;
    Jugador _jugador_4 = new Jugador("Fabio", 20);
    Participante _participante_4 = new Participante(_jugador_4);
    Participante p5 = _participante_4;
    Jugador _jugador_5 = new Jugador("Alejo", 26);
    Participante _participante_5 = new Participante(_jugador_5);
    Participante p6 = _participante_5;
    Jugador _jugador_6 = new Jugador("Casio", 29);
    Participante _participante_6 = new Participante(_jugador_6);
    Participante p7 = _participante_6;
    Jugador _jugador_7 = new Jugador("Alan", 30);
    Participante _participante_7 = new Participante(_jugador_7);
    Participante p8 = _participante_7;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(p1);
    partido.inscribir(_inscripcionEstandar);
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar(p2);
    partido.inscribir(_inscripcionEstandar_1);
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar(p3);
    partido.inscribir(_inscripcionEstandar_2);
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar(p4);
    partido.inscribir(_inscripcionEstandar_3);
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar(p5);
    partido.inscribir(_inscripcionEstandar_4);
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar(p6);
    partido.inscribir(_inscripcionEstandar_5);
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar(p7);
    partido.inscribir(_inscripcionEstandar_6);
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar(p8);
    partido.inscribir(_inscripcionEstandar_7);
    return partido;
  }
  
  public static Partido crearPartidoCon9Estandar() {
    Partido partido = Creaciones.crearPartidoCon8Estandar();
    Jugador _jugador = new Jugador("Carlos", 20);
    Participante _participante = new Participante(_jugador);
    Participante p9 = _participante;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(p9);
    partido.inscribir(_inscripcionEstandar);
    return partido;
  }
  
  public static Partido crearPartidoLlenoCon10Estandar() {
    Partido partido = Creaciones.crearPartidoCon9Estandar();
    Jugador _jugador = new Jugador("Lucas", 20);
    Participante _participante = new Participante(_jugador);
    Participante p10 = _participante;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(p10);
    partido.inscribir(_inscripcionEstandar);
    return partido;
  }
}
