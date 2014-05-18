package domain.enviadorDeMails;

import domain.enviadorDeMails.excepciones.NoSePudoEnviarElMail;
import domain.enviadorDeMails.excepciones.DireccionDeEmailInvalida;;

public interface DistribuidorDeMails {

	
	/**
	 * Envia el mail a destino
	 * @param emisor: quien envia el mail
	 * @param usuario: quien recibe el mail
	 * @param fechaDeEnvio: fecha del mensaje //NO VA
	 * @param subject: asunto
	 * @param body: contenido
	 * @param estaFirmado: true si le adosaron un certificado //NO VA
	 * @param tieneImagenes: true si en el contenido trae imagenes //NO VA
	 * @throws NoSePuedenMandarMailsEnElFututo: En caso de que se pase una fecha superior a hoy
	 * @throws NoSePuedenMandarMailsPocoDescriptivos: En caso de que el subject no cumpla con nuestros parametros de calidad //NO VA
	 * @throws NoSePudoEnviarElMail: En cualquier otro caso
	 */
	public void enviarMail(
			//String emisor, 
			String receptor,
			String subject, 
			String body) throws DireccionDeEmailInvalida, NoSePudoEnviarElMail;
}