package domain.inscripcion


import domain.Partido
import domain.excepciones.NoHayLugarParaAnotarseException
import java.util.List
import domain.Jugadorimport java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import javax.persistence.OneToMany
import javax.persistence.CascadeType
import javax.persistence.ManyToOne
import javax.persistence.Table

public abstract class TipoDeInscripcion implements Serializable {
	int prioridad
	Jugador participante;
	int id;
	
	def getId() { id }
	def setId(int i){ id = i }

	def getPrioridad() { prioridad }
	def setPrioridad(int p) { prioridad = p }

	def getParticipante() { participante }
	def setParticipante(Jugador p) { participante = p }
	
	def void setCliente(Jugador jugador)
	{
		this.participante = jugador;
	}
	
	def void inscribir(Jugador participante, Partido partido)
	{ //OJO: ESTO YA NO RETORNA BOOLEAN
		var List<Jugador> jugadores = partido.jugadoresConfirmados.toList
		var seInscribio=false
		
		if(partido.hayLugaresLibres)
		{
		 	partido.confirmarAsistencia(participante);
		 	seInscribio =true;
			
		}
		else
		{
			var i=0
		
			while(!seInscribio && i<jugadores.size)
			{
				var saliente = jugadores.get(i) 
				seInscribio = saliente.modalidad.reemplazar(partido, participante, saliente)
				i=i+1
			}
		
		}
		
		if(!seInscribio) throw new NoHayLugarParaAnotarseException("No se encontró ningun lugar para acomodar a este jugador", partido, participante);
		
	}
	
	def abstract boolean reemplazar(Partido partido, Jugador entrante,Jugador saliente)



}