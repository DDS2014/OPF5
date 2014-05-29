package domain;

import com.google.common.base.Objects;
import domain.Partido;
import domain.excepciones.ImposibleBajarseException;
import domain.infracciones.Infraccion;
import domain.inscripcion.TipoDeInscripcion;
import java.util.Date;
import java.util.HashSet;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Jugador {
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
  
  private Date _fechaInscripcion;
  
  public Date getFechaInscripcion() {
    return this._fechaInscripcion;
  }
  
  public void setFechaInscripcion(final Date fechaInscripcion) {
    this._fechaInscripcion = fechaInscripcion;
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
  
  public Jugador(final String nombre, final int edad, final TipoDeInscripcion modalidad) {
    this.setNombre(nombre);
    this.setEdad(edad);
    HashSet<Jugador> _hashSet = new HashSet<Jugador>();
    this.setAmigos(_hashSet);
    HashSet<Infraccion> _hashSet_1 = new HashSet<Infraccion>();
    this.setInfracciones(_hashSet_1);
    this.setModalidad(modalidad);
    modalidad.setCliente(this);
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
      ImposibleBajarseException _imposibleBajarseException = new ImposibleBajarseException("El jugador no está inscripto a ese partido", partido, this);
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
        ImposibleBajarseException _imposibleBajarseException = new ImposibleBajarseException("El jugador no está inscripto a ese partido", partido, this);
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
}
