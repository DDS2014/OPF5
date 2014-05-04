package domain;

import domain.InscripcionEstandar;
import domain.Participante;
import domain.Partido;
import domain.TipoDeInscripcion;

@SuppressWarnings("all")
public class InscripcionSolidaria extends TipoDeInscripcion {
  private int _prioridad = 2;
  
  public int getPrioridad() {
    return this._prioridad;
  }
  
  public void setPrioridad(final int prioridad) {
    this._prioridad = prioridad;
  }
  
  public InscripcionSolidaria(final Participante participante) {
    super(participante);
  }
  
  public boolean reemplazar(final Partido partido, final Participante entrante, final Participante saliente) {
    TipoDeInscripcion _modalidad = entrante.getModalidad();
    if ((_modalidad instanceof InscripcionEstandar)) {
      return partido.reemplazar(entrante, saliente);
    } else {
      return false;
    }
  }
}
