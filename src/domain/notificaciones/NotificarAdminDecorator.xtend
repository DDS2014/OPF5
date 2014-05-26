package domain.notificaciones

import domain.EventoDeportivo
import domain.inscripcion.TipoDeInscripcion
import domain.Partido
import domain.Participante

class NotificarAdminDecorator extends PartidoDecorator
{
	new(EventoDeportivo decorado) // no entiendo por qué Eclipse me dice que esto es necesario pero bueno
	{
		super(decorado)
	}
	
	override inscribir(TipoDeInscripcion modalidad)
	{
		//hacer algo antes
		var habiaLugar = decorado.hayLugaresLibres();
		
		decorado.inscribir(modalidad); 

		//hacer algo después
		var hayLugarAhora = decorado.hayLugaresLibres();
		
		if(habiaLugar && !hayLugarAhora) //es decir que se llenó el partido
		{
			var subject = "Partido Confirmado"
			var body = "Todas las plazas del partido fueron confirmadas"
			decorado.distribuidor.enviarMail(Partido.MAIL_ADMINISTRADOR,subject,body)
		}
		
	}
	
	override quitarSinReemplazo(Participante participante)
	{
		//hacer algo antes
		var estabaConfirmado = !(decorado.hayLugaresLibres());
	
		//llamar al decorado
		decorado.quitarSinReemplazo(participante);
		
		//hacer algo después
		var estaConfirmadoAhora = !(decorado.hayLugaresLibres());
		
		if(estabaConfirmado && !estaConfirmadoAhora)
		{
			var subject = "Partido Indefinido"
			var body = "El partido dejó de tener todas las plazas confirmadas. El jugador " + participante.jugador.nombre + " se bajó del partido."
			
			decorado.distribuidor.enviarMail(Partido.MAIL_ADMINISTRADOR,subject,body)
		}
		
	
		
	}
	
}