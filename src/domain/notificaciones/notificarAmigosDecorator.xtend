package domain.notificaciones

import domain.EventoDeportivo
import domain.inscripcion.TipoDeInscripcion


class NotificarAmigosDecorator extends PartidoDecorator 
{
	
	new(EventoDeportivo decorado) // no entiendo por qué Eclipse me dice que esto es necesario pero bueno
	{
		super(decorado)
	}
	
	override inscribir(TipoDeInscripcion modalidad)
	{
		// no quiero hacer nada antes
		
		decorado.inscribir(modalidad); //notar que si hay algún problema va a haber una excepción por acá, no voy a verificar que se haya inscripto o no con un if
		
		//hago algo despues
		val subject = "Me anote a un partido!"
		val body = modalidad.participante.jugador.nombre+" se inscribió al partido del "+decorado.fecha.toString();
		modalidad.participante.jugador.amigos.forEach[j|decorado.distribuidor.enviarMail(j.email,subject,body)]
		
		
	}
	
	
}