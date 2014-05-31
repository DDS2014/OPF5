package domain;

import domain.Jugador;
import domain.enviadorDeMails.InterfazDistribuidorDeMails;
import domain.excepciones.JugadorNoFueAnotadoException;
import domain.infracciones.Infraccion;
import domain.inscripcion.TipoDeInscripcion;
import domain.notificaciones.PartidoObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Partido implements Comparator<Jugador> {
  private Date _fecha;
  
  public Date getFecha() {
    return this._fecha;
  }
  
  public void setFecha(final Date fecha) {
    this._fecha = fecha;
  }
  
  private List<Jugador> _jugadoresConfirmados;
  
  public List<Jugador> getJugadoresConfirmados() {
    return this._jugadoresConfirmados;
  }
  
  public void setJugadoresConfirmados(final List<Jugador> jugadoresConfirmados) {
    this._jugadoresConfirmados = jugadoresConfirmados;
  }
  
  private List<PartidoObserver> _observers;
  
  public List<PartidoObserver> getObservers() {
    return this._observers;
  }
  
  public void setObservers(final List<PartidoObserver> observers) {
    this._observers = observers;
  }
  
  public final static String MAIL_ADMINISTRADOR = "admin@admin.com";
  
  private InterfazDistribuidorDeMails _distribuidor;
  
  public InterfazDistribuidorDeMails getDistribuidor() {
    return this._distribuidor;
  }
  
  public void setDistribuidor(final InterfazDistribuidorDeMails distribuidor) {
    this._distribuidor = distribuidor;
  }
  
  private Hashtable<Jugador,Date> fechasDeInscripcion;
  
  public Partido(final Date fecha) {
    this.setFecha(fecha);
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadoresConfirmados(_arrayList);
    ArrayList<PartidoObserver> _arrayList_1 = new ArrayList<PartidoObserver>();
    this.setObservers(_arrayList_1);
    Hashtable<Jugador,Date> _hashtable = new Hashtable<Jugador, Date>();
    this.fechasDeInscripcion = _hashtable;
  }
  
  public boolean estaInscripto(final Jugador jugador) {
    List<Jugador> _jugadoresConfirmados = this.getJugadoresConfirmados();
    boolean _contains = _jugadoresConfirmados.contains(jugador);
    return _contains;
  }
  
  public boolean hayLugaresLibres() {
    List<Jugador> _jugadoresConfirmados = this.getJugadoresConfirmados();
    int _size = _jugadoresConfirmados.size();
    return (_size < 10);
  }
  
  public void confirmarAsistencia(final Jugador jugador) {
    boolean _estaInscripto = this.estaInscripto(jugador);
    boolean _not = (!_estaInscripto);
    if (_not) {
      final boolean habiaLugar = this.hayLugaresLibres();
      Date _date = new Date();
      this.fechasDeInscripcion.put(jugador, _date);
      List<Jugador> _jugadoresConfirmados = this.getJugadoresConfirmados();
      _jugadoresConfirmados.add(jugador);
      List<Jugador> _jugadoresConfirmados_1 = this.getJugadoresConfirmados();
      Collections.<Jugador>sort(_jugadoresConfirmados_1, this);
      List<PartidoObserver> _observers = this.getObservers();
      final Procedure1<PartidoObserver> _function = new Procedure1<PartidoObserver>() {
        public void apply(final PartidoObserver observer) {
          observer.avisarInscripcionDeJugador(Partido.this, jugador, habiaLugar);
        }
      };
      IterableExtensions.<PartidoObserver>forEach(_observers, _function);
    } else {
      JugadorNoFueAnotadoException _jugadorNoFueAnotadoException = new JugadorNoFueAnotadoException("El jugador que se intentó agregar ya estaba isncripto", this, jugador);
      throw _jugadorNoFueAnotadoException;
    }
  }
  
  public boolean reemplazar(final Jugador entrante, final Jugador saliente) {
    boolean _xblockexpression = false;
    {
      this.confirmarAsistencia(entrante);
      List<Jugador> _jugadoresConfirmados = this.getJugadoresConfirmados();
      boolean _remove = _jugadoresConfirmados.remove(saliente);
      _xblockexpression = (_remove);
    }
    return _xblockexpression;
  }
  
  public void quitarSinReemplazo(final Jugador participante) {
    boolean _hayLugaresLibres = this.hayLugaresLibres();
    final boolean estabaConfirmado = (!_hayLugaresLibres);
    List<Jugador> _jugadoresConfirmados = this.getJugadoresConfirmados();
    _jugadoresConfirmados.remove(participante);
    Infraccion _infraccion = new Infraccion("El jugador se bajó del partido sin designar un reemplazante");
    participante.aplicarInfraccion(_infraccion);
    List<PartidoObserver> _observers = this.getObservers();
    final Procedure1<PartidoObserver> _function = new Procedure1<PartidoObserver>() {
      public void apply(final PartidoObserver observer) {
        observer.avisarQuitaSinReemplazo(Partido.this, Partido.MAIL_ADMINISTRADOR, participante, Boolean.valueOf(estabaConfirmado));
      }
    };
    IterableExtensions.<PartidoObserver>forEach(_observers, _function);
  }
  
  public int compare(final Jugador arg0, final Jugador arg1) {
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
        Date _get = this.fechasDeInscripcion.get(arg0);
        Date _get_1 = this.fechasDeInscripcion.get(arg1);
        boolean _lessThan_1 = (_get.compareTo(_get_1) < 0);
        if (_lessThan_1) {
          return (-1);
        } else {
          Date _get_2 = this.fechasDeInscripcion.get(arg0);
          Date _get_3 = this.fechasDeInscripcion.get(arg1);
          boolean _greaterThan_1 = (_get_2.compareTo(_get_3) > 0);
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
  
  public boolean seJugo() {
    Date _fecha = this.getFecha();
    Date _date = new Date();
    boolean _before = _fecha.before(_date);
    return _before;
  }
}
