package domain.generacionDeEquipos.criteriosDeEvaluacion;

import domain.Jugador;
import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio;

@SuppressWarnings("all")
public class CriterioDelHandicap extends Criterio {
  public double evaluarJugador(final Jugador jugador) {
    return jugador.getHandicap();
  }
}
