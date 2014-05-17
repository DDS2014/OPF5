package test;

import domain.InscripcionEstandar;
import domain.Jugador;
import domain.Participante;
import domain.Partido;
import java.util.Date;

@SuppressWarnings("all")
public class Creaciones {
  public static Partido crearPartidoLlenoCon10Estandar() {
    Date _date = new Date();
    Partido partidoEstandar = new Partido(_date);
    Jugador _jugador = new Jugador("Pepe", 20);
    Participante part1 = new Participante(_jugador);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(part1);
    part1.setModalidad(_inscripcionEstandar);
    Jugador _jugador_1 = new Jugador("Luis", 35);
    Participante part2 = new Participante(_jugador_1);
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar(part2);
    part2.setModalidad(_inscripcionEstandar_1);
    Jugador _jugador_2 = new Jugador("Juan", 27);
    Participante part3 = new Participante(_jugador_2);
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar(part3);
    part3.setModalidad(_inscripcionEstandar_2);
    Jugador _jugador_3 = new Jugador("Alberto", 20);
    Participante part4 = new Participante(_jugador_3);
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar(part4);
    part4.setModalidad(_inscripcionEstandar_3);
    Jugador _jugador_4 = new Jugador("Fabio", 20);
    Participante part5 = new Participante(_jugador_4);
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar(part5);
    part5.setModalidad(_inscripcionEstandar_4);
    Jugador _jugador_5 = new Jugador("Alejo", 26);
    Participante part6 = new Participante(_jugador_5);
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar(part6);
    part6.setModalidad(_inscripcionEstandar_5);
    Jugador _jugador_6 = new Jugador("Casio", 29);
    Participante part7 = new Participante(_jugador_6);
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar(part7);
    part7.setModalidad(_inscripcionEstandar_6);
    Jugador _jugador_7 = new Jugador("Alan", 30);
    Participante part8 = new Participante(_jugador_7);
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar(part8);
    part8.setModalidad(_inscripcionEstandar_7);
    Jugador _jugador_8 = new Jugador("Carlos", 20);
    Participante part9 = new Participante(_jugador_8);
    InscripcionEstandar _inscripcionEstandar_8 = new InscripcionEstandar(part9);
    part9.setModalidad(_inscripcionEstandar_8);
    Jugador _jugador_9 = new Jugador("Lucas", 20);
    Participante part10 = new Participante(_jugador_9);
    InscripcionEstandar _inscripcionEstandar_9 = new InscripcionEstandar(part10);
    part10.setModalidad(_inscripcionEstandar_9);
    part1.inscribirse(partidoEstandar);
    part2.inscribirse(partidoEstandar);
    part3.inscribirse(partidoEstandar);
    part4.inscribirse(partidoEstandar);
    part5.inscribirse(partidoEstandar);
    part6.inscribirse(partidoEstandar);
    part7.inscribirse(partidoEstandar);
    part8.inscribirse(partidoEstandar);
    part9.inscribirse(partidoEstandar);
    part10.inscribirse(partidoEstandar);
    return partidoEstandar;
  }
  
  public static Partido crearPartidoCon9Estandar() {
    Date _date = new Date();
    Partido partido = new Partido(_date);
    Jugador _jugador = new Jugador("Pepe", 20);
    Participante part1 = new Participante(_jugador);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(part1);
    part1.setModalidad(_inscripcionEstandar);
    Jugador _jugador_1 = new Jugador("Luis", 35);
    Participante part2 = new Participante(_jugador_1);
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar(part2);
    part2.setModalidad(_inscripcionEstandar_1);
    Jugador _jugador_2 = new Jugador("Juan", 27);
    Participante part3 = new Participante(_jugador_2);
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar(part3);
    part3.setModalidad(_inscripcionEstandar_2);
    Jugador _jugador_3 = new Jugador("Alberto", 20);
    Participante part4 = new Participante(_jugador_3);
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar(part4);
    part4.setModalidad(_inscripcionEstandar_3);
    Jugador _jugador_4 = new Jugador("Fabio", 20);
    Participante part5 = new Participante(_jugador_4);
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar(part5);
    part5.setModalidad(_inscripcionEstandar_4);
    Jugador _jugador_5 = new Jugador("Alejo", 26);
    Participante part6 = new Participante(_jugador_5);
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar(part6);
    part6.setModalidad(_inscripcionEstandar_5);
    Jugador _jugador_6 = new Jugador("Casio", 29);
    Participante part7 = new Participante(_jugador_6);
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar(part7);
    part7.setModalidad(_inscripcionEstandar_6);
    Jugador _jugador_7 = new Jugador("Alan", 30);
    Participante part8 = new Participante(_jugador_7);
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar(part8);
    part8.setModalidad(_inscripcionEstandar_7);
    Jugador _jugador_8 = new Jugador("Carlos", 20);
    Participante part9 = new Participante(_jugador_8);
    InscripcionEstandar _inscripcionEstandar_8 = new InscripcionEstandar(part9);
    part9.setModalidad(_inscripcionEstandar_8);
    part1.inscribirse(partido);
    part2.inscribirse(partido);
    part3.inscribirse(partido);
    part4.inscribirse(partido);
    part5.inscribirse(partido);
    part6.inscribirse(partido);
    part7.inscribirse(partido);
    part8.inscribirse(partido);
    part9.inscribirse(partido);
    return partido;
  }
  
  public static Partido crearPartidoCon8Estandar() {
    Date _date = new Date();
    Partido partido = new Partido(_date);
    Jugador _jugador = new Jugador("Pepe", 20);
    Participante part1 = new Participante(_jugador);
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(part1);
    part1.setModalidad(_inscripcionEstandar);
    Jugador _jugador_1 = new Jugador("Luis", 35);
    Participante part2 = new Participante(_jugador_1);
    InscripcionEstandar _inscripcionEstandar_1 = new InscripcionEstandar(part2);
    part2.setModalidad(_inscripcionEstandar_1);
    Jugador _jugador_2 = new Jugador("Juan", 27);
    Participante part3 = new Participante(_jugador_2);
    InscripcionEstandar _inscripcionEstandar_2 = new InscripcionEstandar(part3);
    part3.setModalidad(_inscripcionEstandar_2);
    Jugador _jugador_3 = new Jugador("Alberto", 20);
    Participante part4 = new Participante(_jugador_3);
    InscripcionEstandar _inscripcionEstandar_3 = new InscripcionEstandar(part4);
    part4.setModalidad(_inscripcionEstandar_3);
    Jugador _jugador_4 = new Jugador("Fabio", 20);
    Participante part5 = new Participante(_jugador_4);
    InscripcionEstandar _inscripcionEstandar_4 = new InscripcionEstandar(part5);
    part5.setModalidad(_inscripcionEstandar_4);
    Jugador _jugador_5 = new Jugador("Alejo", 26);
    Participante part6 = new Participante(_jugador_5);
    InscripcionEstandar _inscripcionEstandar_5 = new InscripcionEstandar(part6);
    part6.setModalidad(_inscripcionEstandar_5);
    Jugador _jugador_6 = new Jugador("Casio", 29);
    Participante part7 = new Participante(_jugador_6);
    InscripcionEstandar _inscripcionEstandar_6 = new InscripcionEstandar(part7);
    part7.setModalidad(_inscripcionEstandar_6);
    Jugador _jugador_7 = new Jugador("Alan", 30);
    Participante part8 = new Participante(_jugador_7);
    InscripcionEstandar _inscripcionEstandar_7 = new InscripcionEstandar(part8);
    part8.setModalidad(_inscripcionEstandar_7);
    part1.inscribirse(partido);
    part2.inscribirse(partido);
    part3.inscribirse(partido);
    part4.inscribirse(partido);
    part5.inscribirse(partido);
    part6.inscribirse(partido);
    part7.inscribirse(partido);
    part8.inscribirse(partido);
    return partido;
  }
}
