package home

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.CollectionBasedHome
import domain.Jugador
import domain.busqueda.CriterioBusqueda
import domain.inscripcion.TipoDeInscripcion
import domain.inscripcion.InscripcionEstandar
import domain.inscripcion.InscripcionSolidaria

@Observable
class HomeJugadores extends CollectionBasedHome<Jugador> {
	new() {
		this.init
	}
	
	def void init() {
		this.create("Juan","Juancito",new InscripcionEstandar)
		this.create("Jose","Pepe",new InscripcionEstandar)
		this.create("Nicolás","Nico",new InscripcionSolidaria)
	}
	
	// ********************************************************
	// ** Altas y bajas
	// ********************************************************
	def void create(String nombre, String apodo, TipoDeInscripcion modalidad) {
		var jugador = new Jugador()
		jugador.nombre = nombre
		jugador.apodo = apodo
		modalidad.setCliente(jugador);
		this.create(jugador)
	}
	
	// ********************************************************
	// ** Búsquedas
	// ********************************************************
	def search(CriterioBusqueda criterio) {
		criterio.buscar(allInstances)
	}
	
	override protected getCriterio(Jugador example) {
		null
	}
	
	override createExample() {
		new Jugador()
	}
	
	override getEntityType() {
		typeof(Jugador)
	}
	
}