package domain.inscripcion.condiciones

import domain.Partido

public interface Condicion {
	def boolean seCumple(Partido partido)
}