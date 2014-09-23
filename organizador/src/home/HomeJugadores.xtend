package home

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.CollectionBasedHome
import domain.Jugador
import domain.busqueda.CriterioBusqueda
import domain.inscripcion.TipoDeInscripcion
import domain.inscripcion.InscripcionEstandar

@Observable
class HomeJugadores extends CollectionBasedHome<Jugador> {
	new() {
		this.init
	}
	
	def void init() {
		this.create("Juan","Juancito",new InscripcionEstandar,9)
		this.create("Jose","Pepe",new InscripcionEstandar,6)
		this.create("Nicolás","Nico",new InscripcionEstandar,10)
		this.create("Diego","Diego",new InscripcionEstandar,6)
		this.create("Roberto","Tito",new InscripcionEstandar,7)
		this.create("Jorge","Jorge",new InscripcionEstandar,6)
		this.create("Pablo","Pablo",new InscripcionEstandar,6)
		this.create("Hernán","Hernán",new InscripcionEstandar,9)
		this.create("Esteban","Esteban",new InscripcionEstandar,6)
		this.create("Alberto","Beto",new InscripcionEstandar,6)
	}
	
	// ********************************************************
	// ** Altas y bajas
	// ********************************************************
	def void create(String nombre, String apodo, TipoDeInscripcion modalidad, double handicap) {
		var jugador = new Jugador()
		jugador.nombre = nombre
		jugador.apodo = apodo
		jugador.modalidad = modalidad
		modalidad.setCliente(jugador);
		jugador.handicap = handicap
		this.create(jugador)
	}
	
	// ********************************************************
	// ** Búsquedas
	// ********************************************************
	def search(CriterioBusqueda criterio) {
		if(criterio != null)
			criterio.buscar(allInstances)
		else
			return allInstances 
	}
	
	def getJugadores(){
		allInstances
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