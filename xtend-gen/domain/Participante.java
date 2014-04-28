package domain;

import domain.Jugador;
import domain.Partido;
import domain.TipoDeInscripcion;

@SuppressWarnings("all")
public class Participante {
  private Jugador jugador;
  
  private TipoDeInscripcion modalidad;
  
  public Participante(final Jugador jugador, final TipoDeInscripcion modalidad) {
    this.jugador = jugador;
    this.modalidad = modalidad;
  }
  
  public void inscribirse(final Partido partido) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
}
