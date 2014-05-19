package domain;

import domain.Jugador;
import domain.Participante;
import domain.inscripcion.TipoDeInscripcion;
import java.util.List;

@SuppressWarnings("all")
public interface EventoDeportivo {
  public abstract List<Jugador> jugadoresConfirmados();
  
  public abstract Boolean estaInscripto(final Jugador jugador);
  
  public abstract boolean inscribir(final TipoDeInscripcion modalidad);
  
  public abstract boolean hayLugaresLibres();
  
  public abstract boolean confirmarAsistencia(final Participante participante);
  
  public abstract boolean reemplazar(final Participante entrante, final Participante saliente);
  
  public abstract void quitarSinReemplazo(final Participante participante);
}
