package domain;

import domain.Infraccion;
import domain.Jugador;
import domain.Participante;
import domain.TipoDeInscripcion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class Partido implements Comparator<Participante> {
  private Date _fecha;
  
  public Date getFecha() {
    return this._fecha;
  }
  
  public void setFecha(final Date fecha) {
    this._fecha = fecha;
  }
  
  private List<Participante> _participantesConfirmados;
  
  public List<Participante> getParticipantesConfirmados() {
    return this._participantesConfirmados;
  }
  
  public void setParticipantesConfirmados(final List<Participante> participantesConfirmados) {
    this._participantesConfirmados = participantesConfirmados;
  }
  
  public Partido(final Date fecha) {
    this.setFecha(fecha);
    ArrayList<Participante> _arrayList = new ArrayList<Participante>();
    this.setParticipantesConfirmados(_arrayList);
  }
  
  public List<Jugador> jugadoresConfirmados() {
    List<Participante> _participantesConfirmados = this.getParticipantesConfirmados();
    final Function1<Participante,Jugador> _function = new Function1<Participante,Jugador>() {
      public Jugador apply(final Participante p) {
        Jugador _jugador = p.getJugador();
        return _jugador;
      }
    };
    List<Jugador> _map = ListExtensions.<Participante, Jugador>map(_participantesConfirmados, _function);
    List<Jugador> _list = IterableExtensions.<Jugador>toList(_map);
    return _list;
  }
  
  public boolean estaInscripto(final Jugador jugador) {
    boolean _xblockexpression = false;
    {
      List<Jugador> jugadores = this.jugadoresConfirmados();
      boolean _contains = jugadores.contains(jugador);
      _xblockexpression = (_contains);
    }
    return _xblockexpression;
  }
  
  public boolean inscribir(final Jugador jugador, final TipoDeInscripcion modalidad) {
    Participante _participante = new Participante(jugador);
    final Participante participante = _participante;
    participante.setModalidad(modalidad);
    return participante.inscribirse(this);
  }
  
  public boolean hayLugaresLibres() {
    List<Participante> _participantesConfirmados = this.getParticipantesConfirmados();
    int _size = _participantesConfirmados.size();
    return (_size < 10);
  }
  
  public boolean confirmarAsistencia(final Participante participante) {
    Jugador _jugador = participante.getJugador();
    boolean _estaInscripto = this.estaInscripto(_jugador);
    boolean _not = (!_estaInscripto);
    if (_not) {
      List<Participante> _participantesConfirmados = this.getParticipantesConfirmados();
      _participantesConfirmados.add(participante);
      List<Participante> _participantesConfirmados_1 = this.getParticipantesConfirmados();
      Collections.<Participante>sort(_participantesConfirmados_1, this);
      return true;
    } else {
      return false;
    }
  }
  
  public boolean reemplazar(final Participante entrante, final Participante saliente) {
    Boolean _xifexpression = null;
    Jugador _jugador = entrante.getJugador();
    boolean _estaInscripto = this.estaInscripto(_jugador);
    boolean _not = (!_estaInscripto);
    if (_not) {
      boolean _xblockexpression = false;
      {
        List<Participante> _participantesConfirmados = this.getParticipantesConfirmados();
        _participantesConfirmados.remove(saliente);
        boolean _confirmarAsistencia = this.confirmarAsistencia(entrante);
        _xblockexpression = (_confirmarAsistencia);
      }
      _xifexpression = Boolean.valueOf(_xblockexpression);
    }
    return (_xifexpression).booleanValue();
  }
  
  public boolean quitarSinReemplazo(final Participante participante) {
    boolean _xblockexpression = false;
    {
      List<Participante> _participantesConfirmados = this.getParticipantesConfirmados();
      _participantesConfirmados.remove(participante);
      Jugador _jugador = participante.getJugador();
      Infraccion _infraccion = new Infraccion("El jugador se bajó del partido sin designar un reemplazante");
      boolean _aplicarInfraccion = _jugador.aplicarInfraccion(_infraccion);
      _xblockexpression = (_aplicarInfraccion);
    }
    return _xblockexpression;
  }
  
  public int compare(final Participante arg0, final Participante arg1) {
    TipoDeInscripcion _modalidad = arg0.getModalidad();
    int _prioridad = _modalidad.getPrioridad();
    TipoDeInscripcion _modalidad_1 = arg1.getModalidad();
    int _prioridad_1 = _modalidad_1.getPrioridad();
    boolean _greaterThan = (_prioridad > _prioridad_1);
    if (_greaterThan) {
      return (-1);
    } else {
      TipoDeInscripcion _modalidad_2 = arg0.getModalidad();
      int _prioridad_2 = _modalidad_2.getPrioridad();
      TipoDeInscripcion _modalidad_3 = arg1.getModalidad();
      int _prioridad_3 = _modalidad_3.getPrioridad();
      boolean _lessThan = (_prioridad_2 < _prioridad_3);
      if (_lessThan) {
        return 1;
      } else {
        Date _fechaInscripcion = arg0.getFechaInscripcion();
        Date _fechaInscripcion_1 = arg1.getFechaInscripcion();
        boolean _lessThan_1 = (_fechaInscripcion.compareTo(_fechaInscripcion_1) < 0);
        if (_lessThan_1) {
          return (-1);
        } else {
          Date _fechaInscripcion_2 = arg0.getFechaInscripcion();
          Date _fechaInscripcion_3 = arg1.getFechaInscripcion();
          boolean _greaterThan_1 = (_fechaInscripcion_2.compareTo(_fechaInscripcion_3) > 0);
          if (_greaterThan_1) {
            return 1;
          } else {
            return 0;
          }
        }
      }
    }
  }
}
