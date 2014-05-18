package domain.excepciones;

import domain.Participante;
import domain.Partido;

@SuppressWarnings("all")
public class NoHayLugarParaAnotarseException extends RuntimeException {
  private Participante participante;
  
  private Partido partido;
  
  public NoHayLugarParaAnotarseException(final String message, final Partido partido, final Participante participante) {
    this.participante = participante;
    this.partido = partido;
  }
}
