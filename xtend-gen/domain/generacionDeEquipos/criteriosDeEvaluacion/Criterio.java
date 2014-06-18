package domain.generacionDeEquipos.criteriosDeEvaluacion;

import domain.Jugador;
import domain.Partido;
import domain.calificaciones.Calificacion;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class Criterio implements Comparator<Jugador> {
  public abstract double evaluarJugador(final Jugador jugador);
  
  public double promediarCalificaciones(final Collection<Calificacion> calificacionesAPromediar) {
    double suma = ((double) 0);
    int cantidadAPromediar = ((Object[])Conversions.unwrapArray(calificacionesAPromediar, Object.class)).length;
    final Function1<Calificacion,Integer> _function = new Function1<Calificacion,Integer>() {
      public Integer apply(final Calificacion calif) {
        int _puntaje = calif.getPuntaje();
        return Integer.valueOf(_puntaje);
      }
    };
    Iterable<Integer> puntajesAPromediar = IterableExtensions.<Calificacion, Integer>map(calificacionesAPromediar, _function);
    for (final Integer puntaje : puntajesAPromediar) {
      double _plus = (suma + (puntaje).intValue());
      suma = _plus;
    }
    return (suma / cantidadAPromediar);
  }
  
  public int compare(final Jugador arg0, final Jugador arg1) {
    double _evaluarJugador = this.evaluarJugador(arg0);
    double _evaluarJugador_1 = this.evaluarJugador(arg1);
    boolean _greaterThan = (_evaluarJugador > _evaluarJugador_1);
    if (_greaterThan) {
      return (-1);
    } else {
      return 1;
    }
  }
  
  public void ordenarJugadores(final Partido partido) {
    List<Jugador> _jugadoresConfirmados = partido.getJugadoresConfirmados();
    Collections.<Jugador>sort(_jugadoresConfirmados, this);
  }
}
