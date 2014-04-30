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
  
  private TipoDeInscripcion _modalidad;
  
  public TipoDeInscripcion getModalidad() {
    return this._modalidad;
  }
  
  public void setModalidad(final TipoDeInscripcion modalidad) {
    this._modalidad = modalidad;
  }
  
  public Participante(final Jugador jugador, final TipoDeInscripcion modalidad) {
    this.setJugador(jugador);
    this.setModalidad(modalidad);
  }
  
  public boolean inscribirse(final Partido partido) {
    TipoDeInscripcion _modalidad = this.getModalidad();
    boolean _inscribirse = _modalidad.inscribirse(partido, this);
    return _inscribirse;
  }
  
  public boolean sosCondicional() {
    TipoDeInscripcion _modalidad = this.getModalidad();
    return _modalidad.esCondicional();
  }
  
  public boolean sosSolidario() {
    TipoDeInscripcion _modalidad = this.getModalidad();
    return _modalidad.esSolidaria();
  }
}
