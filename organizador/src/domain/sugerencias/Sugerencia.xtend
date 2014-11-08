package domain.sugerencias


import java.util.HashSet
import domain.Jugador
import domain.inscripcion.TipoDeInscripcion
import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import java.util.ArrayList

@Entity
@Table(name="Sugerencias")
public class Sugerencia implements Serializable{
	private Long id
	String nombre
	String apellido
	int edad
	String documento
	String email
	HashSet<Jugador> amigos;
	
	new(String nombre,int edad)
	{
		this.nombre=nombre
		this.edad=edad
		this.amigos = new HashSet();
	}
	
	new(){
		this.amigos = new HashSet();
	}
	
	@Id
	@GeneratedValue
	@Column(name="Id_Sugerencia")
	def getId() {id}
	def setId(Long value) {id = value}
	@Column(name="Nombre") 
	def getNombre()	{ nombre }
	def setNombre(String n) { nombre = n }
	@Column(name="Apellido")
	def getApellido() { apellido }
	def setApellido(String a) { apellido = a }
	@Column(name="Edad")
	def getEdad() { edad }
	def setEdad(int h) { edad = h }
	@Column(name="Documento")
	def getDocumento () { documento }
	def setDocumento(String d) { documento = d }
	@Column(name="Email")
	def getEmail() { email }
	def setEmail(String e) { email = e }
	
	def getAmigos(){ amigos }
	def setAmigos(HashSet<Jugador> a){ amigos = a }
	
	
	
	def Jugador aprobar(TipoDeInscripcion modalidad){
		val jugador = new Jugador(this.nombre,this.edad,modalidad)
		return jugador;
	}
	
	def Denegacion denegar(String motivo)
	{
		val denegacion = new Denegacion(this.nombre, motivo);
		return denegacion;
	}
}