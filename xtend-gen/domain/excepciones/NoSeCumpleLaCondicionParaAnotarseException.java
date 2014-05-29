package domain.excepciones;

import domain.Jugador;
import domain.Partido;

@SuppressWarnings("all")
public class NoSeCumpleLaCondicionParaAnotarseException extends RuntimeException {
  private Jugador participante;
  
  private Partido partido;
  
  public NoSeCumpleLaCondicionParaAnotarseException(final String message, final Partido partido, final Jugador participante) {
    this.participante = participante;
    this.partido = partido;
  }
}
