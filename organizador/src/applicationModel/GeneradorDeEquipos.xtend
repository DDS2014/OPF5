package applicationModel

import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio
import domain.generacionDeEquipos.algoritmosDeGeneracion.Generacion
import domain.Jugador
import domain.Partido
import java.util.List

import java.io.Serializable
import java.util.ArrayList

@org.uqbar.commons.utils.Observable
class GeneradorDeEquipos implements Serializable
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
		this.primerEquipo = new ArrayList<Jugador>
		this.segundoEquipo = new ArrayList<Jugador>
	}
	
	
	def generar()
	{
		this.partido.setCriterioDeOrdenamiento(this.criterioDeOrdenamiento)
		this.partido.definirAlgoritmoGeneracion(this.criterioDeSeleccion)
		this.partido.generarEquipos();
		this.refresh()
	}
	
	def refresh()
	{
		this.primerEquipo = this.partido.primerEquipo;
		this.segundoEquipo = this.partido.segundoEquipo;
	}
	
}