package domain.notificaciones

import domain.EventoDeportivo
import domain.Jugador
import domain.inscripcion.TipoDeInscripcion
import domain.Participante

class PartidoDecorator implements EventoDeportivo
{
	EventoDeportivo decorado;
	
	new(EventoDeportivo decorado)
	{
		super(); // esto es necesario?
		this.decorado = decorado;
	}
	
	override jugadoresConfirmados() 
	{
		return decorado.jugadoresConfirmados();
	}
	
	override estaInscripto(Jugador jugador) 
	{
		return decorado.estaInscripto(jugador);
	}
	
	override inscribir(TipoDeInscripcion modalidad) 
	{
		return decorado.inscribir(modalidad);
	}
	
	override hayLugaresLibres() 
	{
		return decorado.hayLugaresLibres();
	}
	
	override confirmarAsistencia(Participante participante) 
	{
		return decorado.confirmarAsistencia(participante);
	}
	
	override reemplazar(Participante entrante, Participante saliente) 
	{
		return decorado.reemplazar(entrante, saliente);
	}
	
	override quitarSinReemplazo(Participante participante) 
	{
		decorado.quitarSinReemplazo(participante);
	}
	
}