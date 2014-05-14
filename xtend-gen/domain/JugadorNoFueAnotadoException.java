package domain;

import domain.Participante;
import domain.Partido;

@SuppressWarnings("all")
public class JugadorNoFueAnotadoException extends RuntimeException {
  private Participante participante;
  
  private Partido partido;
  
  public JugadorNoFueAnotadoException(final String message, final Partido partido, final Participante participante) {
    this.participante = participante;
    this.partido = partido;
  }
}
