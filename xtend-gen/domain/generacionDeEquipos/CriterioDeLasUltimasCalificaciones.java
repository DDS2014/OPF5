package domain.generacionDeEquipos;

import domain.Jugador;
import domain.generacionDeEquipos.Criterio;

@SuppressWarnings("all")
public class CriterioDeLasUltimasCalificaciones extends Criterio {
  private int cantidadDeCalificaciones;
  
  public CriterioDeLasUltimasCalificaciones(final int cantidadDeCalificaciones) {
    boolean _lessThan = (cantidadDeCalificaciones < 0);
    if (_lessThan) {
      RuntimeException _runtimeException = new RuntimeException("Debe especificar un número positivo de calificaciones a tener en cuenta");
      throw _runtimeException;
    }
    this.cantidadDeCalificaciones = cantidadDeCalificaciones;
  }
  
  public double evaluarJugador(final Jugador jugador) {
    return 2.0;
  }
}
