package domain.excepciones;

@SuppressWarnings("all")
public class ImposibleGenerarEquiposException extends RuntimeException {
  private String motivo;
  
  public ImposibleGenerarEquiposException(final String mensaje) {
    this.motivo = mensaje;
  }
}
