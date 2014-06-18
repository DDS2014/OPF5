package domain.generacionDeEquipos.algoritmosDeGeneracion;

import domain.Jugador;
import domain.generacionDeEquipos.algoritmosDeGeneracion.Generacion;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@SuppressWarnings("all")
public class GeneracionConcreta extends Generacion {
  private ArrayList<Integer> primerEquipoPos = new Function0<ArrayList<Integer>>() {
    public ArrayList<Integer> apply() {
      ArrayList<Integer> _newArrayList = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(8), Integer.valueOf(9));
      return _newArrayList;
    }
  }.apply();
  
  private ArrayList<Integer> segundoEquipoPos = new Function0<ArrayList<Integer>>() {
    public ArrayList<Integer> apply() {
      ArrayList<Integer> _newArrayList = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(10));
      return _newArrayList;
    }
  }.apply();
  
  public void designarJugadores(final List<Jugador> jugadoresARepartir) {
    int _size = jugadoresARepartir.size();
    int _minus = (_size - 1);
    IntegerRange _upTo = new IntegerRange(0, _minus);
    for (final Integer i : _upTo) {
      int _plus = ((i).intValue() + 1);
      boolean _contains = this.primerEquipoPos.contains(Integer.valueOf(_plus));
      if (_contains) {
        Jugador _get = jugadoresARepartir.get((i).intValue());
        this.enviarAlEquipoUno(_get);
      } else {
        int _plus_1 = ((i).intValue() + 1);
        boolean _contains_1 = this.segundoEquipoPos.contains(Integer.valueOf(_plus_1));
        if (_contains_1) {
          Jugador _get_1 = jugadoresARepartir.get((i).intValue());
          this.enviarAlEquipoDos(_get_1);
        }
      }
    }
  }
}
