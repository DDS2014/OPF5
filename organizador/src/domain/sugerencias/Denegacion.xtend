package domain.sugerencias

import java.util.Date
import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column

@Entity
@Table(name="Denegaciones")
public class Denegacion implements Serializable{
	private Long id
	String nombre;
	Date fecha;
	String motivo;

	
	new(String nombre, String motivo){
		this.fecha = new Date;
		this.motivo=motivo;
		this.nombre = nombre;
	}
	
	new(){}
	
	@Id
	@GeneratedValue
	@Column(name="Id_Denegacion")
	def getId() {id}
	def setId(Long value) {id = value}
	@Column(name="Fecha") 
	def getFecha()	{ fecha }
	def setFecha(Date f) { fecha = f }
	@Column(name="Motivo")
	def getMotivo() { motivo }
	def setMotivo(String m) { motivo = m }
	@Column(name="Nombre")
	def getNombre() { nombre }
	def setNombre(String a) { nombre = a }
}