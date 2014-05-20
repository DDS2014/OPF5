package domain.notificaciones

import domain.EventoDeportivo
import domain.inscripcion.TipoDeInscripcion


class notificarAmigosDecorator extends PartidoDecorator 
{
	
	new(EventoDeportivo decorado) // no entiendo por qué Eclipse me dice que esto es necesario pero bueno
	{
		super(decorado)
	}
	
	override inscribir(TipoDeInscripcion modalidad)
	{
		// no quiero hacer nada antes
		
		
		var fueInscripto = decorado.inscribir(modalidad); //esto es porque tengo que retornar lo que retorne el decorado, pero no quiero que el método termine acá
		
		
		//hago algo despues
		if(fueInscripto)
		{
			val subject = "Me anote a un partido!"
			val body = modalidad.participante.jugador.nombre+" se inscribió al partido del "+decorado.fecha.toString();
		
			modalidad.participante.jugador.amigos.forEach[j|decorado.distribuidor.enviarMail(j.email,subject,body)]
		}
		
		return fueInscripto;
		
	}
	
	
}