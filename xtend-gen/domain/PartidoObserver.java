package domain;

import domain.Partido;

@SuppressWarnings("all")
public interface PartidoObserver {
  public abstract void notificarConfirmacionJugador(final Partido partido);
}
