package domain;

import domain.Condicion_LimiteDeEdad;
import domain.InscripcionCondicional;
import domain.InscripcionEstandar;
import domain.InscripcionSolidaria;
import domain.Jugador;
import domain.Participante;
import domain.Partido;
import domain.TipoDeInscripcion;
import java.util.Date;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@SuppressWarnings("all")
public class Tester {
  public static void main(final String[] args) {
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    final Partido partido = _partido;
    Jugador _jugador = new Jugador("Jugador1", 25);
    final Jugador j1 = _jugador;
    Jugador _jugador_1 = new Jugador("Jugador2", 25);
    final Jugador j2 = _jugador_1;
    Jugador _jugador_2 = new Jugador("Jugador3", 25);
    final Jugador j3 = _jugador_2;
    Jugador _jugador_3 = new Jugador("Jugador4", 25);
    final Jugador j4 = _jugador_3;
    Jugador _jugador_4 = new Jugador("Jugador5", 25);
    final Jugador j5 = _jugador_4;
    Jugador _jugador_5 = new Jugador("Jugador6", 20);
    final Jugador j6 = _jugador_5;
    Jugador _jugador_6 = new Jugador("Jugador7", 20);
    final Jugador j7 = _jugador_6;
    Jugador _jugador_7 = new Jugador("Jugador8", 20);
    final Jugador j8 = _jugador_7;
    Jugador _jugador_8 = new Jugador("Jugador9", 20);
    final Jugador j9 = _jugador_8;
    Jugador _jugador_9 = new Jugador("Jugador10", 20);
    final Jugador j10 = _jugador_9;
    Jugador _jugador_10 = new Jugador("Jugador11", 20);
    final Jugador j11 = _jugador_10;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    final InscripcionEstandar tEstandar = _inscripcionEstandar;
    InscripcionSolidaria _inscripcionSolidaria = new InscripcionSolidaria();
    final InscripcionSolidaria tSolidaria = _inscripcionSolidaria;
    Condicion_LimiteDeEdad _condicion_LimiteDeEdad = new Condicion_LimiteDeEdad(23, 5, true, true);
    final Condicion_LimiteDeEdad condicion = _condicion_LimiteDeEdad;
    InscripcionCondicional _inscripcionCondicional = new InscripcionCondicional(condicion);
    final InscripcionCondicional tCondicional = _inscripcionCondicional;
    partido.inscribir(j1, tEstandar);
    partido.inscribir(j2, tEstandar);
    partido.inscribir(j3, tEstandar);
    partido.inscribir(j4, tSolidaria);
    partido.inscribir(j5, tEstandar);
    partido.inscribir(j6, tEstandar);
    partido.inscribir(j7, tEstandar);
    partido.inscribir(j8, tSolidaria);
    partido.inscribir(j9, tSolidaria);
    partido.inscribir(j10, tEstandar);
    List<Participante> _participantesConfirmados = partido.getParticipantesConfirmados();
    int _size = _participantesConfirmados.size();
    int _minus = (_size - 1);
    IntegerRange _upTo = new IntegerRange(0, _minus);
    for (final int i : _upTo) {
      {
        List<Jugador> _jugadoresConfirmados = partido.jugadoresConfirmados();
        Jugador j = _jugadoresConfirmados.get(i);
        List<Participante> _participantesConfirmados_1 = partido.getParticipantesConfirmados();
        Participante p = _participantesConfirmados_1.get(i);
        String _nombre = j.getNombre();
        String _plus = (_nombre + " ;Fecha: ");
        Date _fechaInscripcion = p.getFechaInscripcion();
        String _plus_1 = (_plus + _fechaInscripcion);
        String _plus_2 = (_plus_1 + " ;Prioridad: ");
        TipoDeInscripcion _modalidad = p.getModalidad();
        int _prioridad = _modalidad.getPrioridad();
        String _plus_3 = (_plus_2 + Integer.valueOf(_prioridad));
        InputOutput.<String>println(_plus_3);
      }
    }
  }
}
