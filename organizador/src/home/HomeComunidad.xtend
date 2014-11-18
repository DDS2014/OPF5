package home

import domain.Jugador
import domain.inscripcion.InscripcionEstandar
import domain.sugerencias.Comunidad
import org.uqbar.commons.utils.Observable
import domain.infracciones.Infraccion
import domain.Partido
import java.util.Date
import domain.busqueda.CriterioBusqueda
import dao.SessionManager

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
		diego.calificar(8,"de que planeta viniste",partido2,alejandro)
		diego.calificar(10,"crack",partido3,facundo)
		diego.calificar(10,"genio genio",partido3,luis)
		diego.calificar(1,"le cortaron las piernas",partido1,pepe)
		diego.calificar(5,"no estuvo a la altura",partido1,esteban)
		
		leo.calificar(10,"balon de oro",partido2,martin)
		leo.calificar(9,"goleador del equipo",partido2,esteban)
		leo.calificar(7,"un poco impreciso",partido3,marcos)
		leo.calificar(6,"le falto un poco",partido3,facundo)
		leo.calificar(10,"volvio a su nivel",partido1,alejandro)
		leo.calificar(10,"ooole ole ole,leeo leo",partido1,luis)

		facundo.calificar(5,"regular",partido1,alejandro)
		facundo.calificar(4,"cuatro",partido1,esteban)
		facundo.calificar(8,"dos goles, tres asistencias",partido2,luis)
		facundo.calificar(9,"destacado",partido2,homero)
		facundo.calificar(6,"mas o menos",partido3,martin)
		facundo.calificar(7,"eeeh....buen partido",partido3,diego)
		
		marcos.calificar(7,"aceptable",partido1,leo)
		marcos.calificar(8,"aceptable",partido1,luis)
		marcos.calificar(9,"buen partido marquitos",partido2,alejandro)
		marcos.calificar(10,"a la altura de los mejores",partido2,facundo)
		marcos.calificar(6,"eeeh...no fue su mejor partido",partido3,diego)
		marcos.calificar(5,"cinco",partido3,martin)
		
		pepe.calificar(5,"cinco",partido1,martin)
		pepe.calificar(4,"un poco flojo",partido1,alejandro)
		pepe.calificar(3,"malo",partido2,facundo)
		pepe.calificar(2,"nose porque viene",partido2,esteban)
		pepe.calificar(4,"horrible",partido3,luis)
		pepe.calificar(3,"de madera",partido3,homero)
		
		homero.calificar(1,"vino con la damajuana",partido1,martin)
		homero.calificar(2,"larga el termidor",partido1,luis)
		homero.calificar(6,"bien",partido2,martin)
		homero.calificar(4,"mas o menos",partido2,leo)
		homero.calificar(7,"siete",partido3,facundo)
		homero.calificar(7,"siete",partido3,esteban)
		
		esteban.calificar(9,"eeeh...el bichi en mi equipo",partido1,diego)
		esteban.calificar(10,"brillante",partido1,leo)
		esteban.calificar(8,"se erro un par abajo del arco",partido2,luis)
		esteban.calificar(9,"que jugador",partido2,alejandro)
		esteban.calificar(9,"como siempre",partido3,facundo)
		esteban.calificar(8,"destacado",partido3,homero)
		
		luis.calificar(7,"que se yo,estoy re loco",partido1,diego)
		luis.calificar(8,"bien lucho",partido1,marcos)
		luis.calificar(6,"bastante bien",partido2,homero)
		luis.calificar(7,"siete",partido2,martin)
		luis.calificar(5,"morfonazo",partido3,esteban)
		luis.calificar(4,"fallo mucho",partido3,facundo)
		
		alejandro.calificar(8,"que se yo,estoy re loco",partido1,diego)
		alejandro.calificar(6,"sei",partido1,leo)
		alejandro.calificar(6,"sei",partido2,homero)
		alejandro.calificar(6,"sei",partido2,facundo)
		alejandro.calificar(6,"sei",partido3,leo)
		alejandro.calificar(7,"siete",partido3,esteban)
		
		martin.calificar(8,"que se yo,estoy re loco",partido1,diego)
		martin.calificar(5,"cinco",partido1,esteban)
		martin.calificar(9,"la rompio",partido2,leo)
		martin.calificar(8,"bien tincho",partido2,homero)
		martin.calificar(5,"estuvo flojo",partido3,alejandro)
		martin.calificar(4,"no jugo bien",partido3,pepe)

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
	
	def getPartidoRelevante()
	{
		this.getPartidos.get(0)
	}
	
	def inscribirJugadores(Partido partido){ //TODO REVISAR: esto nose si es hardcodeo
		aprobados.forEach[j|j.inscribirse(partido)]
	}

	
}