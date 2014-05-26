package domain.enviadorDeMails.adaptadores;
/*
import domain.enviadorDeMails.DistribuidorDeMails;
import domain.enviadorDeMails.excepciones.NoSePudoEnviarElMail;//TODO: usar
import domain.enviadorDeMails.excepciones.DireccionDeEmailInvalida;;
*/

//no necesitamos realmente este adapter todavía, porque la clase concreta que envía el mail no existe
//con mockear la interfaz DistribuidorDeMails alcanza y sobra para esta entrega

/*public class DistribuidorAdapter implements DistribuidorDeMails {
	
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
*/