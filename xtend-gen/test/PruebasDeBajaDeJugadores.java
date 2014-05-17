package test;

import domain.Infraccion;
import domain.InscripcionEstandar;
import domain.Jugador;
import domain.Participante;
import domain.Partido;
import java.util.Date;
import java.util.HashSet;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class PruebasDeBajaDeJugadores {
  @Test
  public void cuandoUnJugadorSeBajaDejaDeEstarInscripto() {
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    Jugador _jugador = new Jugador("Juan", 18);
    Jugador jugadorJuan = _jugador;
    Participante _participante = new Participante(jugadorJuan);
    Participante partJuan = _participante;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(partJuan);
    partJuan.setModalidad(_inscripcionEstandar);
    partJuan.inscribirse(partido);
    partJuan.bajarse(partido);
    boolean _estaInscripto = partido.estaInscripto(jugadorJuan);
    Assert.assertFalse(_estaInscripto);
  }
  
  @Test
  public void cuandoUnJugadorSeBajaYNoDesignaUnReemplazanteSeLeGeneraUnaInfraccion() {
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    Partido partido = _partido;
    Jugador _jugador = new Jugador("Juan", 18);
    Jugador jugadorJuan = _jugador;
    Participante _participante = new Participante(jugadorJuan);
    Participante partJuan = _participante;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(partJuan);
    partJuan.setModalidad(_inscripcionEstandar);
    partJuan.inscribirse(partido);
    partJuan.bajarse(partido);
    HashSet<Infraccion> _infracciones = jugadorJuan.getInfracciones();
    int _length = ((Object[])Conversions.unwrapArray(_infracciones, Object.class)).length;
    boolean _equals = (_length == 1);
    Assert.assertTrue(_equals);
  }
}
