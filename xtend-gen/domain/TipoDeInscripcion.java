package domain;

import domain.Participante;
import domain.Partido;
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
  
  public boolean inscribir(final Partido partido, final Participante participante) {
    List<Participante> _participantesConfirmados = partido.getParticipantesConfirmados();
    List<Participante> jugadores = IterableExtensions.<Participante>toList(_participantesConfirmados);
    boolean seInscribio = false;
    boolean _hayLugaresLibres = partido.hayLugaresLibres();
    if (_hayLugaresLibres) {
      boolean _confirmarAsistencia = partido.confirmarAsistencia(participante);
      seInscribio = _confirmarAsistencia;
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
          Participante saliente = jugadores.get(i);
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
    return seInscribio;
  }
  
  public abstract boolean reemplazar(final Partido partido, final Participante entrante, final Participante saliente);
}
