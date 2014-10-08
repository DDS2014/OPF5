package applicationModel

import java.io.Serializable
import java.util.List
import domain.Jugador
import java.util.ArrayList
import org.uqbar.commons.utils.ApplicationContext
import java.util.Date
import domain.busqueda.*
import domain.sugerencias.Comunidad
import home.HomeComunidad

@org.uqbar.commons.utils.Observable
class BuscadorDeJugadores implements Serializable
{
	//RESULTADOS
	@Property List<Jugador> resultados
	 
	//CAMPOS DE CRITERIO DE BUSQUEDA
	@Property CriterioBusqueda criterio
	@Property List<CriterioBusqueda> criteriosDisponibles
	@Property BusquedaNombre criterioNombre
	@Property BusquedaApodo criterioApodo
	@Property BusquedaEdad criterioEdad
	@Property BusquedaHandicap criterioHandicap
	@Property BusquedaPromedio criterioPromedio
	@Property BusquedaCompuesta criterioInfracciones
	
	// ********************************************************
	// ** Init
	// ********************************************************
	new(){
		this.createCriterios
	}
	
	def createCriterios(){
		this.criteriosDisponibles = new ArrayList<CriterioBusqueda>
		this.criterioNombre = new BusquedaNombre
		criteriosDisponibles.add(this.criterioNombre)
		this.criterioApodo = new BusquedaApodo
		criteriosDisponibles.add(this.criterioApodo)
		this.criterioEdad = new BusquedaEdad
		criteriosDisponibles.add(this.criterioEdad)
		this.criterioHandicap = new BusquedaHandicap
		criteriosDisponibles.add(this.criterioHandicap)
		this.criterioPromedio = new BusquedaPromedio
		criteriosDisponibles.add(this.criterioPromedio)
		this.criterioInfracciones = new BusquedaCompuesta("Infracciones")
		this.criterioInfracciones.criterios.add(new BusquedaInfracciones("Todos",null))
		this.criterioInfracciones.criterios.add(new BusquedaInfracciones("Con infracciones",true))
		this.criterioInfracciones.criterios.add(new BusquedaInfracciones("Sin infracciones",false))
		this.criteriosDisponibles.add(this.criterioInfracciones)
	}
	
	def HomeComunidad getHomeComunidad() {
		ApplicationContext::instance.getSingleton(typeof(Comunidad))
	}
	
	// ********************************************************
	// ** Acciones
	// ********************************************************
	def void search() { 
		resultados = new ArrayList<Jugador>
		resultados = getHomeComunidad().search(this.criterio)
	}
	
	def void clear() {
		this.criterio = null
		this.criterioNombre.nombre = null
		this.criterioApodo.apodo = null
		this.criterioEdad.fecha = null
		this.criterioHandicap.desde = null
		this.criterioHandicap.hasta = null//TODO: ver cuanto es el máximo de handicap
		this.criterioPromedio.desde = null
		this.criterioPromedio.hasta = null
		this.search()
	}
}