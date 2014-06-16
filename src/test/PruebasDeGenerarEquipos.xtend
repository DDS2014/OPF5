package test

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import domain.Partido
import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio
import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDelHandicap

class PruebasDeGenerarEquipos 
{
	Partido partido
	Criterio criterio;
	
	@Before
	def void setup()
	{
		//Hay que generar un partido con 9 jugadores para despues agregar otro
		partido = Creaciones.crearPartidoCon9Estandar()

		//Setearle algun criterio y hacer toda la movida que se hizo con el test de CRITERIOS
		criterio = new CriterioDelHandicap()

		//Agregar un algoritmo de generacion
		//partido.agregarAlgoritmo(new GeneracionParImpar())

		//Pedir que genere los equipos al partido
		//partido.algoritmo.generarEquipos()
	}
	
	@Test
	def public void LosEquiposNoSePuedenGenerarPorqueTienenSolo9Jugadores(){
		
	}
	
	@Test
	def public void LosEquiposGeneradosTienen5JugadoresCadaUno(){
		
	}
	
	@Test
	def public void TodosLosJugadoresDeCadaEquipoSonDistintos(){
		
	}  
}