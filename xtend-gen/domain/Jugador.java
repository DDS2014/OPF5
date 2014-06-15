package domain;

import com.google.common.base.Objects;
import domain.Partido;
import domain.calificaciones.Calificacion;
import domain.excepciones.ImposibleBajarseException;
import domain.excepciones.ImposibleCalificarException;
import domain.infracciones.Infraccion;
import domain.inscripcion.TipoDeInscripcion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Jugador implements Comparator<Calificacion> {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private String _apellido;
  
  public String getApellido() {
    return this._apellido;
  }
  
  public void setApellido(final String apellido) {
    this._apellido = apellido;
  }
  
  private int _edad;
  
  public int getEdad() {
    return this._edad;
  }
  
  public void setEdad(final int edad) {
    this._edad = edad;
  }
  
  private double _handicap;
  
  public double getHandicap() {
    return this._handicap;
  }
  
  public void setHandicap(final double handicap) {
    this._handicap = handicap;
  }
  
  private String _documento;
  
  public String getDocumento() {
    return this._documento;
  }
  
  public void setDocumento(final String documento) {
    this._documento = documento;
  }
  
  private String _email;
  
  public String getEmail() {
    return this._email;
  }
  
  public void setEmail(final String email) {
    this._email = email;
  }
  
  private TipoDeInscripcion _modalidad;
  
  public TipoDeInscripcion getModalidad() {
    return this._modalidad;
  }
  
  public void setModalidad(final TipoDeInscripcion modalidad) {
    this._modalidad = modalidad;
  }
  
  private HashSet<Jugador> _amigos;
  
  public HashSet<Jugador> getAmigos() {
    return this._amigos;
  }
  
  public void setAmigos(final HashSet<Jugador> amigos) {
    this._amigos = amigos;
  }
  
  private HashSet<Infraccion> _infracciones;
  
  public HashSet<Infraccion> getInfracciones() {
    return this._infracciones;
  }
  
  public void setInfracciones(final HashSet<Infraccion> infracciones) {
    this._infracciones = infracciones;
  }
  
  private ArrayList<Calificacion> _calificaciones;
  
  public ArrayList<Calificacion> getCalificaciones() {
    return this._calificaciones;
  }
  
  public void setCalificaciones(final ArrayList<Calificacion> calificaciones) {
    this._calificaciones = calificaciones;
  }
  
  public Jugador(final String nombre, final int edad, final TipoDeInscripcion modalidad) {
    this.setNombre(nombre);
    this.setEdad(edad);
    HashSet<Jugador> _hashSet = new HashSet<Jugador>();
    this.setAmigos(_hashSet);
    HashSet<Infraccion> _hashSet_1 = new HashSet<Infraccion>();
    this.setInfracciones(_hashSet_1);
    this.setModalidad(modalidad);
    modalidad.setCliente(this);
    ArrayList<Calificacion> _arrayList = new ArrayList<Calificacion>();
    this.setCalificaciones(_arrayList);
  }
  
  public boolean hacerseAmigoDe(final Jugador nuevoAmigo) {
    boolean _xblockexpression = false;
    {
      this.confirmarAmistad(nuevoAmigo);
      boolean _confirmarAmistad = nuevoAmigo.confirmarAmistad(this);
      _xblockexpression = (_confirmarAmistad);
    }
    return _xblockexpression;
  }
  
  public boolean confirmarAmistad(final Jugador nuevoAmigo) {
    HashSet<Jugador> _amigos = this.getAmigos();
    boolean _add = _amigos.add(nuevoAmigo);
    return _add;
  }
  
  public boolean tieneAlAmigo(final Jugador amigo) {
    HashSet<Jugador> _amigos = this.getAmigos();
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador a) {
        boolean _equals = Objects.equal(a, amigo);
        return Boolean.valueOf(_equals);
      }
    };
    return IterableExtensions.<Jugador>exists(_amigos, _function);
  }
  
  public void inscribirse(final Partido partido) {
    TipoDeInscripcion _modalidad = this.getModalidad();
    _modalidad.inscribir(this, partido);
  }
  
  public void bajarse(final Partido partido) {
    boolean _estaInscripto = partido.estaInscripto(this);
    boolean _not = (!_estaInscripto);
    if (_not) {
      ImposibleBajarseException _imposibleBajarseException = new ImposibleBajarseException("No puede darse de baja al jugador.", partido, this);
      throw _imposibleBajarseException;
    }
    partido.quitarSinReemplazo(this);
  }
  
  public boolean bajarse(final Partido partido, final Jugador reemplazante) {
    boolean _xblockexpression = false;
    {
      boolean _estaInscripto = partido.estaInscripto(this);
      boolean _not = (!_estaInscripto);
      if (_not) {
        ImposibleBajarseException _imposibleBajarseException = new ImposibleBajarseException("El jugador no puede ser reemplazado.", partido, this);
        throw _imposibleBajarseException;
      }
      boolean _reemplazar = partido.reemplazar(reemplazante, this);
      _xblockexpression = (_reemplazar);
    }
    return _xblockexpression;
  }
  
  public boolean aplicarInfraccion(final Infraccion infraccion) {
    HashSet<Infraccion> _infracciones = this.getInfracciones();
    boolean _add = _infracciones.add(infraccion);
    return _add;
  }
  
  public void calificar(final int puntaje, final String critica, final Partido partido, final Jugador calificador) {
    boolean _estaInscripto = partido.estaInscripto(this);
    boolean _not = (!_estaInscripto);
    if (_not) {
      ImposibleCalificarException _imposibleCalificarException = new ImposibleCalificarException("El jugador no se encuentra inscripto.", partido, this);
      throw _imposibleCalificarException;
    }
    boolean _estaCalificado = this.estaCalificado(partido, calificador);
    if (_estaCalificado) {
      ImposibleCalificarException _imposibleCalificarException_1 = new ImposibleCalificarException("El jugador ya fue calificado.", partido, this);
      throw _imposibleCalificarException_1;
    }
    boolean _equals = Objects.equal(this, calificador);
    if (_equals) {
      ImposibleCalificarException _imposibleCalificarException_2 = new ImposibleCalificarException("El jugador no puede calificarse a si mismo.", partido, this);
      throw _imposibleCalificarException_2;
    }
    Calificacion _calificacion = new Calificacion(puntaje, critica, partido, calificador);
    Calificacion calificacion = _calificacion;
    ArrayList<Calificacion> _calificaciones = this.getCalificaciones();
    _calificaciones.add(calificacion);
    ArrayList<Calificacion> _calificaciones_1 = this.getCalificaciones();
    Collections.<Calificacion>sort(_calificaciones_1, this);
  }
  
  public boolean estaCalificado(final Partido partido, final Jugador calificador) {
    ArrayList<Calificacion> _calificaciones = this.getCalificaciones();
    final Function1<Calificacion,Boolean> _function = new Function1<Calificacion,Boolean>() {
      public Boolean apply(final Calificacion c) {
        boolean _and = false;
        Partido _partido = c.getPartido();
        boolean _equals = Objects.equal(_partido, partido);
        if (!_equals) {
          _and = false;
        } else {
          Jugador _calificador = c.getCalificador();
          boolean _equals_1 = Objects.equal(_calificador, calificador);
          _and = (_equals && _equals_1);
        }
        return Boolean.valueOf(_and);
      }
    };
    boolean _exists = IterableExtensions.<Calificacion>exists(_calificaciones, _function);
    return _exists;
  }
  
  public int compare(final Calificacion arg0, final Calificacion arg1) {
    Date _fecha = arg0.getFecha();
    Date _fecha_1 = arg1.getFecha();
    boolean _greaterThan = (_fecha.compareTo(_fecha_1) > 0);
    if (_greaterThan) {
      return (-1);
    } else {
      return 1;
    }
  }
}
