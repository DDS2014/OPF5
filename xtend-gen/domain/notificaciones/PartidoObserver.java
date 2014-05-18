package domain.notificaciones;

import domain.Jugador;
import domain.Participante;
import domain.Partido;

@SuppressWarnings("all")
public interface PartidoObserver {
  public abstract void inscribir(final Partido partido, final Jugador jugador, final boolean habiaLugar);
  
  public abstract void avisarQuitaSinReemplazo(final Partido partido, final String mailAdmin, final Participante participante, final Boolean estabaConfirmado);
}
