package domain.generacionDeEquipos.criteriosDeEvaluacion;

import com.google.common.base.Objects;
import domain.Jugador;
import domain.Partido;
import domain.calificaciones.Calificacion;
import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio;
import domain.sugerencias.Comunidad;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class CriterioDelUltimoPartido extends Criterio {
  private Comunidad comunidad;
  
  public CriterioDelUltimoPartido(final Comunidad comunidad) {
    this.comunidad = comunidad;
  }
  
  public double evaluarJugador(final Jugador jugador) {
    ArrayList<Calificacion> calificacionesAConsiderar = new ArrayList<Calificacion>();
    ArrayList<Calificacion> _calificaciones = jugador.getCalificaciones();
    final Function1<Calificacion, Boolean> _function = new Function1<Calificacion, Boolean>() {
      public Boolean apply(final Calificacion calif) {
        Partido _partido = calif.getPartido();
        Partido _ultimoPartido = CriterioDelUltimoPartido.this.comunidad.ultimoPartido();
        return Boolean.valueOf(Objects.equal(_partido, _ultimoPartido));
      }
    };
    Iterable<Calificacion> iterableCalificaciones = IterableExtensions.<Calificacion>filter(_calificaciones, _function);
    for (final Calificacion calificacion : iterableCalificaciones) {
      calificacionesAConsiderar.add(calificacion);
    }
    return this.promediarCalificaciones(calificacionesAConsiderar);
  }
}
