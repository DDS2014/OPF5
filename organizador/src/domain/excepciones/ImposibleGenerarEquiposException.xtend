package domain.excepciones

class ImposibleGenerarEquiposException extends RuntimeException  
{
	String motivo;
	
	new(String mensaje)
	{
		this.motivo = mensaje;
	}
}