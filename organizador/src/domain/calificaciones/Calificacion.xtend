package domain.calificaciones

import domain.Jugador
import domain.Partido
import java.io.Serializable
import java.util.Date
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name="calificaciones")
public class Calificacion implements Serializable {
	private Long id
	int puntaje
	String critica
	Partido partido
	Jugador calificador
	Date fecha
	
	new(int puntaje,String critica,Partido partido,Jugador calificador){
		this.puntaje=puntaje
		this.critica=critica
		this.partido=partido
		this.calificador=calificador
		this.fecha = new Date();
	} 
	
//	new (int puntaje){
//		this.puntaje=puntaje
//	}
	
	//constructor sin parametros para hibernate
	new()
	{
		
	}	
	
	//getters y setters para hibernate
	@Id
	@GeneratedValue
	@Column(name="Id_Calificacion")
	def getId() {id}
	def setId(Long value) {id = value}
	
	@Column(name="Puntaje")
	def getPuntaje() { puntaje }
	def setPuntaje(int p) { puntaje = p }
	
	@Column(name="Critica")
	def getCritica() { critica }
	def setCritica(String c) { critica = c }
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Id_Partido")
	def getPartido() { partido }
	def setPartido(Partido p) { partido = p }
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Id_JugadorCalificador")
	def getCalificador() { calificador }
	def setCalificador(Jugador c) { calificador = c }

	@Column(name="Fecha")
	def getFecha() { fecha }
	def setFecha(Date f) { fecha = f }	
	
}