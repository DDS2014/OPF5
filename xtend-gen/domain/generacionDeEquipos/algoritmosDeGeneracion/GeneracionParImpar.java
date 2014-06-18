package domain.generacionDeEquipos.algoritmosDeGeneracion;

import domain.Jugador;
import domain.generacionDeEquipos.algoritmosDeGeneracion.Generacion;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@SuppressWarnings("all")
public class GeneracionParImpar extends Generacion {
  public void designarJugadores(final List<Jugador> jugadoresARepartir) {
    int _size = jugadoresARepartir.size();
    int _minus = (_size - 1);
    IntegerRange _upTo = new IntegerRange(0, _minus);
    for (final Integer i : _upTo) {
      int _modulo = ((i).intValue() % 2);
      boolean _notEquals = (_modulo != 0);
      if (_notEquals) {
        Jugador _get = jugadoresARepartir.get((i).intValue());
        this.enviarAlEquipoUno(_get);
      } else {
        Jugador _get_1 = jugadoresARepartir.get((i).intValue());
        this.enviarAlEquipoDos(_get_1);
      }
    }
  }
}
