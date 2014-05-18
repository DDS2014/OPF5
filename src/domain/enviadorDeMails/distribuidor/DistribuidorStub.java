package domain.enviadorDeMails.distribuidor;

import domain.enviadorDeMails.DistribuidorDeMails;
import domain.enviadorDeMails.excepciones.NoSePudoEnviarElMail;//TODO: usar
import domain.enviadorDeMails.excepciones.DireccionDeEmailInvalida;

public class DistribuidorStub implements DistribuidorDeMails {
	
	@Override
	public void enviarMail(String receptor, String subject, String body){
		
		if(this.DireccionDeMailIncorrecta(receptor)){
			throw new DireccionDeEmailInvalida(receptor);
		}
		
		//Aca estaria el envio del mail
	}
	
	public boolean DireccionDeMailIncorrecta(String direccionDeEmail){
		return (direccionDeEmail==null || !direccionDeEmail.contains("@"));
	}
}
