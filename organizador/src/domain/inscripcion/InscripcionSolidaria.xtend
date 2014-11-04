package domain.inscripcion


import domain.Partido
import domain.Jugador

public class InscripcionSolidaria extends TipoDeInscripcion
{
	//int prioridad=2


	
	override reemplazar(Partido partido, Jugador entrante, Jugador saliente) {
		if(entrante.modalidad instanceof InscripcionEstandar)
		{
			partido.reemplazar(entrante,saliente) //recordar que si el reemplazar falla, rompe, no tira código de error
			return true;
		}
		else return false; //ponele que un solidario no puede reemplazar a otro
	}
}