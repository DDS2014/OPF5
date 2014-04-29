package domain;

import domain.ImposibleAnotarseException;
import domain.Participante;
import domain.Partido;
import domain.TipoDeInscripcion;

@SuppressWarnings("all")
public class InscripcionEstandar extends TipoDeInscripcion {
  public void inscribirse(final Partido partido, final Participante participante) {
    super.inscribirse(partido, participante);
    boolean _hayLugaresLibres = partido.hayLugaresLibres();
    boolean _equals = (_hayLugaresLibres == false);
    if (_equals) {
      boolean _hayCondicionales = partido.hayCondicionales();
      if (_hayCondicionales) {
        Participante condicional = partido.getPrimerCondicional();
        partido.reemplazar(condicional, participante);
        return;
      }
      boolean _haySolidarios = partido.haySolidarios();
      if (_haySolidarios) {
        Participante solidario = partido.getPrimerSolidario();
        partido.reemplazar(solidario, participante);
        return;
      }
      throw new ImposibleAnotarseException("No hay lugar en el partido", partido, participante);
    }
  }
}
