package domain.notificaciones;

import domain.EventoDeportivo;
import domain.Jugador;
import domain.Participante;
import domain.enviadorDeMails.InterfazDistribuidorDeMails;
import domain.inscripcion.TipoDeInscripcion;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
public class PartidoDecorator implements EventoDeportivo {
  private EventoDeportivo _decorado;
  
  public EventoDeportivo getDecorado() {
    return this._decorado;
  }
  
  public void setDecorado(final EventoDeportivo decorado) {
    this._decorado = decorado;
  }
  
  public PartidoDecorator(final EventoDeportivo decorado) {
    super();
    this.setDecorado(decorado);
  }
  
  public InterfazDistribuidorDeMails getDistribuidor() {
    EventoDeportivo _decorado = this.getDecorado();
    return _decorado.getDistribuidor();
  }
  
  public List<Jugador> jugadoresConfirmados() {
    EventoDeportivo _decorado = this.getDecorado();
    return _decorado.jugadoresConfirmados();
  }
  
  public Boolean estaInscripto(final Jugador jugador) {
    EventoDeportivo _decorado = this.getDecorado();
    return _decorado.estaInscripto(jugador);
  }
  
  public boolean inscribir(final TipoDeInscripcion modalidad) {
    EventoDeportivo _decorado = this.getDecorado();
    return _decorado.inscribir(modalidad);
  }
  
  public boolean hayLugaresLibres() {
    EventoDeportivo _decorado = this.getDecorado();
    return _decorado.hayLugaresLibres();
  }
  
  public void confirmarAsistencia(final Participante participante) {
    EventoDeportivo _decorado = this.getDecorado();
    _decorado.confirmarAsistencia(participante);
  }
  
  public void reemplazar(final Participante entrante, final Participante saliente) {
    EventoDeportivo _decorado = this.getDecorado();
    _decorado.reemplazar(entrante, saliente);
  }
  
  public void quitarSinReemplazo(final Participante participante) {
    EventoDeportivo _decorado = this.getDecorado();
    _decorado.quitarSinReemplazo(participante);
  }
  
  public Date getFecha() {
    EventoDeportivo _decorado = this.getDecorado();
    return _decorado.getFecha();
  }
  
  public void setDistribuidor(final InterfazDistribuidorDeMails mails) {
    EventoDeportivo _decorado = this.getDecorado();
    _decorado.setDistribuidor(mails);
  }
}
