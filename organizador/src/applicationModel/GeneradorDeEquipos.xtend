package applicationModel

import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio
import domain.generacionDeEquipos.algoritmosDeGeneracion.Generacion
import domain.Jugador
import domain.Partido
import java.util.List

import java.io.Serializable
import java.util.ArrayList
import home.HomeJugadores
import home.HomePartido
import org.uqbar.commons.utils.ApplicationContext
import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDelHandicap
import domain.generacionDeEquipos.algoritmosDeGeneracion.GeneracionParImpar

@org.uqbar.commons.utils.Observable
class GeneradorDeEquipos implements Serializable
//IMPORTANTE: feature envy en todas partes??? convendrá ir desde la UI directamente a pegarle al partido?
{
	Partido partido;
	Criterio criterioDeOrdenamiento;
	Generacion criterioDeSeleccion;	
	List<Jugador> primerEquipo;
	List<Jugador> segundoEquipo;
	

	new()
	{
		this.partido = homePartido.allInstances.get(0)
		if(this.partido.hayLugaresLibres)
			this.inscribirJugadores()
		this.primerEquipo = new ArrayList<Jugador>
		this.segundoEquipo = new ArrayList<Jugador>
	}
	
	
	def generar()
	{
		this.partido.setCriterioDeOrdenamiento(this.criterioDeOrdenamiento)
		this.partido.definirAlgoritmoGeneracion(this.criterioDeSeleccion)
		this.partido.generarEquipos();
		this.refresh()
	}
	
	def inscribirJugadores(){
		var jugadores = homeJugadores.jugadores
		jugadores.forEach[j|j.inscribirse(this.partido)]
	}
	
	def refresh()
	{
		this.primerEquipo = this.partido.primerEquipo;
		this.segundoEquipo = this.partido.segundoEquipo;
	}
	
	def HomeJugadores getHomeJugadores() {
		ApplicationContext::instance.getSingleton(typeof(Jugador))
	}
	
	def HomePartido getHomePartido() {
		ApplicationContext::instance.getSingleton(typeof(Partido))
	}
}