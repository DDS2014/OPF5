package domain.inscripcion;

import domain.Participante;
import domain.Partido;
import domain.excepciones.JugadorNoFueAnotadoException;
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
  
  private Participante _participante;
  
  public Participante getParticipante() {
    return this._participante;
  }
  
  public void setParticipante(final Participante participante) {
    this._participante = participante;
  }
  
  public TipoDeInscripcion(final Participante participante) {
    this.setParticipante(participante);
  }
  
  public boolean inscribir(final Participante participante, final Partido partido) {
    List<Participante> _participantesConfirmados = partido.getParticipantesConfirmados();
    List<Participante> jugadores = IterableExtensions.<Participante>toList(_participantesConfirmados);
    boolean seInscribio = false;
    boolean _hayLugaresLibres = partido.hayLugaresLibres();
    if (_hayLugaresLibres) {
      boolean _confirmarAsistencia = partido.confirmarAsistencia(participante);
      seInscribio = _confirmarAsistencia;
      boolean _not = (!seInscribio);
      if (_not) {
        JugadorNoFueAnotadoException _jugadorNoFueAnotadoException = new JugadorNoFueAnotadoException("Aunque había lugar, el jugador no fue anotado (verificar si ya estaba anotado?)", partido, participante);
        throw _jugadorNoFueAnotadoException;
      }
    } else {
      int i = 0;
      boolean _and = false;
      boolean _not_1 = (!seInscribio);
      if (!_not_1) {
        _and = false;
      } else {
        int _size = jugadores.size();
        boolean _lessThan = (i < _size);
        _and = (_not_1 && _lessThan);
      }
      boolean _while = _and;
      while (_while) {
        {
          Participante saliente = jugadores.get(i);
          TipoDeInscripcion _modalidad = saliente.getModalidad();
          boolean _reemplazar = _modalidad.reemplazar(partido, participante, saliente);
          seInscribio = _reemplazar;
          int _plus = (i + 1);
          i = _plus;
        }
        boolean _and_1 = false;
        boolean _not_2 = (!seInscribio);
        if (!_not_2) {
          _and_1 = false;
        } else {
          int _size_1 = jugadores.size();
          boolean _lessThan_1 = (i < _size_1);
          _and_1 = (_not_2 && _lessThan_1);
        }
        _while = _and_1;
      }
    }
    boolean _not_2 = (!seInscribio);
    if (_not_2) {
      NoHayLugarParaAnotarseException _noHayLugarParaAnotarseException = new NoHayLugarParaAnotarseException("No se encontró ningun lugar para acomodar a este jugador", partido, participante);
      throw _noHayLugarParaAnotarseException;
    }
    return false;
  }
  
  public abstract boolean reemplazar(final Partido partido, final Participante entrante, final Participante saliente);
}
