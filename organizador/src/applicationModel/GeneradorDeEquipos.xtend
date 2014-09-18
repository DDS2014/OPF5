package applicationModel

import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio
import domain.generacionDeEquipos.algoritmosDeGeneracion.Generacion
import domain.Jugador
import domain.Partido
import java.util.List

class GeneradorDeEquipos 
//IMPORTANTE: feature envy en todas partes??? convendrá ir desde la UI directamente a pegarle al partido?
{
	Partido partido;
	Criterio criterioDeOrdenamiento;
	Generacion criterioDeSeleccion;	
	List<Jugador> primerEquipo;
	List<Jugador> segundoEquipo;
	

	new(Partido partido)
	{
		this.partido = partido
	}
	
	
	def generar()
	{
		partido.setCriterioDeOrdenamiento(this.criterioDeOrdenamiento)
		partido.definirAlgoritmoGeneracion(this.criterioDeSeleccion)
		partido.generarEquipos();
		this.refresh()
	}
	
	def refresh()
	{
		this.primerEquipo = partido.primerEquipo;
		this.segundoEquipo = partido.segundoEquipo;
	}
	
}