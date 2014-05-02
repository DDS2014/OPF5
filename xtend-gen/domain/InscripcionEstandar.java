package domain;

import domain.Participante;
import domain.Partido;
import domain.TipoDeInscripcion;

@SuppressWarnings("all")
public class InscripcionEstandar extends TipoDeInscripcion {
  public boolean reemplazar(final Partido partido, final Participante entrante, final Participante saliente) {
    return false;
  }
}
