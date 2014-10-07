package home

import domain.Jugador
import domain.inscripcion.InscripcionEstandar
import domain.sugerencias.Comunidad
import org.uqbar.commons.utils.Observable
import domain.infracciones.Infraccion
import domain.Partido
import java.util.Date
import domain.busqueda.CriterioBusqueda

@Observable
class HomeComunidad extends Comunidad {
	new(){
		this.init
	}
	
	def init() {
		
		var partido1 = new Partido(new Date)
		var partido2 = new Partido(new Date(2014,9,30))
		var partido3 = new Partido(new Date(2014,9,23))
		
		
		var diego = new Jugador("Diego", 32, new InscripcionEstandar());
		var facundo = new Jugador("Facundo", 26, new InscripcionEstandar());
		var marcos = new Jugador("Marcos", 28, new InscripcionEstandar());
		var pepe = new Jugador("Pepe", 42, new InscripcionEstandar());
		var leo = new Jugador("Leo", 22, new InscripcionEstandar());
		var homero = new Jugador("Homero", 29, new InscripcionEstandar());
		var esteban = new Jugador("Esteban", 20, new InscripcionEstandar());
		var luis = new Jugador("Luis", 17, new InscripcionEstandar());
		var alejandro = new Jugador("Alejandro", 34, new InscripcionEstandar());
		var martin = new Jugador("Martin",29, new InscripcionEstandar());
	
		diego.setHandicap(10);
		facundo.setHandicap(3);
		marcos.setHandicap(5);
		pepe.setHandicap(6);
		leo.setHandicap(10);
		homero.setHandicap(8);
		esteban.setHandicap(9);
		luis.setHandicap(7);
		alejandro.setHandicap(4);
		martin.setHandicap(2);
		
		diego.setApodo("D10s");
		facundo.setApodo("Facu");
		marcos.setApodo("Marquitos");
		pepe.setApodo("Pep");
		leo.setApodo("Messi");
		homero.setApodo("Homer");
		esteban.setApodo("El Bichi");
		luis.setApodo("Luisi");
		alejandro.setApodo("Ale");
		martin.setApodo("Tincho");
		
		diego.hacerseAmigoDe(leo);
		diego.hacerseAmigoDe(esteban);
		diego.hacerseAmigoDe(alejandro);
		diego.hacerseAmigoDe(homero);
		diego.hacerseAmigoDe(marcos);
		
		alejandro.hacerseAmigoDe(facundo);
		
		alejandro.hacerseAmigoDe(esteban);
		homero.hacerseAmigoDe(esteban);
		luis.hacerseAmigoDe(esteban);
		martin.hacerseAmigoDe(esteban);
		
		martin.hacerseAmigoDe(leo);
		facundo.hacerseAmigoDe(leo);
		marcos.hacerseAmigoDe(leo);
		esteban.hacerseAmigoDe(leo);
		
		diego.aplicarInfraccion(new Infraccion("Dopping Positivo"))
		homero.aplicarInfraccion(new Infraccion("Llego Borracho"))
		
		this.organizarPartido(partido1)
		this.organizarPartido(partido2)
		this.organizarPartido(partido3)
		
		this.agregar(diego)
		this.agregar(facundo)
		this.agregar(marcos)
		this.agregar(pepe)
		this.agregar(leo)
		this.agregar(homero)
		this.agregar(esteban)
		this.agregar(luis)
		this.agregar(alejandro)
		this.agregar(martin)
		
		this.inscribirJugadores(partido1)
		this.inscribirJugadores(partido2)
		this.inscribirJugadores(partido3)
		
		diego.calificar(10,"barrilete cosmico",partido2,leo)
		diego.calificar(10,"de que planeta viniste",partido2,alejandro)
		
		diego.calificar(10,"crack",partido3,facundo)
		diego.calificar(10,"genio genio",partido3,luis)
		
		diego.calificar(1,"le cortaron las piernas",partido1,pepe)
		diego.calificar(2,"no estuvo a la altura",partido1,esteban)
		
		leo.calificar(10,"balon de oro",partido2,martin)
		leo.calificar(9,"goleador del equipo",partido2,esteban)
		
		leo.calificar(7,"un poco impreciso",partido3,marcos)
		leo.calificar(6,"le falto un poco",partido3,facundo)
		
		leo.calificar(10,"volvio a su nivel",partido1,alejandro)
		leo.calificar(10,"ooole ole ole,leeo leo",partido1,luis)

	}
	
	
	
	def getJugadores(){
		return aprobados
	}
	
	def search(CriterioBusqueda criterio) {
		if(criterio != null)
			criterio.buscar(aprobados.toList)
		else
			return aprobados.toList
	}
	
	def inscribirJugadores(Partido partido){ //TODO REVISAR: esto nose si es hardcodeo
		aprobados.forEach[j|j.inscribirse(partido)]
	}

	
}