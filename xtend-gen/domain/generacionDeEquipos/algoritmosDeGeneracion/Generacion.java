package domain.generacionDeEquipos.algoritmosDeGeneracion;

import domain.Jugador;
import domain.Partido;
import domain.excepciones.ImposibleGenerarEquiposException;
import java.util.List;

@SuppressWarnings("all")
public abstract class Generacion {
  private Partido _partido;
  
  public Partido getPartido() {
    return this._partido;
  }
  
  public void setPartido(final Partido partido) {
    this._partido = partido;
  }
  
  public void generarEquipos() {
    Partido _partido = this.getPartido();
    boolean _hayLugaresLibres = _partido.hayLugaresLibres();
    if (_hayLugaresLibres) {
      throw new ImposibleGenerarEquiposException("Todavía no se completaron los diez jugadores.");
    }
    Partido _partido_1 = this.getPartido();
    _partido_1.ordenarJugadores();
    Partido _partido_2 = this.getPartido();
    List<Jugador> jugadoresARepartir = _partido_2.getJugadoresConfirmados();
    this.designarJugadores(jugadoresARepartir);
  }
  
  public abstract void designarJugadores(final List<Jugador> jugadoresARepartir);
  
  public void enviarAlEquipoUno(final Jugador jugador) {
    Partido _partido = this.getPartido();
    _partido.agregarAlPrimerEquipo(jugador);
  }
  
  public void enviarAlEquipoDos(final Jugador jugador) {
    Partido _partido = this.getPartido();
    _partido.agregarAlSegundoEquipo(jugador);
  }
}
