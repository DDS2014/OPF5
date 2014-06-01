package domain.sugerencias;

import domain.Jugador;
import domain.Partido;
import domain.inscripcion.TipoDeInscripcion;
import domain.sugerencias.Denegacion;
import domain.sugerencias.Sugerencia;
import java.util.HashSet;

@SuppressWarnings("all")
public class Comunidad {
  private HashSet<Jugador> _aprobados;
  
  public HashSet<Jugador> getAprobados() {
    return this._aprobados;
  }
  
  public void setAprobados(final HashSet<Jugador> aprobados) {
    this._aprobados = aprobados;
  }
  
  private HashSet<Sugerencia> _pendientes;
  
  public HashSet<Sugerencia> getPendientes() {
    return this._pendientes;
  }
  
  public void setPendientes(final HashSet<Sugerencia> pendientes) {
    this._pendientes = pendientes;
  }
  
  private HashSet<Denegacion> _rechazados;
  
  public HashSet<Denegacion> getRechazados() {
    return this._rechazados;
  }
  
  public void setRechazados(final HashSet<Denegacion> rechazados) {
    this._rechazados = rechazados;
  }
  
  private HashSet<Partido> _partidos;
  
  public HashSet<Partido> getPartidos() {
    return this._partidos;
  }
  
  public void setPartidos(final HashSet<Partido> partidos) {
    this._partidos = partidos;
  }
  
  public Comunidad() {
    HashSet<Jugador> _hashSet = new HashSet<Jugador>();
    this.setAprobados(_hashSet);
    HashSet<Sugerencia> _hashSet_1 = new HashSet<Sugerencia>();
    this.setPendientes(_hashSet_1);
    HashSet<Denegacion> _hashSet_2 = new HashSet<Denegacion>();
    this.setRechazados(_hashSet_2);
    HashSet<Partido> _hashSet_3 = new HashSet<Partido>();
    this.setPartidos(_hashSet_3);
  }
  
  public boolean agregar(final Jugador jugador) {
    HashSet<Jugador> _aprobados = this.getAprobados();
    boolean _add = _aprobados.add(jugador);
    return _add;
  }
  
  public boolean organizarPartido(final Partido partido) {
    HashSet<Partido> _partidos = this.getPartidos();
    boolean _add = _partidos.add(partido);
    return _add;
  }
  
  public boolean sugerir(final Sugerencia sugerencia) {
    HashSet<Sugerencia> _pendientes = this.getPendientes();
    boolean _add = _pendientes.add(sugerencia);
    return _add;
  }
  
  public boolean aprobar(final Sugerencia sugerencia, final TipoDeInscripcion modalidad) {
    boolean _xblockexpression = false;
    {
      HashSet<Sugerencia> _pendientes = this.getPendientes();
      _pendientes.remove(sugerencia);
      final Jugador jugador = sugerencia.aprobar(modalidad);
      HashSet<Jugador> _aprobados = this.getAprobados();
      boolean _add = _aprobados.add(jugador);
      _xblockexpression = (_add);
    }
    return _xblockexpression;
  }
  
  public boolean rechazar(final Sugerencia sugerencia, final String motivo) {
    boolean _xblockexpression = false;
    {
      HashSet<Sugerencia> _pendientes = this.getPendientes();
      _pendientes.remove(sugerencia);
      Denegacion _denegacion = new Denegacion(sugerencia, motivo);
      final Denegacion denegacion = _denegacion;
      HashSet<Denegacion> _rechazados = this.getRechazados();
      boolean _add = _rechazados.add(denegacion);
      _xblockexpression = (_add);
    }
    return _xblockexpression;
  }
}
