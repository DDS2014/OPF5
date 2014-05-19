package domain.notificaciones;

import domain.EventoDeportivo;
import domain.Jugador;
import domain.Participante;
import domain.inscripcion.TipoDeInscripcion;
import java.util.List;

@SuppressWarnings("all")
public class PartidoDecorator implements EventoDeportivo {
  private EventoDeportivo decorado;
  
  public PartidoDecorator(final EventoDeportivo decorado) {
    super();
    this.decorado = decorado;
  }
  
  public List<Jugador> jugadoresConfirmados() {
    return this.decorado.jugadoresConfirmados();
  }
  
  public Boolean estaInscripto(final Jugador jugador) {
    return this.decorado.estaInscripto(jugador);
  }
  
  public boolean inscribir(final TipoDeInscripcion modalidad) {
    return this.decorado.inscribir(modalidad);
  }
  
  public boolean hayLugaresLibres() {
    return this.decorado.hayLugaresLibres();
  }
  
  public boolean confirmarAsistencia(final Participante participante) {
    return this.decorado.confirmarAsistencia(participante);
  }
  
  public boolean reemplazar(final Participante entrante, final Participante saliente) {
    return this.decorado.reemplazar(entrante, saliente);
  }
  
  public void quitarSinReemplazo(final Participante participante) {
    this.decorado.quitarSinReemplazo(participante);
  }
}
