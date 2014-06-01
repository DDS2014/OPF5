package domain.inscripcion.condiciones;

import domain.Jugador;
import domain.Partido;
import domain.inscripcion.condiciones.Condicion;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Condicion_LimiteDeEdad implements Condicion {
  /**
   * mínimo de edad: true si pido que haya jugadores que sean MAYORES O IGUALES, false para MENORES
   * mínimo de jugadores: true si pido que haya MÁS O IGUAL CANTIDAD de jugadores, false para MENOS
   */
  private int _edad;
  
  /**
   * mínimo de edad: true si pido que haya jugadores que sean MAYORES O IGUALES, false para MENORES
   * mínimo de jugadores: true si pido que haya MÁS O IGUAL CANTIDAD de jugadores, false para MENOS
   */
  public int getEdad() {
    return this._edad;
  }
  
  /**
   * mínimo de edad: true si pido que haya jugadores que sean MAYORES O IGUALES, false para MENORES
   * mínimo de jugadores: true si pido que haya MÁS O IGUAL CANTIDAD de jugadores, false para MENOS
   */
  public void setEdad(final int edad) {
    this._edad = edad;
  }
  
  private int _cantidadJugadores;
  
  public int getCantidadJugadores() {
    return this._cantidadJugadores;
  }
  
  public void setCantidadJugadores(final int cantidadJugadores) {
    this._cantidadJugadores = cantidadJugadores;
  }
  
  private boolean _minimoDeEdad;
  
  public boolean isMinimoDeEdad() {
    return this._minimoDeEdad;
  }
  
  public void setMinimoDeEdad(final boolean minimoDeEdad) {
    this._minimoDeEdad = minimoDeEdad;
  }
  
  private boolean _minimoDeJugadores;
  
  public boolean isMinimoDeJugadores() {
    return this._minimoDeJugadores;
  }
  
  public void setMinimoDeJugadores(final boolean minimoDeJugadores) {
    this._minimoDeJugadores = minimoDeJugadores;
  }
  
  public Condicion_LimiteDeEdad(final int edad, final int cantidadJugadores, final boolean minimoDeEdad, final boolean minimoDeJugadores) {
    this.setEdad(edad);
    this.setCantidadJugadores(cantidadJugadores);
    this.setMinimoDeEdad(minimoDeEdad);
    this.setMinimoDeJugadores(minimoDeJugadores);
  }
  
  public boolean seCumple(final Partido partido) {
    List<Jugador> _jugadoresConfirmados = partido.getJugadoresConfirmados();
    Set<Jugador> jugadores = IterableExtensions.<Jugador>toSet(_jugadoresConfirmados);
    HashSet<Jugador> _hashSet = new HashSet<Jugador>();
    Set<Jugador> jugadoresQueCumplen = _hashSet;
    boolean _isMinimoDeEdad = this.isMinimoDeEdad();
    if (_isMinimoDeEdad) {
      final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
        public Boolean apply(final Jugador j) {
          int _edad = j.getEdad();
          int _edad_1 = Condicion_LimiteDeEdad.this.getEdad();
          boolean _greaterEqualsThan = (_edad >= _edad_1);
          return Boolean.valueOf(_greaterEqualsThan);
        }
      };
      Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(jugadores, _function);
      Set<Jugador> _set = IterableExtensions.<Jugador>toSet(_filter);
      jugadoresQueCumplen = _set;
    } else {
      final Function1<Jugador,Boolean> _function_1 = new Function1<Jugador,Boolean>() {
        public Boolean apply(final Jugador j) {
          int _edad = j.getEdad();
          int _edad_1 = Condicion_LimiteDeEdad.this.getEdad();
          boolean _lessThan = (_edad < _edad_1);
          return Boolean.valueOf(_lessThan);
        }
      };
      Iterable<Jugador> _filter_1 = IterableExtensions.<Jugador>filter(jugadores, _function_1);
      Set<Jugador> _set_1 = IterableExtensions.<Jugador>toSet(_filter_1);
      jugadoresQueCumplen = _set_1;
    }
    boolean _isMinimoDeJugadores = this.isMinimoDeJugadores();
    if (_isMinimoDeJugadores) {
      int _size = jugadoresQueCumplen.size();
      int _cantidadJugadores = this.getCantidadJugadores();
      return (_size >= _cantidadJugadores);
    } else {
      int _size_1 = jugadoresQueCumplen.size();
      int _cantidadJugadores_1 = this.getCantidadJugadores();
      return (_size_1 < _cantidadJugadores_1);
    }
  }
}
