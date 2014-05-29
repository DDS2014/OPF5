//package domain
//
//import domain.excepciones.ImposibleBajarseException
//import domain.inscripcion.TipoDeInscripcion
//import java.util.Date
//
//public class Participante {
//	@Property Jugador jugador
//	@Property Date fechaInscripcion//Por ahora no se esta usando
//	@Property TipoDeInscripcion modalidad
//	
//	new(Jugador jugador){
//		this.jugador=jugador
//		this.fechaInscripcion=new Date
//	}
	
//	def void inscribirse(Partido partido)
//	{
//		modalidad.inscribir(this,partido);
//	}
	
//	def bajarse(Partido partido)
//	{
//		if (!partido.estaInscripto(this.jugador)) throw new ImposibleBajarseException("El jugador no está inscripto a ese partido", partido, this);
//		partido.quitarSinReemplazo(this);
//	}
//	
//	def bajarse(Partido partido, Participante reemplazante)
//	{
//		if (!partido.estaInscripto(this.jugador)) throw new ImposibleBajarseException("El jugador no está inscripto a ese partido", partido, this);
//		partido.reemplazar(reemplazante, this);
//	}
//}