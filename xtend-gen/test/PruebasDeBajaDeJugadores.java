package test;

import domain.Jugador;
import domain.Partido;
import domain.infracciones.Infraccion;
import domain.inscripcion.InscripcionEstandar;
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
  
  @Before
  public void setup() {
    Date _date = new Date();
    Partido _partido = new Partido(_date);
    this.partido = _partido;
    InscripcionEstandar _inscripcionEstandar = new InscripcionEstandar();
    Jugador _jugador = new Jugador("Juan", 18, _inscripcionEstandar);
    this.jugadorJuan = _jugador;
    this.jugadorJuan.inscribirse(this.partido);
  }
  
  @Test
  public void cuandoUnJugadorSeBajaDejaDeEstarInscripto() {
    this.jugadorJuan.bajarse(this.partido);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugadorJuan);
    Assert.assertFalse(_estaInscripto);
  }
  
  @Test
  public void cuandoUnJugadorSeBajaYNoDesignaUnReemplazanteSeLeGeneraUnaInfraccion() {
    this.jugadorJuan.bajarse(this.partido);
    HashSet<Infraccion> _infracciones = this.jugadorJuan.getInfracciones();
    int _length = ((Object[])Conversions.unwrapArray(_infracciones, Object.class)).length;
    boolean _equals = (_length == 1);
    Assert.assertTrue(_equals);
  }
}
