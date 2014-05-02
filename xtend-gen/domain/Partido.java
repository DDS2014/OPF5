package domain;

import domain.Jugador;
import domain.Participante;
import domain.TipoDeInscripcion;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Partido {
  private Date _fecha;
  
  public Date getFecha() {
    return this._fecha;
  }
  
  public void setFecha(final Date fecha) {
    this._fecha = fecha;
  }
  
  private Set<Participante> _participantesConfirmados;
  
  public Set<Participante> getParticipantesConfirmados() {
    return this._participantesConfirmados;
  }
  
  public void setParticipantesConfirmados(final Set<Participante> participantesConfirmados) {
    this._participantesConfirmados = participantesConfirmados;
  }
  
  public Partido(final Date fecha) {
    this.setFecha(fecha);
    HashSet<Participante> _hashSet = new HashSet<Participante>();
    this.setParticipantesConfirmados(_hashSet);
  }
  
  public List<Jugador> getJugadoresConfirmados() {
    Set<Participante> _participantesConfirmados = this.getParticipantesConfirmados();
    final Function1<Participante,Jugador> _function = new Function1<Participante,Jugador>() {
      public Jugador apply(final Participante p) {
        Jugador _jugador = p.getJugador();
        return _jugador;
      }
    };
    Iterable<Jugador> _map = IterableExtensions.<Participante, Jugador>map(_participantesConfirmados, _function);
    List<Jugador> _list = IterableExtensions.<Jugador>toList(_map);
    return _list;
  }
  
  public boolean estaInscripto(final Jugador jugador) {
    List<Jugador> _jugadoresConfirmados = this.getJugadoresConfirmados();
    boolean _contains = _jugadoresConfirmados.contains(jugador);
    return _contains;
  }
  
  public boolean inscribir(final Jugador jugador, final TipoDeInscripcion modalidad) {
    Participante _participante = new Participante(jugador, modalidad);
    final Participante participante = _participante;
    return participante.inscribirse(this);
  }
  
  public boolean hayLugaresLibres() {
    Set<Participante> _participantesConfirmados = this.getParticipantesConfirmados();
    int _size = _participantesConfirmados.size();
    return (_size < 10);
  }
  
  public boolean confirmarAsistencia(final Participante participante) {
    Jugador _jugador = participante.getJugador();
    boolean _estaInscripto = this.estaInscripto(_jugador);
    if (_estaInscripto) {
      Set<Participante> _participantesConfirmados = this.getParticipantesConfirmados();
      return _participantesConfirmados.add(participante);
    } else {
      return false;
    }
  }
  
  public boolean reemplazar(final Participante entrante, final Participante saliente) {
    Boolean _xifexpression = null;
    boolean _confirmarAsistencia = this.confirmarAsistencia(entrante);
    if (_confirmarAsistencia) {
      Set<Participante> _participantesConfirmados = this.getParticipantesConfirmados();
      boolean _remove = _participantesConfirmados.remove(saliente);
      _xifexpression = Boolean.valueOf(_remove);
    }
    return (_xifexpression).booleanValue();
  }
}
