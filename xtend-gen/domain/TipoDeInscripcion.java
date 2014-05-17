package domain;

import domain.JugadorNoFueAnotadoException;
import domain.NoHayLugarParaAnotarseException;
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
  
  public boolean inscribir(final Partido partido) {
    List<Participante> _participantesConfirmados = partido.getParticipantesConfirmados();
    List<Participante> jugadores = IterableExtensions.<Participante>toList(_participantesConfirmados);
    boolean seInscribio = false;
    boolean _hayLugaresLibres = partido.hayLugaresLibres();
    if (_hayLugaresLibres) {
      Participante _participante = this.getParticipante();
      boolean _confirmarAsistencia = partido.confirmarAsistencia(_participante);
      seInscribio = _confirmarAsistencia;
      if ((!seInscribio)) {
        Participante _participante_1 = this.getParticipante();
        throw new JugadorNoFueAnotadoException("Aunque había lugar, el jugador no fue anotado (verificar si ya estaba anotado?)", partido, _participante_1);
      }
    } else {
      int i = 0;
      boolean _and = false;
      if (!(!seInscribio)) {
        _and = false;
      } else {
        int _size = jugadores.size();
        boolean _lessThan = (i < _size);
        _and = _lessThan;
      }
      boolean _while = _and;
      while (_while) {
        {
          Participante saliente = jugadores.get(i);
          TipoDeInscripcion _modalidad = saliente.getModalidad();
          Participante _participante_2 = this.getParticipante();
          boolean _reemplazar = _modalidad.reemplazar(partido, _participante_2, saliente);
          seInscribio = _reemplazar;
          i = (i + 1);
        }
        boolean _and_1 = false;
        if (!(!seInscribio)) {
          _and_1 = false;
        } else {
          int _size_1 = jugadores.size();
          boolean _lessThan_1 = (i < _size_1);
          _and_1 = _lessThan_1;
        }
        _while = _and_1;
      }
    }
    if ((!seInscribio)) {
      Participante _participante_2 = this.getParticipante();
      throw new NoHayLugarParaAnotarseException("No se encontró ningun lugar para acomodar a este jugador", partido, _participante_2);
    }
    return false;
  }
  
  public abstract boolean reemplazar(final Partido partido, final Participante entrante, final Participante saliente);
}
