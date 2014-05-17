package domain;

import java.util.Date;

@SuppressWarnings("all")
public class Infraccion {
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
  
  public Infraccion(final String motivo) {
    Date _date = new Date();
    this.setFecha(_date);
    this.setMotivo(motivo);
  }
}
