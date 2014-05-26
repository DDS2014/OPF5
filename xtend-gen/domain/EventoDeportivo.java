package domain;

import domain.Jugador;
import domain.Participante;
import domain.enviadorDeMails.InterfazDistribuidorDeMails;
import domain.inscripcion.TipoDeInscripcion;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
public interface EventoDeportivo {
  public abstract List<Jugador> jugadoresConfirmados();
  
  public abstract Boolean estaInscripto(final Jugador jugador);
  
  public abstract void inscribir(final TipoDeInscripcion modalidad);
  
  public abstract boolean hayLugaresLibres();
  
  public abstract void confirmarAsistencia(final Participante participante);
  
  public abstract void reemplazar(final Participante entrante, final Participante saliente);
  
  public abstract void quitarSinReemplazo(final Participante participante);
  
  public abstract InterfazDistribuidorDeMails getDistribuidor();
  
  public abstract Date getFecha();
  
  public abstract void setDistribuidor(final InterfazDistribuidorDeMails mails);
}
