package domain

import org.uqbar.commons.model.UserException

class PartidoConEquiposConfirmados_State extends PartidoState
{
	
	override validarCambios() 
	{
		throw new UserException("Esta operación no puede hacerse para un partido que tiene los equipos confirmados")
		//FIXME hacer que esto tire la excepción apropiada para cada situacion!! recibirla por parámetro? hmmmmmm
		//....y ahora uso UserException para que no me rompa wicket
	}
	
}