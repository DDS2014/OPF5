package domain.inscripcion;

import domain.Participante;
import domain.Partido;
import domain.excepciones.NoSeCumpleLaCondicionParaAnotarseException;
import domain.inscripcion.InscripcionEstandar;
import domain.inscripcion.InscripcionSolidaria;
import domain.inscripcion.TipoDeInscripcion;
import domain.inscripcion.condiciones.Condicion;

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
  
  public InscripcionCondicional(final Participante participante, final Condicion condicion) {
    super(participante);
    this.setCondicion(condicion);
  }
  
  public boolean inscribir(final Participante participante, final Partido partido) {
    boolean _xifexpression = false;
    Condicion _condicion = this.getCondicion();
    boolean _seCumple = _condicion.seCumple(partido);
    boolean _not = (!_seCumple);
    if (_not) {
      NoSeCumpleLaCondicionParaAnotarseException _noSeCumpleLaCondicionParaAnotarseException = new NoSeCumpleLaCondicionParaAnotarseException("No se cumplió la condición que exigía este participante para anotarse", partido, participante);
      throw _noSeCumpleLaCondicionParaAnotarseException;
    } else {
      boolean _inscribir = super.inscribir(participante, partido);
      _xifexpression = _inscribir;
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