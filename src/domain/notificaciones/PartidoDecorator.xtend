package domain.notificaciones

import domain.EventoDeportivo
import domain.Jugador
import domain.inscripcion.TipoDeInscripcion
import domain.Participante
import domain.enviadorDeMails.InterfazDistribuidorDeMails

class PartidoDecorator implements EventoDeportivo
{
	@Property EventoDeportivo decorado;
	
	new(EventoDeportivo decorado)
	{
		super(); // esto es necesario?
		this.decorado = decorado;
	}
	
	override getDistribuidor()
	{
		return decorado.getDistribuidor();
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
	
	override getFecha() 
	{
		return decorado.getFecha();
	}
	
	override setDistribuidor(InterfazDistribuidorDeMails mails) 
	{
		decorado.setDistribuidor(mails);
	}
	
}