package domain.sugerencias;

import domain.Jugador;
import domain.inscripcion.TipoDeInscripcion;
import domain.sugerencias.Denegacion;
import java.util.HashSet;

@SuppressWarnings("all")
public class Sugerencia {
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
  
  public Sugerencia(final String nombre, final int edad) {
    this.setNombre(nombre);
    this.setEdad(edad);
    HashSet<Jugador> _hashSet = new HashSet<Jugador>();
    this.setAmigos(_hashSet);
  }
  
  public Jugador aprobar(final TipoDeInscripcion modalidad) {
    String _nombre = this.getNombre();
    int _edad = this.getEdad();
    final Jugador jugador = new Jugador(_nombre, _edad, modalidad);
    return jugador;
  }
  
  public Denegacion denegar(final String motivo) {
    String _nombre = this.getNombre();
    final Denegacion denegacion = new Denegacion(_nombre, motivo);
    return denegacion;
  }
}
