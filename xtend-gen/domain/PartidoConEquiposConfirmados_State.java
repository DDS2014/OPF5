package domain;

import domain.PartidoState;

@SuppressWarnings("all")
public class PartidoConEquiposConfirmados_State extends PartidoState {
  public void validarCambios() {
    RuntimeException _runtimeException = new RuntimeException("Esta operación no puede hacerse para un partido que tiene los equipos confirmados");
    throw _runtimeException;
  }
}
