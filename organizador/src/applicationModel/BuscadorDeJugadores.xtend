package applicationModel

import java.io.Serializable
import java.util.List
import domain.Jugador
import domain.busqueda.CriterioBusqueda
import home.HomeJugadores
import java.util.ArrayList
import org.uqbar.commons.utils.ApplicationContext

@org.uqbar.commons.utils.Observable
class BuscadorDeJugadores implements Serializable
{
	//clase que debería tener un campo por cada textbox de cada criterio, y una colección de resultados
	@Property List<Jugador> resultados 
	
	// ********************************************************
	// ** Acciones
	// ********************************************************
	def void search(CriterioBusqueda criterio) { 
		// WORKAROUND para que refresque la grilla en las actualizaciones
		resultados = new ArrayList<Jugador>

		// FIN WORKAROUND
		resultados = getHomeCelulares().search(criterio)
		// también se puede llamar homeCelulares.search(numero, nombre) 
	}
	
	def void clear() {
	}
	
	def HomeJugadores getHomeCelulares() {
		ApplicationContext::instance.getSingleton(typeof(Jugador))
	}
}