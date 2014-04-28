package domain;

import com.google.common.base.Objects;
import domain.Jugador;
import domain.Participante;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

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
  
  private Set<Participante> participantesConfirmados;
  
  public Partido(final String fecha, final String hora) {
    this.setFecha(fecha);
    this.setHora(hora);
    HashSet<Participante> _hashSet = new HashSet<Participante>();
    this.participantesConfirmados = _hashSet;
  }
  
  public Iterable<Jugador> getJugadoresConfirmados() {
    final Function1<Participante,Jugador> _function = new Function1<Participante,Jugador>() {
      public Jugador apply(final Participante p) {
        Jugador _jugador = p.getJugador();
        return _jugador;
      }
    };
    return IterableExtensions.<Participante, Jugador>map(this.participantesConfirmados, _function);
  }
  
  public boolean hayLugaresLibres() {
    int _length = ((Object[])Conversions.unwrapArray(this.participantesConfirmados, Object.class)).length;
    return (_length < 10);
  }
  
  public boolean confirmarAsistencia(final Participante participante) {
    boolean _add = this.participantesConfirmados.add(participante);
    return _add;
  }
  
  public boolean estaInscripto(final Jugador jugador) {
    final Iterable<Jugador> confirmados = this.getJugadoresConfirmados();
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador j) {
        boolean _equals = Objects.equal(j, jugador);
        return Boolean.valueOf(_equals);
      }
    };
    boolean _exists = IterableExtensions.<Jugador>exists(confirmados, _function);
    if (_exists) {
      return true;
    }
    return false;
  }
  
  public void getJugador() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
}
