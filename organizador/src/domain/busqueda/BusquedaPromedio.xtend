package domain.busqueda 
import domain.Jugador
import org.uqbar.commons.model.UserException
import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDelUltimoPartido
import home.HomeComunidad
import org.uqbar.commons.utils.ApplicationContext
import domain.sugerencias.Comunidad

class BusquedaPromedio extends CriterioBusqueda{
	@Property Double desde
	@Property Double hasta
	
	new(){
		super("Promedio")
	}
	
	def override match(Jugador j){
		val promedio = getHomeComunidad().promedioUltimoPartido(j)
		return promedio >= desde && promedio <= hasta
	}
	
	def override validar(){
		if(desde == null)
			throw new UserException("Debe ingresar un número en el campo desde.")
		
		if(hasta == null)
			throw new UserException("Debe ingresar un número en el campo hasta.")
		
		if(desde>hasta)
			throw new UserException("El campo desde no puede ser mayor al campo hasta.")
	}
	
	def HomeComunidad getHomeComunidad() {
		ApplicationContext::instance.getSingleton(typeof(Comunidad))
	}
}