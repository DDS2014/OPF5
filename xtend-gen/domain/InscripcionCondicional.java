package domain;

import domain.Condicion;
import domain.InscripcionEstandar;
import domain.InscripcionSolidaria;
import domain.Participante;
import domain.Partido;
import domain.TipoDeInscripcion;

@SuppressWarnings("all")
public class InscripcionCondicional extends TipoDeInscripcion {
  private int _prioridad = 3;
  
  public int getPrioridad() {
    return this._prioridad;
  }
  
  public void setPrioridad(final int prioridad) {
    this._prioridad = prioridad;
  }
  
  private Condicion _condicion;
  
  public Condicion getCondicion() {
    return this._condicion;
  }
  
  public void setCondicion(final Condicion condicion) {
    this._condicion = condicion;
  }
  
  public InscripcionCondicional(final Condicion condicion) {
    this.setCondicion(condicion);
  }
  
  public boolean inscribir(final Partido partido, final Participante participante) {
    boolean _xifexpression = false;
    boolean _hayLugaresLibres = partido.hayLugaresLibres();
    if (_hayLugaresLibres) {
      boolean _xifexpression_1 = false;
      Condicion _condicion = this.getCondicion();
      boolean _seCumple = _condicion.seCumple(partido);
      if (_seCumple) {
        boolean _confirmarAsistencia = partido.confirmarAsistencia(participante);
        _xifexpression_1 = _confirmarAsistencia;
      } else {
        return false;
      }
      _xifexpression = _xifexpression_1;
    } else {
      return super.inscribir(partido, participante);
    }
    return _xifexpression;
  }
  
  public boolean reemplazar(final Partido partido, final Participante entrante, final Participante saliente) {
    boolean _or = false;
    TipoDeInscripcion _modalidad = entrante.getModalidad();
    if ((_modalidad instanceof InscripcionEstandar)) {
      _or = true;
    } else {
      TipoDeInscripcion _modalidad_1 = entrante.getModalidad();
      _or = ((_modalidad instanceof InscripcionEstandar) || (_modalidad_1 instanceof InscripcionSolidaria));
    }
    if (_or) {
      return partido.reemplazar(entrante, saliente);
    } else {
      return false;
    }
  }
}
