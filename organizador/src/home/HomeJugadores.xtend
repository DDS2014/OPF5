//package home
//
//import org.uqbar.commons.utils.Observable
//import org.uqbar.commons.model.CollectionBasedHome
//import domain.Jugador
//import domain.busqueda.CriterioBusqueda
//import domain.inscripcion.TipoDeInscripcion
//import domain.inscripcion.InscripcionEstandar
//import domain.calificaciones.Calificacion
//import domain.infracciones.Infraccion
//
//@Observable
//class HomeJugadores extends CollectionBasedHome<Jugador> {
//	new() {
//		this.init
//	}
//	
//	def void init() {
////		this.create("Juan","Juancito",new InscripcionEstandar,9,18)
////		this.create("Jose","Pepe",new InscripcionEstandar,6,19)
////		this.create("Nicolás","Nico",new InscripcionEstandar,10,21)
////		this.create("Diego","Diego",new InscripcionEstandar,6,47)
////		this.create("Roberto","Tito",new InscripcionEstandar,7,32)
////		this.create("Jorge","Jorge",new InscripcionEstandar,6,20)
////		this.create("Pablo","Pablo",new InscripcionEstandar,6,33)
////		this.create("Hernán","Hernán",new InscripcionEstandar,9,45)
////		this.create("Esteban","Esteban",new InscripcionEstandar,6,19)
////		this.create("Alberto","Beto",new InscripcionEstandar,6,25)
////	var diego = new Jugador("Diego", 32, new InscripcionEstandar());
////	var facundo = new Jugador("Facundo", 26, new InscripcionEstandar());
////	var marcos = new Jugador("Marcos", 28, new InscripcionEstandar());
////	var pepe = new Jugador("Pepe", 42, new InscripcionEstandar());
////	var leo = new Jugador("Leo", 22, new InscripcionEstandar());
////	var homero = new Jugador("Homero", 29, new InscripcionEstandar());
////	var esteban = new Jugador("Esteban", 20, new InscripcionEstandar());
////	var luis = new Jugador("Luis", 17, new InscripcionEstandar());
////	var alejandro = new Jugador("Alejandro", 34, new InscripcionEstandar());
////	var martin = new Jugador("Martin",29, new InscripcionEstandar());
////	
////	diego.setHandicap(10);
////	facundo.setHandicap(3);
////	marcos.setHandicap(5);
////	pepe.setHandicap(6);
////	leo.setHandicap(10);
////	homero.setHandicap(8);
////	esteban.setHandicap(9);
////	luis.setHandicap(7);
////	alejandro.setHandicap(4);
////	martin.setHandicap(2);
////	
////	diego.setApodo("D10s");
////	facundo.setApodo("Facu");
////	marcos.setApodo("Marquitos");
////	pepe.setApodo("Pep");
////	leo.setApodo("Messi");
////	homero.setApodo("Homer");
////	esteban.setApodo("El Bichi");
////	luis.setApodo("Luisi");
////	alejandro.setApodo("Ale");
////	martin.setApodo("Tincho");
////	
////	diego.hacerseAmigoDe(leo);
////	diego.hacerseAmigoDe(esteban);
////	diego.hacerseAmigoDe(alejandro);
////	diego.hacerseAmigoDe(homero);
////	diego.hacerseAmigoDe(marcos);
////	
////	alejandro.hacerseAmigoDe(facundo);
////	
////	alejandro.hacerseAmigoDe(esteban);
////	homero.hacerseAmigoDe(esteban);
////	luis.hacerseAmigoDe(esteban);
////	martin.hacerseAmigoDe(esteban);
////	
////	martin.hacerseAmigoDe(leo);
////	facundo.hacerseAmigoDe(leo);
////	marcos.hacerseAmigoDe(leo);
////	esteban.hacerseAmigoDe(leo);
////	
////	diego.calificaciones.add(new Calificacion(10))
////	diego.calificaciones.add(new Calificacion(10))
////	diego.calificaciones.add(new Calificacion(10))
////	diego.calificaciones.add(new Calificacion(10))
////
////	pepe.calificaciones.add(new Calificacion(9))
////	pepe.calificaciones.add(new Calificacion(8))
////	pepe.calificaciones.add(new Calificacion(7))
////	pepe.calificaciones.add(new Calificacion(9))
////
////	leo.calificaciones.add(new Calificacion(10))
////	leo.calificaciones.add(new Calificacion(7))
////	leo.calificaciones.add(new Calificacion(8))
////	leo.calificaciones.add(new Calificacion(9))
////
////	facundo.calificaciones.add(new Calificacion(10))
////	facundo.calificaciones.add(new Calificacion(5))
////	facundo.calificaciones.add(new Calificacion(7))
////	facundo.calificaciones.add(new Calificacion(8))
////	
////	marcos.calificaciones.add(new Calificacion(6))
////	marcos.calificaciones.add(new Calificacion(6))
////	marcos.calificaciones.add(new Calificacion(4))
////	marcos.calificaciones.add(new Calificacion(10))
////	
////	homero.calificaciones.add(new Calificacion(5))
////	homero.calificaciones.add(new Calificacion(5))
////	homero.calificaciones.add(new Calificacion(5))
////	homero.calificaciones.add(new Calificacion(5))
////	
////	esteban.calificaciones.add(new Calificacion(9))
////	esteban.calificaciones.add(new Calificacion(6))
////	esteban.calificaciones.add(new Calificacion(9))
////	esteban.calificaciones.add(new Calificacion(9))
////	
////	luis.calificaciones.add(new Calificacion(4))
////	luis.calificaciones.add(new Calificacion(5))
////	luis.calificaciones.add(new Calificacion(10))
////	luis.calificaciones.add(new Calificacion(7))
////	
////	alejandro.calificaciones.add(new Calificacion(7))
////	alejandro.calificaciones.add(new Calificacion(3))
////	alejandro.calificaciones.add(new Calificacion(6))
////	alejandro.calificaciones.add(new Calificacion(1))
////	
////	martin.calificaciones.add(new Calificacion(3))
////	martin.calificaciones.add(new Calificacion(9))
////	martin.calificaciones.add(new Calificacion(7))
////	martin.calificaciones.add(new Calificacion(6))
////	
////	diego.aplicarInfraccion(new Infraccion("Dopping Positivo"))
////	homero.aplicarInfraccion(new Infraccion("Llego Borracho"))
////	
////	this.create(diego);
////	this.create(facundo);
////	this.create(marcos);
////	this.create(pepe);
////	this.create(leo);
////	this.create(homero);
////	this.create(esteban);
////	this.create(luis);
////	this.create(alejandro);
////	this.create(martin);
////	}
//	
//	// ********************************************************
//	// ** Altas y bajas
//	// ********************************************************
////	def void create(String nombre, String apodo, TipoDeInscripcion modalidad, double handicap, int edad) {
////		var jugador = new Jugador()
////		jugador.nombre = nombre
////		jugador.apodo = apodo
////		jugador.edad = edad
////		jugador.modalidad = modalidad
////		modalidad.setCliente(jugador);
////		jugador.handicap = handicap
////		this.create(jugador)
////	}
//	
//	
//	
//	// ********************************************************
//	// ** Búsquedas
//	// ********************************************************
//	def search(CriterioBusqueda criterio) {
//		if(criterio != null)
//			criterio.buscar(allInstances)
//		else
//			return allInstances 
//	}
//	
//	def getJugadores(){
//		allInstances
//	}
//	
//	override protected getCriterio(Jugador example) {
//		null
//	}
//	
//	override createExample() {
//		new Jugador()
//	}
//	
//	override getEntityType() {
//		typeof(Jugador)
//	}
//	
//}