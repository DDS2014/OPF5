package domain;

import domain.ImposibleAnotarseException;
import domain.Participante;
import domain.Partido;
import domain.TipoDeInscripcion;

@SuppressWarnings("all")
public class InscripcionEstandar extends TipoDeInscripcion {
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
      boolean _haySolidarios = partido.haySolidarios();
      if (_haySolidarios) {
        Participante solidario = partido.getPrimerSolidario();
        partido.reemplazar(solidario, participante);
        return true;
      }
      ImposibleAnotarseException _imposibleAnotarseException = new ImposibleAnotarseException("No hay lugar en el partido", partido, participante);
      throw _imposibleAnotarseException;
    }
  }
}
