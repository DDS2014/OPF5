package domain.inscripcion.condiciones;

import domain.Partido;

@SuppressWarnings("all")
public interface Condicion {
  public abstract boolean seCumple(final Partido partido);
}
