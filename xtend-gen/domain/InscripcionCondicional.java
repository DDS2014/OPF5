package domain;

import domain.ImposibleAnotarseException;
import domain.Participante;
import domain.Partido;
import domain.TipoDeInscripcion;

@SuppressWarnings("all")
public class InscripcionCondicional extends TipoDeInscripcion {
  public boolean esCondicional() {
    return true;
  }
  
  public boolean inscribirse(final Partido partido, final Participante participante) {
    boolean _inscribirse = super.inscribirse(partido, participante);
    if (_inscribirse) {
      return true;
    } else {
      throw new ImposibleAnotarseException("No hay lugar en el partido", partido, participante);
    }
  }
}
