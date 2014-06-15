package domain.generacionDeEquipos;

import domain.Jugador;
import domain.generacionDeEquipos.Criterio;

@SuppressWarnings("all")
public class CriterioDelHandicap extends Criterio {
  public double evaluarJugador(final Jugador jugador) {
    return jugador.getHandicap();
  }
}
