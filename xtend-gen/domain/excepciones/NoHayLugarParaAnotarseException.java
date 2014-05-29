package domain.excepciones;

import domain.Jugador;
import domain.Partido;

@SuppressWarnings("all")
public class NoHayLugarParaAnotarseException extends RuntimeException {
  private Jugador participante;
  
  private Partido partido;
  
  public NoHayLugarParaAnotarseException(final String message, final Partido partido, final Jugador participante) {
    this.participante = participante;
    this.partido = partido;
  }
}
