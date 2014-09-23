package domain.excepciones

import org.uqbar.commons.model.UserException

class ImposibleEvaluarException extends UserException //todo agregar comportamiento especifico
{
	String motivo;
	
	new(String mensaje)
	{
		super(mensaje)
		this.motivo = mensaje;
	}
}

