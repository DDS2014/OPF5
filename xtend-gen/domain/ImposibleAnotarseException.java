package domain;

import domain.Participante;
import domain.Partido;

@SuppressWarnings("all")
public class ImposibleAnotarseException extends RuntimeException {
  private Participante participante;
  
  private Partido partido;
  
  public ImposibleAnotarseException(final String message, final Partido partido, final Participante participante) {
    this.participante = participante;
    this.partido = partido;
  }
}
