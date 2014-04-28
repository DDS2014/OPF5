package domain;

import domain.Participante;
import java.util.SortedSet;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class Partido {
  private String _fecha;
  
  public String getFecha() {
    return this._fecha;
  }
  
  public void setFecha(final String fecha) {
    this._fecha = fecha;
  }
  
  private String _hora;
  
  public String getHora() {
    return this._hora;
  }
  
  public void setHora(final String hora) {
    this._hora = hora;
  }
  
  private SortedSet<Participante> jugadoresConfirmados;
  
  public Partido(final String fecha, final String hora) {
    this.setFecha(fecha);
    this.setHora(hora);
  }
  
  public boolean hayLugaresLibres() {
    int _length = ((Object[])Conversions.unwrapArray(this.jugadoresConfirmados, Object.class)).length;
    return (_length < 10);
  }
  
  public boolean confirmarAsistencia(final Participante participante) {
    boolean _add = this.jugadoresConfirmados.add(participante);
    return _add;
  }
}
