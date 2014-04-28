package domain

abstract class TipoDeInscripcion 
{
	def inscribirse(Partido partido, Participante participante) //esta es la stateless
	{
		if (partido.hayLugaresLibres() == true)
		{
			partido.confirmarAsistencia(participante);
		}
	}
	
}