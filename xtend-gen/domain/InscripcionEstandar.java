package domain;

import domain.Participante;
import domain.Partido;
import domain.TipoDeInscripcion;

@SuppressWarnings("all")
public class InscripcionEstandar extends TipoDeInscripcion {
  public void inscribirse(final Partido partido, final Participante participante) {
    super.inscribirse(partido, participante);
    boolean _hayCondicionales = partido.hayCondicionales();
    if (_hayCondicionales) {
      Participante condicional = partido.getPrimerCondicional();
      partido.reemplazar(condicional, participante);
    }
  }
}
