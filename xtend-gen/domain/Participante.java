package domain;

import domain.ImposibleBajarseException;
import domain.Jugador;
import domain.Partido;
import domain.TipoDeInscripcion;
import java.util.Date;

@SuppressWarnings("all")
public class Participante {
  private Jugador _jugador;
  
  public Jugador getJugador() {
    return this._jugador;
  }
  
  public void setJugador(final Jugador jugador) {
    this._jugador = jugador;
  }
  
  private Date _fechaInscripcion;
  
  public Date getFechaInscripcion() {
    return this._fechaInscripcion;
  }
  
  public void setFechaInscripcion(final Date fechaInscripcion) {
    this._fechaInscripcion = fechaInscripcion;
  }
  
  private TipoDeInscripcion _modalidad;
  
  public TipoDeInscripcion getModalidad() {
    return this._modalidad;
  }
  
  public void setModalidad(final TipoDeInscripcion modalidad) {
    this._modalidad = modalidad;
  }
  
  public Participante(final Jugador jugador) {
    this.setJugador(jugador);
    Date _date = new Date();
    this.setFechaInscripcion(_date);
  }
  
  public boolean inscribirse(final Partido partido) {
    TipoDeInscripcion _modalidad = this.getModalidad();
    return _modalidad.inscribir(partido);
  }
  
  public boolean bajarse(final Partido partido) {
    boolean _xblockexpression = false;
    {
      Jugador _jugador = this.getJugador();
      boolean _estaInscripto = partido.estaInscripto(_jugador);
      boolean _not = (!_estaInscripto);
      if (_not) {
        throw new ImposibleBajarseException("El jugador no está inscripto a ese partido", partido, this);
      }
      _xblockexpression = partido.quitarSinReemplazo(this);
    }
    return _xblockexpression;
  }
  
  public boolean bajarse(final Partido partido, final Participante reemplazante) {
    boolean _xblockexpression = false;
    {
      Jugador _jugador = this.getJugador();
      boolean _estaInscripto = partido.estaInscripto(_jugador);
      boolean _not = (!_estaInscripto);
      if (_not) {
        throw new ImposibleBajarseException("El jugador no está inscripto a ese partido", partido, this);
      }
      _xblockexpression = partido.reemplazar(reemplazante, this);
    }
    return _xblockexpression;
  }
}
