package domain.inscripcion;

import domain.Jugador;
import domain.Partido;
import domain.inscripcion.InscripcionEstandar;
import domain.inscripcion.TipoDeInscripcion;

@SuppressWarnings("all")
public class InscripcionSolidaria extends TipoDeInscripcion {
  private int _prioridad = 2;
  
  public int getPrioridad() {
    return this._prioridad;
  }
  
  public void setPrioridad(final int prioridad) {
    this._prioridad = prioridad;
  }
  
  public boolean reemplazar(final Partido partido, final Jugador entrante, final Jugador saliente) {
    TipoDeInscripcion _modalidad = entrante.getModalidad();
    if ((_modalidad instanceof InscripcionEstandar)) {
      partido.reemplazar(entrante, saliente);
      return true;
    } else {
      return false;
    }
  }
}
