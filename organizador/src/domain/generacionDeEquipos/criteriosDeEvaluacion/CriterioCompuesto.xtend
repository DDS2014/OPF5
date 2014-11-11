package domain.generacionDeEquipos.criteriosDeEvaluacion

import domain.Jugador
import java.util.ArrayList
import java.io.Serializable

class CriterioCompuesto extends Criterio implements Serializable
{
	ArrayList<Criterio> subCriterios;
	
	new()
	{
		nombreDelCriterio = "Mixto"
		this.subCriterios = new ArrayList();
	}
	
	def agregarSubcriterio(Criterio subcriterio)
	{
		this.subCriterios.add(subcriterio);
	}
	
	override evaluarJugador(Jugador jugador) 
	{
		var suma = 0 as double;
		
		for(subcriterio:subCriterios)
		{
			suma = suma + subcriterio.evaluarJugador(jugador);
		}
		
		return suma/(subCriterios.length());
	}
}