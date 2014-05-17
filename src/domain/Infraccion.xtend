package domain

import java.util.Date

class Infraccion 
{
	@Property Date fecha;
	@Property String motivo;
	
	new(String motivo)
	{
		this.fecha = new Date();
		this.motivo = motivo;
	}
	

}