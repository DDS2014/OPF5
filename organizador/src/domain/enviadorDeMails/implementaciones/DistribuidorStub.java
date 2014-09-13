package domain.enviadorDeMails.implementaciones;

import domain.enviadorDeMails.InterfazDistribuidorDeMails;
//import domain.enviadorDeMails.excepciones.NoSePudoEnviarElMail;//TODO: usar
import domain.enviadorDeMails.excepciones.DireccionDeEmailInvalida;

public class DistribuidorStub implements InterfazDistribuidorDeMails {
	
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
