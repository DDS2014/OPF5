package domain;

import domain.ImposibleAnotarseException;
import domain.Participante;
import domain.Partido;
import domain.TipoDeInscripcion;

@SuppressWarnings("all")
public class InscripcionSolidaria extends TipoDeInscripcion {
  public boolean esSolidaria() {
    return true;
  }
  
  public boolean inscribirse(final Partido partido, final Participante participante) {
    boolean _inscribirse = super.inscribirse(partido, participante);
    if (_inscribirse) {
      return true;
    } else {
      boolean _hayCondicionales = partido.hayCondicionales();
      if (_hayCondicionales) {
        Participante condicional = partido.getPrimerCondicional();
        partido.reemplazar(condicional, participante);
        return true;
      }
      throw new ImposibleAnotarseException("No hay lugar en el partido", partido, participante);
    }
  }
}
