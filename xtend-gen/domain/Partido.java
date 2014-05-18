package domain;

import domain.Jugador;
import domain.Participante;
import domain.enviadorDeMails.distribuidor.DistribuidorStub;
import domain.infracciones.Infraccion;
import domain.inscripcion.TipoDeInscripcion;
import domain.notificaciones.PartidoObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
  
  private List<PartidoObserver> _observers;
  
  public List<PartidoObserver> getObservers() {
    return this._observers;
  }
  
  public void setObservers(final List<PartidoObserver> observers) {
    this._observers = observers;
  }
  
  public final static String MAIL_ADMINISTRADOR = "admin@admin.com";
  
  private DistribuidorStub _distribuidor;
  
  public DistribuidorStub getDistribuidor() {
    return this._distribuidor;
  }
  
  public void setDistribuidor(final DistribuidorStub distribuidor) {
    this._distribuidor = distribuidor;
  }
  
  public Partido(final Date fecha) {
    this.setFecha(fecha);
    ArrayList<Participante> _arrayList = new ArrayList<Participante>();
    this.setParticipantesConfirmados(_arrayList);
    ArrayList<PartidoObserver> _arrayList_1 = new ArrayList<PartidoObserver>();
    this.setObservers(_arrayList_1);
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
  
  public boolean inscribir(final TipoDeInscripcion modalidad) {
    final boolean habiaLugar = this.hayLugaresLibres();
    Participante _participante = modalidad.getParticipante();
    _participante.setModalidad(modalidad);
    Participante _participante_1 = modalidad.getParticipante();
    _participante_1.inscribirse(this);
    List<PartidoObserver> _observers = this.getObservers();
    final Procedure1<PartidoObserver> _function = new Procedure1<PartidoObserver>() {
      public void apply(final PartidoObserver observer) {
        Participante _participante = modalidad.getParticipante();
        Jugador _jugador = _participante.getJugador();
        observer.inscribir(Partido.this, _jugador, habiaLugar);
      }
    };
    IterableExtensions.<PartidoObserver>forEach(_observers, _function);
    return true;
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
    boolean bool = false;
    Jugador _jugador = entrante.getJugador();
    boolean _estaInscripto = this.estaInscripto(_jugador);
    boolean _not = (!_estaInscripto);
    if (_not) {
      List<Participante> _participantesConfirmados = this.getParticipantesConfirmados();
      _participantesConfirmados.remove(saliente);
      boolean _confirmarAsistencia = this.confirmarAsistencia(entrante);
      bool = _confirmarAsistencia;
    }
    return bool;
  }
  
  public void quitarSinReemplazo(final Participante participante) {
    List<Participante> _participantesConfirmados = this.getParticipantesConfirmados();
    _participantesConfirmados.remove(participante);
    Jugador _jugador = participante.getJugador();
    Infraccion _infraccion = new Infraccion("El jugador se bajó del partido sin designar un reemplazante");
    _jugador.aplicarInfraccion(_infraccion);
    List<PartidoObserver> _observers = this.getObservers();
    final Procedure1<PartidoObserver> _function = new Procedure1<PartidoObserver>() {
      public void apply(final PartidoObserver observer) {
        observer.quitarSinReemplazo(Partido.this, Partido.MAIL_ADMINISTRADOR, participante);
      }
    };
    IterableExtensions.<PartidoObserver>forEach(_observers, _function);
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
  
  public boolean agregarObsever(final PartidoObserver observer) {
    List<PartidoObserver> _observers = this.getObservers();
    boolean _add = _observers.add(observer);
    return _add;
  }
  
  public boolean removeObserver(final PartidoObserver observer) {
    List<PartidoObserver> _observers = this.getObservers();
    boolean _remove = _observers.remove(observer);
    return _remove;
  }
  
  public boolean amigosNotificados() {
    List<Jugador> _jugadoresConfirmados = this.jugadoresConfirmados();
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador jugador) {
        boolean _avisarAmigos = jugador.avisarAmigos();
        return Boolean.valueOf(_avisarAmigos);
      }
    };
    boolean _forall = IterableExtensions.<Jugador>forall(_jugadoresConfirmados, _function);
    return _forall;
  }
}
