package domain.inscripcion;

import domain.Participante;
import domain.Partido;
import domain.inscripcion.TipoDeInscripcion;

@SuppressWarnings("all")
public class InscripcionEstandar extends TipoDeInscripcion {
  private int _prioridad = 1;
  
  public int getPrioridad() {
    return this._prioridad;
  }
  
  public void setPrioridad(final int prioridad) {
    this._prioridad = prioridad;
  }
  
  public InscripcionEstandar(final Participante participante) {
    super(participante);
  }
  
  public boolean reemplazar(final Partido partido, final Participante entrante, final Participante saliente) {
    return false;
  }
}
