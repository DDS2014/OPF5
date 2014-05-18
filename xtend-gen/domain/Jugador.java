package domain;

import com.google.common.base.Objects;
import domain.infracciones.Infraccion;
import java.util.HashSet;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
  
  public Jugador(final String nombre, final int edad) {
    this.setNombre(nombre);
    this.setEdad(edad);
    HashSet<Jugador> _hashSet = new HashSet<Jugador>();
    this.setAmigos(_hashSet);
    HashSet<Infraccion> _hashSet_1 = new HashSet<Infraccion>();
    this.setInfracciones(_hashSet_1);
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
  
  public boolean aplicarInfraccion(final Infraccion infraccion) {
    HashSet<Infraccion> _infracciones = this.getInfracciones();
    boolean _add = _infracciones.add(infraccion);
    return _add;
  }
  
  public boolean avisarAmigos() {
    HashSet<Jugador> _amigos = this.getAmigos();
    final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
      public void apply(final Jugador amigo) {
        amigo.recibirNotificacionDe(Jugador.this);
      }
    };
    IterableExtensions.<Jugador>forEach(_amigos, _function);
    return true;
  }
  
  public boolean recibirNotificacionDe(final Jugador jugador) {
    return true;
  }
}
