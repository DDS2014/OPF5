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
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class PruebasDeBajaDeJugadores {
  private Partido partido;
  
  private Jugador jugadorJuan;
  
  private Participante partJuan;
  
  @Before
  public void setup() {
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    this.partido = _partido;
    Jugador _jugador = new Jugador("Juan", 18);
    this.jugadorJuan = _jugador;
    Participante _participante = new Participante(this.jugadorJuan);
    this.partJuan = _participante;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar(this.partJuan);
    this.partJuan.setModalidad(_inscripcionEstandar);
    this.partJuan.inscribirse(this.partido);
  }
  
  @Test
  public void cuandoUnJugadorSeBajaDejaDeEstarInscripto() {
    this.partJuan.bajarse(this.partido);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugadorJuan);
    Assert.assertFalse(_estaInscripto);
  }
  
  @Test
  public void cuandoUnJugadorSeBajaYNoDesignaUnReemplazanteSeLeGeneraUnaInfraccion() {
    this.partJuan.bajarse(this.partido);
    HashSet<Infraccion> _infracciones = this.jugadorJuan.getInfracciones();
    int _length = ((Object[])Conversions.unwrapArray(_infracciones, Object.class)).length;
    boolean _equals = (_length == 1);
    Assert.assertTrue(_equals);
  }
}
