package domain.enviadorDeMails.distribuidor;

import domain.enviadorDeMails.DistribuidorDeMails;
import domain.enviadorDeMails.excepciones.NoSePudoEnviarElMail;//TODO: usar
import domain.enviadorDeMails.excepciones.DireccionDeEmailInvalida;;

public class DistribuidorAdapter implements DistribuidorDeMails {
	
	@Override
	public void dispararMensajeALasDirecciones(
			String emisor, String receptor, String subject, String body){
		
		if(this.DireccionDeMailIncorrecta(emisor)){
			throw new DireccionDeEmailInvalida(emisor);
		}
		
		if(this.DireccionDeMailIncorrecta(receptor)){
			throw new DireccionDeEmailInvalida(receptor);
		}
	}
	
	public boolean DireccionDeMailIncorrecta(String direccionDeEmail){
		return direccionDeEmail.contains("@");
	}
}
