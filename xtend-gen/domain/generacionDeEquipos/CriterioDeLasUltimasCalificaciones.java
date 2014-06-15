package domain.generacionDeEquipos;

import domain.Jugador;
import domain.calificaciones.Calificacion;
import domain.excepciones.ImposibleEvaluarException;
import domain.generacionDeEquipos.Criterio;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;

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
    ArrayList<Calificacion> _calificaciones = jugador.getCalificaciones();
    int _length = ((Object[])Conversions.unwrapArray(_calificaciones, Object.class)).length;
    boolean _lessThan = (_length < this.cantidadDeCalificaciones);
    if (_lessThan) {
      ImposibleEvaluarException _imposibleEvaluarException = new ImposibleEvaluarException("El jugador tiene menos calificaciones de las que se pidieron tener en cuenta");
      throw _imposibleEvaluarException;
    }
    ArrayList<Calificacion> _calificaciones_1 = jugador.getCalificaciones();
    List<Calificacion> calificacionesAConsiderar = _calificaciones_1.subList(0, this.cantidadDeCalificaciones);
    return this.promediarCalificaciones(calificacionesAConsiderar);
  }
}
