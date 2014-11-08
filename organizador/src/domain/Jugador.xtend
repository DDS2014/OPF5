package domain

import domain.calificaciones.Calificacion
import domain.excepciones.ImposibleBajarseException
import domain.excepciones.ImposibleCalificarException
import domain.infracciones.Infraccion
import domain.inscripcion.TipoDeInscripcion
import java.io.Serializable
import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table
import org.uqbar.commons.utils.Observable

@Entity
@Table(name="Jugadores")
@Observable
public class Jugador  implements Comparator<Calificacion>, Serializable 
{

	private Long id
	String nombre
	String apellido
	String apodo
	int edad
	double handicap
	String documento
	String email
	TipoDeInscripcion modalidad
	ArrayList<Jugador> amigos;
	ArrayList<Infraccion> infracciones;
	ArrayList<Calificacion> calificaciones;
	Date fechaNacimiento;
	
	
	new(String nombre,int edad, TipoDeInscripcion modalidad)
	{
		this.nombre=nombre
		this.edad=edad
		this.amigos = new ArrayList();
		this.infracciones = new ArrayList();
		this.modalidad = modalidad;
		modalidad.setCliente(this);
		this.calificaciones=new ArrayList();
	}
	
	new() {
		this.amigos = new ArrayList();
		this.infracciones = new ArrayList();
		this.calificaciones=new ArrayList();
	}
	

	@Id
	@GeneratedValue
	@Column(name="Id_Jugador")
	def getId() {id}
	def setId(Long value) {id = value}
	@Column(name="Nombre") 
	def getNombre()	{ nombre }
	def setNombre(String n) { nombre = n }
	@Column(name="Apellido")
	def getApellido() { apellido }
	def setApellido(String a) { apellido = a }
	@Column(name="Apodo")
	def getApodo() { apodo }
	def setApodo(String a) { apodo = a }
	@Column(name="Edad")
	def getEdad() { edad }
	def setEdad(int e) { edad = e }
	@Column(name="Handicap")
	def getHandicap() { handicap }
	def setHandicap(double h) { handicap = h }
	@Column(name="Documento")
	def getDocumento () { documento }
	def setDocumento(String d) { documento = d }
	@Column(name="Email")
	def getEmail() { email }
	def setEmail(String e) { email = e }
	@ManyToOne
	def getModalidad () { modalidad }
	def setModalidad (TipoDeInscripcion m) { modalidad = m }
	@ManyToMany
	def getAmigos() { amigos }
	def setAmigos(ArrayList<Jugador> a) { amigos = a}
	@OneToMany
	def getInfracciones() { infracciones }
	def setInfracciones (ArrayList<Infraccion> i) { infracciones = i }
	@OneToMany
	def getCalificaciones() { calificaciones }
	def setCalificaciones(ArrayList<Calificacion> c ) { calificaciones = c }
	@Column(name="FechaNacimiento")
	def getFechaNacimiento() { fechaNacimiento }
	def setFechaNacimiento(Date f) { fechaNacimiento = f }

	//la amistad se hace en dos pasos para que haya simetría (si yo soy tu amigo, vos sos mi amigo)	
	def hacerseAmigoDe(Jugador nuevoAmigo)
	//método que debe usarse desde afuera para hacer amigos a dos jugadores
	{
		this.confirmarAmistad(nuevoAmigo);
		nuevoAmigo.confirmarAmistad(this);
	}
	
	
	def confirmarAmistad(Jugador nuevoAmigo)
	//este método es el que agrega al nuevo amigo
	{
		this.amigos.add(nuevoAmigo);
	}
	
	def boolean tieneAlAmigo(Jugador amigo)
	{
		return this.amigos.exists([a | a == amigo]);
	}
	
	def void inscribirse(Partido partido)
	{
		modalidad.inscribir(this,partido);
	}
	
	
	def bajarse(Partido partido)
	{
		if (!partido.estaInscripto(this)) throw new ImposibleBajarseException("No puede darse de baja al jugador.", partido, this);
		partido.quitarSinReemplazo(this);
	}
	
	def bajarse(Partido partido, Jugador reemplazante)
	{
		if (!partido.estaInscripto(this)) throw new ImposibleBajarseException("El jugador no puede ser reemplazado.", partido, this);
		partido.reemplazar(reemplazante, this);
	}
	
	def aplicarInfraccion(Infraccion infraccion) 
	{
		this.infracciones.add(infraccion);
	}
	
	//CALIFICACIONES
	def calificar(int puntaje, String critica, Partido partido, Jugador calificador){
		
		if (!partido.estaInscripto(this)) throw new ImposibleCalificarException("El jugador no se encuentra inscripto.", partido, this);
		if (this.estaCalificado(partido,calificador)) throw new ImposibleCalificarException("El jugador ya fue calificado.", partido, this);
		if(this==calificador) throw new ImposibleCalificarException("El jugador no puede calificarse a si mismo.", partido, this);		
		var calificacion = new Calificacion(puntaje,critica,partido,calificador)
		this.calificaciones.add(calificacion)
		Collections.sort(this.calificaciones, this);
	}

	def boolean estaCalificado(Partido partido, Jugador calificador){
		this.calificaciones.exists[c|c.partido==partido && c.calificador==calificador]
	}
	
	
	override compare(Calificacion arg0, Calificacion arg1) //ordena las calificaciones de la más reciente a la más vieja
	{
		if(arg0.getFecha() > arg1.getFecha())
		{
			return -1;
		}
		else
		{
			return 1;
		}
		
	}
	

	
	def double promedioGlobal(){
		if (this.calificaciones.isEmpty)
		return 0
		else
		{var suma = 0 as double
		var cantidadAPromediar = calificaciones.length()
		var puntajesAPromediar = calificaciones.map[calif | calif.getPuntaje()]
		for(puntaje:puntajesAPromediar)
		{suma = suma + puntaje}
		return suma/cantidadAPromediar
		}
	}
	
	def Boolean tieneInfracciones(){
		return this.infracciones.length>0
	}
}