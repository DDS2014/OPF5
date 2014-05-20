package domain.notificaciones;

import domain.EventoDeportivo;
import domain.Jugador;
import domain.Participante;
import domain.enviadorDeMails.InterfazDistribuidorDeMails;
import domain.inscripcion.TipoDeInscripcion;
import domain.notificaciones.PartidoDecorator;
import java.util.Date;
import java.util.HashSet;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class NotificarAmigosDecorator extends PartidoDecorator {
  public NotificarAmigosDecorator(final EventoDeportivo decorado) {
    super(decorado);
  }
  
  public boolean inscribir(final TipoDeInscripcion modalidad) {
    EventoDeportivo _decorado = this.getDecorado();
    boolean fueInscripto = _decorado.inscribir(modalidad);
    if (fueInscripto) {
      final String subject = "Me anote a un partido!";
      Participante _participante = modalidad.getParticipante();
      Jugador _jugador = _participante.getJugador();
      String _nombre = _jugador.getNombre();
      String _plus = (_nombre + " se inscribió al partido del ");
      EventoDeportivo _decorado_1 = this.getDecorado();
      Date _fecha = _decorado_1.getFecha();
      String _string = _fecha.toString();
      final String body = (_plus + _string);
      Participante _participante_1 = modalidad.getParticipante();
      Jugador _jugador_1 = _participante_1.getJugador();
      HashSet<Jugador> _amigos = _jugador_1.getAmigos();
      final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
        public void apply(final Jugador j) {
          try {
            EventoDeportivo _decorado = NotificarAmigosDecorator.this.getDecorado();
            InterfazDistribuidorDeMails _distribuidor = _decorado.getDistribuidor();
            String _email = j.getEmail();
            _distribuidor.enviarMail(_email, subject, body);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      IterableExtensions.<Jugador>forEach(_amigos, _function);
    }
    return fueInscripto;
  }
}
