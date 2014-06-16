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

class PruebasDeGenerarEquipos 
{
	Partido partido;
	Criterio criterio;
	Jugador diego = new Jugador("Diego", 22, new InscripcionEstandar());
	
	@Before
	def void setup()
	{
		//Hay que generar un partido con 9 jugadores para despues agregar otro
		partido = Creaciones.crearPartidoCon9Estandar();
		diego.setHandicap(10);
		
		
		//Setearle algun criterio y hacer toda la movida que se hizo con el test de CRITERIOS
		criterio = new CriterioDelHandicap();
		
		//Agregar un algoritmo de generacion
		partido.agregarAlgoritmo(new GeneracionParImpar());

		//Pedir que genere los equipos al partido
		
	}
	
	@Test (expected = ImposibleGenerarEquiposException)
	def public void LosEquiposNoSePuedenGenerarPorqueTienenSolo9Jugadores(){
		partido.algoritmo.generarEquipos();
	}
	
//	@Test
//	def public void LosEquiposGeneradosTienen5JugadoresCadaUno(){
//		diego.inscribirse(partido);
//		partido.algoritmo.generarEquipos();
//		Assert.assertEquals(5,partido.primerEquipo.size);
//		Assert.assertEquals(5,partido.segundoEquipo.size)
//	} esto me tira: Nullpointer exception y nose porque
	
	@Test
	def public void TodosLosJugadoresDeCadaEquipoSonDistintos(){
		
	}  
}