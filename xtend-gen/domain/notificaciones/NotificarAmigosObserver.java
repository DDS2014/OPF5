package domain.notificaciones;

import domain.Jugador;
import domain.Participante;
import domain.Partido;
import domain.enviadorDeMails.InterfazDistribuidorDeMails;
import domain.notificaciones.PartidoObserver;
import java.util.HashSet;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class NotificarAmigosObserver implements PartidoObserver {
  public void inscribir(final Partido partido, final Jugador jugador, final boolean habiaLugar) {
    final String subject = "Partido Confirmado";
    final String body = "Todas las plazas del partido fueron confirmadas";
    HashSet<Jugador> _amigos = jugador.getAmigos();
    final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
      public void apply(final Jugador j) {
        try {
          InterfazDistribuidorDeMails _distribuidor = partido.getDistribuidor();
          String _email = j.getEmail();
          _distribuidor.enviarMail(_email, subject, body);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    IterableExtensions.<Jugador>forEach(_amigos, _function);
  }
  
  public void avisarQuitaSinReemplazo(final Partido partido, final String mailAdmin, final Participante participante, final Boolean estabaConfirmado) {
  }
}
