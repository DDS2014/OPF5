package domain.generacionDeEquipos;

import domain.Jugador;
import domain.generacionDeEquipos.Criterio;
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
    return this.subCriterios.add(subcriterio);
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
