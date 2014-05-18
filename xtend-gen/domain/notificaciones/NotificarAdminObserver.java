package domain.notificaciones;

import domain.Jugador;
import domain.Participante;
import domain.Partido;
import domain.enviadorDeMails.DistribuidorDeMails;
import domain.notificaciones.PartidoObserver;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class NotificarAdminObserver implements PartidoObserver {
  public void inscribir(final Partido partido, final Jugador jugador, final boolean habiaLugar) {
    try {
      boolean _and = false;
      if (!habiaLugar) {
        _and = false;
      } else {
        boolean _hayLugaresLibres = partido.hayLugaresLibres();
        boolean _not = (!_hayLugaresLibres);
        _and = (habiaLugar && _not);
      }
      if (_and) {
        System.out.println("Se notifico al administrador");
        String subject = "Partido Confirmado";
        String body = "Todas las plazas del partido fueron confirmadas";
        DistribuidorDeMails _distribuidor = partido.getDistribuidor();
        _distribuidor.enviarMail(Partido.MAIL_ADMINISTRADOR, subject, body);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void quitarSinReemplazo(final Partido partido, final String mailAdmin, final Participante participante) {
    try {
      String subject = "Partido Indefinido";
      Jugador _jugador = participante.getJugador();
      String _nombre = _jugador.getNombre();
      String _plus = ("El partido dejó de tener todas las plazas confirmadas. El jugador " + _nombre);
      String body = (_plus + " se bajó del partido.");
      DistribuidorDeMails _distribuidor = partido.getDistribuidor();
      _distribuidor.enviarMail(Partido.MAIL_ADMINISTRADOR, subject, body);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
