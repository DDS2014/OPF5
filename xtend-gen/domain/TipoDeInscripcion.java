package domain;

import domain.Participante;
import domain.Partido;

@SuppressWarnings("all")
public abstract class TipoDeInscripcion {
  public Boolean inscribirse(final Partido partido, final Participante participante) {
    Boolean _xifexpression = null;
    boolean _hayLugaresLibres = partido.hayLugaresLibres();
    boolean _equals = (_hayLugaresLibres == true);
    if (_equals) {
      boolean _confirmarAsistencia = partido.confirmarAsistencia(participante);
      _xifexpression = Boolean.valueOf(_confirmarAsistencia);
    }
    return _xifexpression;
  }
}
