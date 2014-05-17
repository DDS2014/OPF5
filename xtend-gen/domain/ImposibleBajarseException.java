package domain;

import domain.Participante;
import domain.Partido;

@SuppressWarnings("all")
public class ImposibleBajarseException extends RuntimeException {
  private Participante participante;
  
  private Partido partido;
  
  public ImposibleBajarseException(final String message, final Partido partido, final Participante participante) {
    this.participante = participante;
    this.partido = partido;
  }
}
