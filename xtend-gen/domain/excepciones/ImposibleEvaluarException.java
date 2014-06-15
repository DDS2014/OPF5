package domain.excepciones;

@SuppressWarnings("all")
public class ImposibleEvaluarException extends RuntimeException {
  private String motivo;
  
  public ImposibleEvaluarException(final String mensaje) {
    this.motivo = mensaje;
  }
}
