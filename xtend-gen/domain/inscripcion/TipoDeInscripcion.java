package domain.inscripcion;

import domain.Jugador;
import domain.Partido;
import domain.excepciones.NoHayLugarParaAnotarseException;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class TipoDeInscripcion {
  private int _prioridad;
  
  public int getPrioridad() {
    return this._prioridad;
  }
  
  public void setPrioridad(final int prioridad) {
    this._prioridad = prioridad;
  }
  
  private Jugador _participante;
  
  public Jugador getParticipante() {
    return this._participante;
  }
  
  public void setParticipante(final Jugador participante) {
    this._participante = participante;
  }
  
  public void setCliente(final Jugador jugador) {
    this.setParticipante(jugador);
  }
  
  public void inscribir(final Jugador participante, final Partido partido) {
    List<Jugador> _jugadoresConfirmados = partido.getJugadoresConfirmados();
    List<Jugador> jugadores = IterableExtensions.<Jugador>toList(_jugadoresConfirmados);
    boolean seInscribio = false;
    boolean _hayLugaresLibres = partido.hayLugaresLibres();
    if (_hayLugaresLibres) {
      partido.confirmarAsistencia(participante);
      seInscribio = true;
    } else {
      int i = 0;
      boolean _and = false;
      boolean _not = (!seInscribio);
      if (!_not) {
        _and = false;
      } else {
        int _size = jugadores.size();
        boolean _lessThan = (i < _size);
        _and = (_not && _lessThan);
      }
      boolean _while = _and;
      while (_while) {
        {
          Jugador saliente = jugadores.get(i);
          TipoDeInscripcion _modalidad = saliente.getModalidad();
          boolean _reemplazar = _modalidad.reemplazar(partido, participante, saliente);
          seInscribio = _reemplazar;
          int _plus = (i + 1);
          i = _plus;
        }
        boolean _and_1 = false;
        boolean _not_1 = (!seInscribio);
        if (!_not_1) {
          _and_1 = false;
        } else {
          int _size_1 = jugadores.size();
          boolean _lessThan_1 = (i < _size_1);
          _and_1 = (_not_1 && _lessThan_1);
        }
        _while = _and_1;
      }
    }
    boolean _not_1 = (!seInscribio);
    if (_not_1) {
      NoHayLugarParaAnotarseException _noHayLugarParaAnotarseException = new NoHayLugarParaAnotarseException("No se encontró ningun lugar para acomodar a este jugador", partido, participante);
      throw _noHayLugarParaAnotarseException;
    }
  }
  
  public abstract boolean reemplazar(final Partido partido, final Jugador entrante, final Jugador saliente);
}
