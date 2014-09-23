package domain.excepciones

import org.uqbar.commons.model.UserException

class ImposibleGenerarEquiposException extends UserException //para que pueda mostrarse por el feedback panel, y no me rompa wicket
{
	String motivo;
	
	new(String mensaje)
	{
		super(mensaje)
		this.motivo = mensaje;
	}
}