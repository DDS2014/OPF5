package domain.sugerencias;

import domain.Jugador;
import domain.Partido;
import domain.inscripcion.TipoDeInscripcion;
import domain.sugerencias.Denegacion;
import domain.sugerencias.Sugerencia;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;

@SuppressWarnings("all")
public class Comunidad implements Comparator<Partido> {
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
  
  private ArrayList<Partido> _partidos;
  
  public ArrayList<Partido> getPartidos() {
    return this._partidos;
  }
  
  public void setPartidos(final ArrayList<Partido> partidos) {
    this._partidos = partidos;
  }
  
  public Comunidad() {
    HashSet<Jugador> _hashSet = new HashSet<Jugador>();
    this.setAprobados(_hashSet);
    HashSet<Sugerencia> _hashSet_1 = new HashSet<Sugerencia>();
    this.setPendientes(_hashSet_1);
    HashSet<Denegacion> _hashSet_2 = new HashSet<Denegacion>();
    this.setRechazados(_hashSet_2);
    ArrayList<Partido> _arrayList = new ArrayList<Partido>();
    this.setPartidos(_arrayList);
  }
  
  public boolean agregar(final Jugador jugador) {
    HashSet<Jugador> _aprobados = this.getAprobados();
    return _aprobados.add(jugador);
  }
  
  public boolean organizarPartido(final Partido partido) {
    ArrayList<Partido> _partidos = this.getPartidos();
    return _partidos.add(partido);
  }
  
  public boolean sugerir(final Sugerencia sugerencia) {
    HashSet<Sugerencia> _pendientes = this.getPendientes();
    return _pendientes.add(sugerencia);
  }
  
  public Jugador aprobar(final Sugerencia sugerencia, final TipoDeInscripcion modalidad) {
    HashSet<Sugerencia> _pendientes = this.getPendientes();
    _pendientes.remove(sugerencia);
    final Jugador jugador = sugerencia.aprobar(modalidad);
    HashSet<Jugador> _aprobados = this.getAprobados();
    _aprobados.add(jugador);
    return jugador;
  }
  
  public boolean rechazar(final Sugerencia sugerencia, final String motivo) {
    boolean _xblockexpression = false;
    {
      HashSet<Sugerencia> _pendientes = this.getPendientes();
      _pendientes.remove(sugerencia);
      final Denegacion denegacion = sugerencia.denegar(motivo);
      HashSet<Denegacion> _rechazados = this.getRechazados();
      _xblockexpression = _rechazados.add(denegacion);
    }
    return _xblockexpression;
  }
  
  public Partido ultimoPartido() {
    ArrayList<Partido> _partidos = this.getPartidos();
    Collections.<Partido>sort(_partidos, this);
    ArrayList<Partido> _partidos_1 = this.getPartidos();
    return _partidos_1.get(0);
  }
  
  public int compare(final Partido arg0, final Partido arg1) {
    Date _fecha = arg0.getFecha();
    Date _fecha_1 = arg1.getFecha();
    boolean _lessThan = (_fecha.compareTo(_fecha_1) < 0);
    if (_lessThan) {
      return 1;
    } else {
      return (-1);
    }
  }
}
