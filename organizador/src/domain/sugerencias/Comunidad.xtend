package domain.sugerencias

import domain.Jugador
import java.util.HashSet
import domain.inscripcion.TipoDeInscripcion
import domain.Partido
import java.util.ArrayList
import java.util.Comparator
import java.util.Collectionsimport domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDelUltimoPartido
import java.io.Serializable

public class Comunidad implements Comparator<Partido>, Serializable{
	@Property ArrayList<Jugador> aprobados
	@Property HashSet<Sugerencia> pendientes
	@Property HashSet<Denegacion> rechazados
	@Property ArrayList<Partido> partidos
	
	new(){
		this.aprobados= new ArrayList();
		this.pendientes=new HashSet();
		this.rechazados=new HashSet();
		this.partidos = new ArrayList();
	}
	
	def agregar(Jugador jugador) //para agregar jugadores "por decreto", sin pasar por el sistema de sugerencias
	{
		this.aprobados.add(jugador); 
	}
	
	def organizarPartido(Partido partido)
	{
		this.partidos.add(partido);
	}
	
	def sugerir(Sugerencia sugerencia){
		this.pendientes.add(sugerencia)
	}
	
	def aprobar(Sugerencia sugerencia,TipoDeInscripcion modalidad){
		this.pendientes.remove(sugerencia)//Debe volver uno solo porque es un hashSet
		val jugador = sugerencia.aprobar(modalidad)
		this.aprobados.add(jugador)
		return jugador
	}
	
	def rechazar(Sugerencia sugerencia, String motivo){
		this.pendientes.remove(sugerencia)
		val denegacion = sugerencia.denegar(motivo);
		this.rechazados.add(denegacion)
	}

	def ultimoPartido() 
	{
		Collections.sort(this.partidos, this);
		return partidos.get(0);

	}
	
	def promedioUltimoPartido(Jugador jugador)
	{
		new CriterioDelUltimoPartido(this).evaluarJugador(jugador)
	}

	override compare(Partido arg0, Partido arg1) //ordena los partidos del más reciente al más viejo
	{
		if(arg0.fecha < arg1.fecha)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}

}