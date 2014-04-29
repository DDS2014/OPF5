package domain;

import com.google.common.base.Objects;
import domain.InscripcionCondicional;
import domain.InscripcionSolidaria;
import domain.Jugador;
import domain.Participante;
import domain.TipoDeInscripcion;
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
      public Boolean apply(final Participante jugador) {
        TipoDeInscripcion _modalidad = jugador.getModalidad();
        return Boolean.valueOf(Objects.equal(_modalidad, InscripcionCondicional.class));
      }
    };
    return IterableExtensions.<Participante>exists(this.participantesConfirmados, _function);
  }
  
  public Participante getPrimerCondicional() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
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
      public Boolean apply(final Participante jugador) {
        TipoDeInscripcion _modalidad = jugador.getModalidad();
        return Boolean.valueOf(Objects.equal(_modalidad, InscripcionSolidaria.class));
      }
    };
    return IterableExtensions.<Participante>exists(this.participantesConfirmados, _function);
  }
  
  public Participante getPrimerSolidario() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public int obtenerCantidadDeInscriptos() {
    return ((Object[])Conversions.unwrapArray(this.participantesConfirmados, Object.class)).length;
  }
}
