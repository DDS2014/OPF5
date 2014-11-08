package domain.infracciones

import java.util.Date
import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column

@Entity
@Table(name="Infracciones")
class Infraccion implements Serializable
{
	private Long id
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
	@Id
	@GeneratedValue
	@Column(name="Id_Jugador")
	def getId(){id}
	def setId(Long i){id=i}
	@Column(name="Fecha")
	def getFecha() { fecha }
	def setFecha(Date f) { fecha = f }
	@Column(name="Motivo")
	def getMotivo() { motivo }
	def setMotivo(String m) { motivo = m }
	

}