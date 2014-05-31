package domain.sugerencias;

import domain.sugerencias.Sugerencia;
import java.util.Date;

@SuppressWarnings("all")
public class Denegacion {
  private Date _fecha;
  
  public Date getFecha() {
    return this._fecha;
  }
  
  public void setFecha(final Date fecha) {
    this._fecha = fecha;
  }
  
  private String _motivo;
  
  public String getMotivo() {
    return this._motivo;
  }
  
  public void setMotivo(final String motivo) {
    this._motivo = motivo;
  }
  
  private Sugerencia _sugerencia;
  
  public Sugerencia getSugerencia() {
    return this._sugerencia;
  }
  
  public void setSugerencia(final Sugerencia sugerencia) {
    this._sugerencia = sugerencia;
  }
  
  public Denegacion(final Sugerencia sugerencia, final String motivo) {
    Date _date = new Date();
    this.setFecha(_date);
    this.setMotivo(motivo);
    this.setSugerencia(sugerencia);
  }
}
