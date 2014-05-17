package domain;

import domain.Jugador;
import domain.Partido;
import domain.PartidoObserver;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class NotificarAmigosObserver implements PartidoObserver {
  public void notificarConfirmacionJugador(final Partido partido) {
    List<Jugador> _jugadoresConfirmados = partido.jugadoresConfirmados();
    final Consumer<Jugador> _function = new Consumer<Jugador>() {
      public void accept(final Jugador jugador) {
        jugador.avisarAmigos();
      }
    };
    _jugadoresConfirmados.forEach(_function);
  }
}
