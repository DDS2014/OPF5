package applicationModel

import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio
import domain.generacionDeEquipos.algoritmosDeGeneracion.Generacion
import domain.Jugador
import domain.Partido
import java.util.List

import java.io.Serializable
import java.util.ArrayList
import home.HomePartido
import org.uqbar.commons.utils.ApplicationContext
import domain.generacionDeEquipos.algoritmosDeGeneracion.GeneracionConcreta
import domain.generacionDeEquipos.algoritmosDeGeneracion.GeneracionParImpar
import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDelHandicap
import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDeLasUltimasCalificaciones
import domain.sugerencias.Comunidad
import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDelUltimoPartido
import home.HomeComunidad

@org.uqbar.commons.utils.Observable
class GeneradorDeEquipos implements Serializable
//IMPORTANTE: feature envy en todas partes??? convendrá ir desde la UI directamente a pegarle al partido?
{
	Partido partido;
	Criterio criterioDeOrdenamiento; //criterio seleccionado
	Generacion criterioDeSeleccion;	 //generacion seleccionado
	List<Jugador> primerEquipo;
	List<Jugador> segundoEquipo;
	@Property ArrayList<Generacion> criteriosDeSeleccion;
	@Property ArrayList<Criterio> criteriosDeOrdenamiento;
	@Property CriterioDeLasUltimasCalificaciones criterioDeLasUltimasCalificaciones
	Comunidad comunidad

	new()
	{
		this.partido = homeComunidad.getPartidos.get(0) //me gusta el workaround "provisorio"
		if(this.partido.hayLugaresLibres)
			this.inscribirJugadores()
		
		this.agregarComunidad()
		
		this.primerEquipo = new ArrayList<Jugador>
		this.segundoEquipo = new ArrayList<Jugador>
		
		criteriosDeSeleccion = new ArrayList<Generacion>
		criteriosDeSeleccion.add(new GeneracionConcreta())
		criteriosDeSeleccion.add(new GeneracionParImpar())
		
		criteriosDeOrdenamiento = new ArrayList<Criterio>
		criteriosDeOrdenamiento.add(new CriterioDelHandicap)
		criteriosDeOrdenamiento.add(new CriterioDelUltimoPartido(comunidad))
		criterioDeLasUltimasCalificaciones = new CriterioDeLasUltimasCalificaciones()
		criteriosDeOrdenamiento.add(criterioDeLasUltimasCalificaciones)
	}
	
	def agregarComunidad(){
		  this.comunidad = new Comunidad
		  this.comunidad.organizarPartido(this.partido)
		  this.partido.jugadoresConfirmados.forEach[j|this.comunidad.agregar(j)]
	 }
	
	
	def generar()
	{
		this.partido.setCriterioDeOrdenamiento(this.criterioDeOrdenamiento)
		this.partido.definirAlgoritmoGeneracion(this.criterioDeSeleccion)
		this.partido.generarEquipos();
		this.refresh()
	}
	
	def inscribirJugadores(){
		var jugadores = homeComunidad.jugadores
		jugadores.forEach[j|j.inscribirse(this.partido)]
	}
	
	def confirmar()
	{
		this.partido.confirmarEquipos()
	}
	
	def refresh()
	{
		this.primerEquipo = new ArrayList<Jugador>
		this.segundoEquipo = new ArrayList<Jugador>
		this.primerEquipo.addAll(this.partido.primerEquipo)
		this.segundoEquipo.addAll(this.partido.segundoEquipo)
	}
	
	def HomeComunidad getHomeComunidad() {
		ApplicationContext::instance.getSingleton(typeof(Comunidad))
	}
	
//	def HomePartido getHomePartido() {
//		ApplicationContext::instance.getSingleton(typeof(Partido))
//	}
}