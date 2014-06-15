package domain.generacionDeEquipos;

import domain.Jugador;
import domain.calificaciones.Calificacion;
import java.util.HashSet;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class Criterio {
  public abstract double evaluarJugador(final Jugador jugador);
  
  public double promediarCalificaciones(final HashSet<Calificacion> calificacionesAPromediar) {
    int suma = 0;
    final Function1<Calificacion,Integer> _function = new Function1<Calificacion,Integer>() {
      public Integer apply(final Calificacion calif) {
        int _puntaje = calif.getPuntaje();
        return Integer.valueOf(_puntaje);
      }
    };
    Iterable<Integer> puntajesAPromediar = IterableExtensions.<Calificacion, Integer>map(calificacionesAPromediar, _function);
    for (final Integer puntaje : puntajesAPromediar) {
      int _plus = (suma + (puntaje).intValue());
      suma = _plus;
    }
    return suma;
  }
}
