package domain.notificaciones;

import domain.EventoDeportivo;
import domain.Jugador;
import domain.Participante;
import domain.Partido;
import domain.enviadorDeMails.InterfazDistribuidorDeMails;
import domain.inscripcion.TipoDeInscripcion;
import domain.notificaciones.PartidoDecorator;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class NotificarAdminDecorator extends PartidoDecorator {
  public NotificarAdminDecorator(final EventoDeportivo decorado) {
    super(decorado);
  }
  
  public boolean inscribir(final TipoDeInscripcion modalidad) {
    try {
      EventoDeportivo _decorado = this.getDecorado();
      boolean habiaLugar = _decorado.hayLugaresLibres();
      EventoDeportivo _decorado_1 = this.getDecorado();
      boolean valorRetorno = _decorado_1.inscribir(modalidad);
      EventoDeportivo _decorado_2 = this.getDecorado();
      boolean hayLugarAhora = _decorado_2.hayLugaresLibres();
      boolean _and = false;
      if (!habiaLugar) {
        _and = false;
      } else {
        boolean _not = (!hayLugarAhora);
        _and = (habiaLugar && _not);
      }
      if (_and) {
        String subject = "Partido Confirmado";
        String body = "Todas las plazas del partido fueron confirmadas";
        EventoDeportivo _decorado_3 = this.getDecorado();
        InterfazDistribuidorDeMails _distribuidor = _decorado_3.getDistribuidor();
        _distribuidor.enviarMail(Partido.MAIL_ADMINISTRADOR, subject, body);
      }
      return valorRetorno;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void quitarSinReemplazo(final Participante participante) {
    try {
      EventoDeportivo _decorado = this.getDecorado();
      boolean _hayLugaresLibres = _decorado.hayLugaresLibres();
      boolean estabaConfirmado = (!_hayLugaresLibres);
      EventoDeportivo _decorado_1 = this.getDecorado();
      _decorado_1.quitarSinReemplazo(participante);
      EventoDeportivo _decorado_2 = this.getDecorado();
      boolean _hayLugaresLibres_1 = _decorado_2.hayLugaresLibres();
      boolean estaConfirmadoAhora = (!_hayLugaresLibres_1);
      boolean _and = false;
      if (!estabaConfirmado) {
        _and = false;
      } else {
        boolean _not = (!estaConfirmadoAhora);
        _and = (estabaConfirmado && _not);
      }
      if (_and) {
        String subject = "Partido Indefinido";
        Jugador _jugador = participante.getJugador();
        String _nombre = _jugador.getNombre();
        String _plus = ("El partido dejó de tener todas las plazas confirmadas. El jugador " + _nombre);
        String body = (_plus + " se bajó del partido.");
        EventoDeportivo _decorado_3 = this.getDecorado();
        InterfazDistribuidorDeMails _distribuidor = _decorado_3.getDistribuidor();
        _distribuidor.enviarMail(Partido.MAIL_ADMINISTRADOR, subject, body);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
