package domain.generacionDeEquipos.criteriosDeEvaluacion;

import domain.Jugador;
import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class CriterioCompuesto extends Criterio {
  private ArrayList<Criterio> subCriterios;
  
  public CriterioCompuesto() {
    ArrayList<Criterio> _arrayList = new ArrayList<Criterio>();
    this.subCriterios = _arrayList;
  }
  
  public boolean agregarSubcriterio(final Criterio subcriterio) {
    boolean _add = this.subCriterios.add(subcriterio);
    return _add;
  }
  
  public double evaluarJugador(final Jugador jugador) {
    double suma = ((double) 0);
    for (final Criterio subcriterio : this.subCriterios) {
      double _evaluarJugador = subcriterio.evaluarJugador(jugador);
      double _plus = (suma + _evaluarJugador);
      suma = _plus;
    }
    int _length = ((Object[])Conversions.unwrapArray(this.subCriterios, Object.class)).length;
    return (suma / _length);
  }
}
