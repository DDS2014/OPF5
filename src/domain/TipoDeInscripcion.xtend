package domain

abstract class TipoDeInscripcion 
{
	def void inscribirse(Partido partido, Participante participante) //esta es la stateless
	{
		if (partido.hayLugaresLibres() == true)
		{
			partido.confirmarAsistencia(participante);
		}
		//este if es el código que comparten todos los tipos de inscripción
		//pongo un return adentro porque el "else" es lo que van a implementar las subclases (obviamente no en un bloque else)
	}
	
}