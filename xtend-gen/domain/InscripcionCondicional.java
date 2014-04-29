package domain;

import domain.ImposibleAnotarseException;
import domain.Participante;
import domain.Partido;
import domain.TipoDeInscripcion;

@SuppressWarnings("all")
public class InscripcionCondicional extends TipoDeInscripcion {
  public void inscribirse(final Partido partido, final Participante participante) {
    super.inscribirse(partido, participante);
    boolean _hayLugaresLibres = partido.hayLugaresLibres();
    boolean _equals = (_hayLugaresLibres == false);
    if (_equals) {
      throw new ImposibleAnotarseException("No hay lugar en el partido", partido, participante);
    }
  }
}
