package domain.notificaciones;

import domain.Jugador;
import domain.Partido;

@SuppressWarnings("all")
public interface PartidoObserver {
  public abstract void avisarInscripcionDeJugador(final Partido partido, final Jugador jugador, final boolean habiaLugar);
  
  public abstract void avisarQuitaSinReemplazo(final Partido partido, final String mailAdmin, final Jugador participante, final Boolean estabaConfirmado);
}
