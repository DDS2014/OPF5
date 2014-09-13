package domain.excepciones

class ImposibleEvaluarException extends RuntimeException //todo agregar comportamiento especifico
{
	String motivo;
	
	new(String mensaje)
	{
		this.motivo = mensaje;
	}
}

