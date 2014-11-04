package domain.infracciones

import java.util.Date

class Infraccion 
{
	Date fecha;
	String motivo;
	
	new(String motivo)
	{
		this.fecha = new Date();
		this.motivo = motivo;
	}
	
	//constructor sin parametros para hibernate
	new()
	{
		
	}
	
	//getters y setters para hibernate
	def getFecha() { fecha }
	def setFecha(Date f) { fecha = f }
	def getMotivo() { motivo }
	def setMotivo(String m) { motivo = m }
	

}