package domain.calificaciones;

import domain.Jugador;
import domain.Partido;
import java.util.Date;

@SuppressWarnings("all")
public class Calificacion {
  private int _puntaje;
  
  public int getPuntaje() {
    return this._puntaje;
  }
  
  public void setPuntaje(final int puntaje) {
    this._puntaje = puntaje;
  }
  
  private String _critica;
  
  public String getCritica() {
    return this._critica;
  }
  
  public void setCritica(final String critica) {
    this._critica = critica;
  }
  
  private Partido _partido;
  
  public Partido getPartido() {
    return this._partido;
  }
  
  public void setPartido(final Partido partido) {
    this._partido = partido;
  }
  
  private Jugador _calificador;
  
  public Jugador getCalificador() {
    return this._calificador;
  }
  
  public void setCalificador(final Jugador calificador) {
    this._calificador = calificador;
  }
  
  private Date _fecha;
  
  public Date getFecha() {
    return this._fecha;
  }
  
  public void setFecha(final Date fecha) {
    this._fecha = fecha;
  }
  
  public Calificacion(final int puntaje, final String critica, final Partido partido, final Jugador calificador) {
    this.setPuntaje(puntaje);
    this.setCritica(critica);
    this.setPartido(partido);
    this.setCalificador(calificador);
    Date _date = new Date();
    this.setFecha(_date);
  }
}
