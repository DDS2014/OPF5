package domain.enviadorDeMails.excepciones;

public class DireccionDeEmailInvalida extends RuntimeException {
	
	public DireccionDeEmailInvalida(String direccionEmail){
		super("La direccion de email "+ direccionEmail + " no existe o se encuentra mal escrita.");
	}

}