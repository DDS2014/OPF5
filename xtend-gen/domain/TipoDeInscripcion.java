package domain;

import domain.Participante;
import domain.Partido;

@SuppressWarnings("all")
public abstract class TipoDeInscripcion {
  public void inscribirse(final Partido partido, final Participante participante) {
    boolean _hayLugaresLibres = partido.hayLugaresLibres();
    boolean _equals = (_hayLugaresLibres == true);
    if (_equals) {
      partido.confirmarAsistencia(participante);
    }
  }
}
