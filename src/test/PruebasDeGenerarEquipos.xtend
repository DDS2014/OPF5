package test

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import domain.Partido
import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio
import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDelHandicap
import domain.generacionDeEquipos.algoritmosDeGeneracion.GeneracionParImpar
import domain.Jugador
import domain.inscripcion.InscripcionEstandar
import domain.excepciones.ImposibleGenerarEquiposException
import java.util.Date
import domain.generacionDeEquipos.algoritmosDeGeneracion.GeneracionConcreta

class PruebasDeGenerarEquipos 
{
	Partido partido;
	Partido partido2;
	Criterio criterio;
	Jugador diego = new Jugador("Diego", 22, new InscripcionEstandar());
	Jugador facundo = new Jugador("Facundo", 26, new InscripcionEstandar());
	Jugador marcos = new Jugador("Marcos", 28, new InscripcionEstandar());
	Jugador pepe = new Jugador("Pepe", 42, new InscripcionEstandar());
	Jugador leo = new Jugador("Leo", 32, new InscripcionEstandar());
	Jugador homero = new Jugador("Homero", 29, new InscripcionEstandar());
	Jugador esteban = new Jugador("Esteban", 20, new InscripcionEstandar());
	Jugador luis = new Jugador("Luis", 17, new InscripcionEstandar());
	Jugador alejandro = new Jugador("Alejandro", 34, new InscripcionEstandar());
	Jugador martin = new Jugador("Martin",29, new InscripcionEstandar());
	
	
	
	
	@Before
	def void setup()
	{
		//Hay que generar un partido con 9 jugadores para despues agregar otro
		partido = Creaciones.crearPartidoCon9Estandar();
		
		diego.setHandicap(10);
		facundo.setHandicap(3);
		marcos.setHandicap(5);
		pepe.setHandicap(6);
		leo.setHandicap(1);
		homero.setHandicap(8);
		esteban.setHandicap(9);
		luis.setHandicap(7);
		alejandro.setHandicap(4);
		martin.setHandicap(2);
		
		partido2 = new Partido (new Date); 
		//el partido 2 lo creamos y lo configuramos a manopla porque necesitamos referencias a los jugadores que vamos inscribiendo
		
		
		diego.inscribirse(partido2);
		facundo.inscribirse(partido2);
		marcos.inscribirse(partido2);
		pepe.inscribirse(partido2);
		leo.inscribirse(partido2);
		homero.inscribirse(partido2);
		esteban.inscribirse(partido2);
		luis.inscribirse(partido2);
		alejandro.inscribirse(partido2);
		martin.inscribirse(partido2);
		
		
		criterio = new CriterioDelHandicap();
		
		//Agregar un algoritmo de generacion
		partido.definirAlgoritmoGeneracion(new GeneracionParImpar());
		partido.criterioDeOrdenamiento=criterio;
		
		partido2.definirAlgoritmoGeneracion(new GeneracionParImpar());
		partido2.criterioDeOrdenamiento=criterio;

		//Pedir que genere los equipos al partido
		
	}
	
	@Test (expected = ImposibleGenerarEquiposException)
	def public void LosEquiposNoSePuedenGenerarPorqueTienenSolo9Jugadores(){
		partido.generarEquipos();
	}
	
	@Test
	def public void LosEquiposGeneradosTienen5JugadoresCadaUno(){
		diego.inscribirse(partido);
		partido.generarEquipos();
		Assert.assertEquals(5,partido.primerEquipo.size);
		Assert.assertEquals(5,partido.segundoEquipo.size)
	} 
	
	@Test
	def public void LosJugadoresDeCadaEquipoEstanBienUbicadosConAlgortimoParImpar(){
		partido2.generarEquipos();
		//en el SegundoEquipo estan los pares.
		Assert.assertTrue(partido2.segundoEquipo.contains(diego)); //handicap 10
		Assert.assertTrue(partido2.segundoEquipo.contains(martin)); //handicap 2
		Assert.assertTrue(partido2.segundoEquipo.contains(pepe)); //handicap 6
		Assert.assertTrue(partido2.segundoEquipo.contains(homero)); //handicap 8
		Assert.assertTrue(partido2.segundoEquipo.contains(alejandro)); //handicap 4
		//los impares van en el PrimerEquipo
		Assert.assertTrue(partido2.primerEquipo.contains(marcos)); //handicap 5
		Assert.assertTrue(partido2.primerEquipo.contains(esteban)); //handicap 9
		Assert.assertTrue(partido2.primerEquipo.contains(facundo));//handicap 3
		Assert.assertTrue(partido2.primerEquipo.contains(leo));//handicap 1
		Assert.assertTrue(partido2.primerEquipo.contains(luis));//handicap 7
		
	}  
	
	@Test
	def public void LosJugadoresDeCadaEquipoEstanBienUbicadosConAlgortimoDeGeneracionConcreto(){
		partido2.definirAlgoritmoGeneracion(new GeneracionConcreta);
		partido2.generarEquipos();
		//diego,luis,pepe,martin y facundo en el primer equipo
		Assert.assertTrue(partido2.primerEquipo.contains(diego));
		Assert.assertTrue(partido2.primerEquipo.contains(luis));
		Assert.assertTrue(partido2.primerEquipo.contains(pepe));
		Assert.assertTrue(partido2.primerEquipo.contains(martin));
		Assert.assertTrue(partido2.primerEquipo.contains(facundo));
		//esteban,homero,marcos,alejandro y leo en el segundo
		Assert.assertTrue(partido2.segundoEquipo.contains(esteban));
		Assert.assertTrue(partido2.segundoEquipo.contains(homero));
		Assert.assertTrue(partido2.segundoEquipo.contains(marcos));
		Assert.assertTrue(partido2.segundoEquipo.contains(alejandro));
		Assert.assertTrue(partido2.segundoEquipo.contains(leo));
	}
	
	@Test (expected = RuntimeException)
	def public void noMePuedoBajarDePartidoConEquiposConfirmados()
	{
		partido2.definirAlgoritmoGeneracion(new GeneracionConcreta);
		partido2.generarEquipos();
		partido2.confirmarEquipos();
		diego.bajarse(partido2);
		
	}
	
}