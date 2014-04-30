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
        return p.getJugador();
      }
    };
    return IterableExtensions.<Participante, Jugador>map(this.participantesConfirmados, _function);
  }
  
  public boolean hayLugaresLibres() {
    int _length = ((Object[])Conversions.unwrapArray(this.participantesConfirmados, Object.class)).length;
    return (_length < 10);
  }
  
  public void confirmarAsistencia(final Participante participante) {
    this.participantesConfirmados.add(participante);
  }
  
  public boolean estaInscripto(final Jugador jugador) {
    final Iterable<Jugador> confirmados = this.getJugadoresConfirmados();
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador j) {
        return Boolean.valueOf(Objects.equal(j, jugador));
      }
    };
    boolean _exists = IterableExtensions.<Jugador>exists(confirmados, _function);
    if (_exists) {
      return true;
    }
    return false;
  }
  
  public boolean hayCondicionales() {
    final Function1<Participante,Boolean> _function = new Function1<Participante,Boolean>() {
      public Boolean apply(final Participante participante) {
        boolean _sosCondicional = participante.sosCondicional();
        return Boolean.valueOf((_sosCondicional == true));
      }
    };
    return IterableExtensions.<Participante>exists(this.participantesConfirmados, _function);
  }
  
  public Participante getPrimerCondicional() {
    final Function1<Participante,Boolean> _function = new Function1<Participante,Boolean>() {
      public Boolean apply(final Participante participante) {
        return Boolean.valueOf(participante.sosCondicional());
      }
    };
    Iterable<Participante> condicionales = IterableExtensions.<Participante>filter(this.participantesConfirmados, _function);
    final Iterable<Participante> _converted_condicionales = (Iterable<Participante>)condicionales;
    return ((Participante[])Conversions.unwrapArray(_converted_condicionales, Participante.class))[1];
  }
  
  public boolean reemplazar(final Participante saliente, final Participante entrante) {
    boolean _xblockexpression = false;
    {
      this.participantesConfirmados.remove(saliente);
      _xblockexpression = this.participantesConfirmados.add(entrante);
    }
    return _xblockexpression;
  }
  
  public boolean haySolidarios() {
    final Function1<Participante,Boolean> _function = new Function1<Participante,Boolean>() {
      public Boolean apply(final Participante participante) {
        boolean _sosSolidario = participante.sosSolidario();
        return Boolean.valueOf((_sosSolidario == true));
      }
    };
    return IterableExtensions.<Participante>exists(this.participantesConfirmados, _function);
  }
  
  public Participante getPrimerSolidario() {
    final Function1<Participante,Boolean> _function = new Function1<Participante,Boolean>() {
      public Boolean apply(final Participante participante) {
        return Boolean.valueOf(participante.sosSolidario());
      }
    };
    Iterable<Participante> solidarios = IterableExtensions.<Participante>filter(this.participantesConfirmados, _function);
    final Iterable<Participante> _converted_solidarios = (Iterable<Participante>)solidarios;
    return ((Participante[])Conversions.unwrapArray(_converted_solidarios, Participante.class))[1];
  }
  
  public int obtenerCantidadDeInscriptos() {
    return ((Object[])Conversions.unwrapArray(this.participantesConfirmados, Object.class)).length;
  }
}
