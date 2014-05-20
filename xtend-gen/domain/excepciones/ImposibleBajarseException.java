package domain.excepciones;

import domain.EventoDeportivo;
import domain.Participante;

@SuppressWarnings("all")
public class ImposibleBajarseException extends RuntimeException {
  private Participante participante;
  
  private EventoDeportivo partido;
  
  public ImposibleBajarseException(final String message, final EventoDeportivo partido, final Participante participante) {
    this.participante = participante;
    this.partido = partido;
  }
}
