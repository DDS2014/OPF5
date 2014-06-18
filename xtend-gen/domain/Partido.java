package domain;

import domain.Jugador;
import domain.PartidoAbierto_State;
import domain.PartidoConEquiposConfirmados_State;
import domain.PartidoState;
import domain.enviadorDeMails.InterfazDistribuidorDeMails;
import domain.excepciones.JugadorNoFueAnotadoException;
import domain.generacionDeEquipos.algoritmosDeGeneracion.Generacion;
import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio;
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
  
  private Criterio _criterioDeOrdenamiento;
  
  public Criterio getCriterioDeOrdenamiento() {
    return this._criterioDeOrdenamiento;
  }
  
  public void setCriterioDeOrdenamiento(final Criterio criterioDeOrdenamiento) {
    this._criterioDeOrdenamiento = criterioDeOrdenamiento;
  }
  
  private List<Jugador> _primerEquipo;
  
  public List<Jugador> getPrimerEquipo() {
    return this._primerEquipo;
  }
  
  public void setPrimerEquipo(final List<Jugador> primerEquipo) {
    this._primerEquipo = primerEquipo;
  }
  
  private List<Jugador> _segundoEquipo;
  
  public List<Jugador> getSegundoEquipo() {
    return this._segundoEquipo;
  }
  
  public void setSegundoEquipo(final List<Jugador> segundoEquipo) {
    this._segundoEquipo = segundoEquipo;
  }
  
  private Generacion _algoritmo;
  
  public Generacion getAlgoritmo() {
    return this._algoritmo;
  }
  
  public void setAlgoritmo(final Generacion algoritmo) {
    this._algoritmo = algoritmo;
  }
  
  private PartidoState estado;
  
  public Partido(final Date fecha) {
    this.setFecha(fecha);
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadoresConfirmados(_arrayList);
    ArrayList<PartidoObserver> _arrayList_1 = new ArrayList<PartidoObserver>();
    this.setObservers(_arrayList_1);
    Hashtable<Jugador,Date> _hashtable = new Hashtable<Jugador, Date>();
    this.fechasDeInscripcion = _hashtable;
    ArrayList<Jugador> _arrayList_2 = new ArrayList<Jugador>();
    this.setPrimerEquipo(_arrayList_2);
    ArrayList<Jugador> _arrayList_3 = new ArrayList<Jugador>();
    this.setSegundoEquipo(_arrayList_3);
    PartidoAbierto_State _partidoAbierto_State = new PartidoAbierto_State();
    this.estado = _partidoAbierto_State;
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
    this.estado.validarCambios();
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
    this.estado.validarCambios();
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
  
  public void definirAlgoritmoGeneracion(final Generacion algoritmo) {
    this.setAlgoritmo(algoritmo);
    Generacion _algoritmo = this.getAlgoritmo();
    _algoritmo.setPartido(this);
  }
  
  public void ordenarJugadores() {
    List<Jugador> _jugadoresConfirmados = this.getJugadoresConfirmados();
    Criterio _criterioDeOrdenamiento = this.getCriterioDeOrdenamiento();
    Collections.<Jugador>sort(_jugadoresConfirmados, _criterioDeOrdenamiento);
  }
  
  public void generarEquipos() {
    Generacion _algoritmo = this.getAlgoritmo();
    _algoritmo.generarEquipos();
  }
  
  public void resetearEquipos() {
    this.estado.validarCambios();
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setPrimerEquipo(_arrayList);
    ArrayList<Jugador> _arrayList_1 = new ArrayList<Jugador>();
    this.setSegundoEquipo(_arrayList_1);
  }
  
  public boolean agregarAlPrimerEquipo(final Jugador jugador) {
    List<Jugador> _primerEquipo = this.getPrimerEquipo();
    boolean _add = _primerEquipo.add(jugador);
    return _add;
  }
  
  public boolean agregarAlSegundoEquipo(final Jugador jugador) {
    List<Jugador> _segundoEquipo = this.getSegundoEquipo();
    boolean _add = _segundoEquipo.add(jugador);
    return _add;
  }
  
  public PartidoState confirmarEquipos() {
    PartidoState _xblockexpression = null;
    {
      boolean _hayEquipo = this.hayEquipo();
      boolean _not = (!_hayEquipo);
      if (_not) {
        RuntimeException _runtimeException = new RuntimeException("No se puede confirmar los equipos ya que no se generaron correctamente");
        throw _runtimeException;
      }
      PartidoConEquiposConfirmados_State _partidoConEquiposConfirmados_State = new PartidoConEquiposConfirmados_State();
      PartidoState _estado = this.estado = _partidoConEquiposConfirmados_State;
      _xblockexpression = (_estado);
    }
    return _xblockexpression;
  }
  
  public boolean hayEquipo() {
    boolean _and = false;
    List<Jugador> _segundoEquipo = this.getSegundoEquipo();
    int _size = _segundoEquipo.size();
    boolean _equals = (_size == 5);
    if (!_equals) {
      _and = false;
    } else {
      List<Jugador> _primerEquipo = this.getPrimerEquipo();
      int _size_1 = _primerEquipo.size();
      boolean _equals_1 = (_size_1 == 5);
      _and = (_equals && _equals_1);
    }
    return _and;
  }
}
