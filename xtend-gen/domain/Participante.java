package domain;

import domain.EventoDeportivo;
import domain.Jugador;
import domain.Partido;
import domain.excepciones.ImposibleBajarseException;
import domain.inscripcion.TipoDeInscripcion;
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
  
  public void inscribirse(final Partido partido) {
    TipoDeInscripcion _modalidad = this.getModalidad();
    _modalidad.inscribir(this, partido);
  }
  
  public void bajarse(final EventoDeportivo partido) {
    Jugador _jugador = this.getJugador();
    Boolean _estaInscripto = partido.estaInscripto(_jugador);
    boolean _not = (!(_estaInscripto).booleanValue());
    if (_not) {
      ImposibleBajarseException _imposibleBajarseException = new ImposibleBajarseException("El jugador no está inscripto a ese partido", partido, this);
      throw _imposibleBajarseException;
    }
    partido.quitarSinReemplazo(this);
  }
  
  public void bajarse(final Partido partido, final Participante reemplazante) {
    Jugador _jugador = this.getJugador();
    Boolean _estaInscripto = partido.estaInscripto(_jugador);
    boolean _not = (!(_estaInscripto).booleanValue());
    if (_not) {
      ImposibleBajarseException _imposibleBajarseException = new ImposibleBajarseException("El jugador no está inscripto a ese partido", partido, this);
      throw _imposibleBajarseException;
    }
    partido.reemplazar(reemplazante, this);
  }
}
