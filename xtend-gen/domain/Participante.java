package domain;

import domain.Jugador;
import domain.Partido;
import domain.TipoDeInscripcion;

@SuppressWarnings("all")
public class Participante {
  private Jugador _jugador;
  
  public Jugador getJugador() {
    return this._jugador;
  }
  
  public void setJugador(final Jugador jugador) {
    this._jugador = jugador;
  }
  
  private TipoDeInscripcion modalidad;
  
  public Participante(final Jugador jugador, final TipoDeInscripcion modalidad) {
    this.setJugador(jugador);
    this.modalidad = modalidad;
  }
  
  public void inscribirse(final Partido partido) {
    this.modalidad.inscribirse(partido, this);
  }
}
