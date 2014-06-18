package domain

class PartidoConEquiposConfirmados_State extends PartidoState
{
	
	override validarCambios() 
	{
		throw new RuntimeException("Esta operación no puede hacerse para un partido que tiene los equipos confirmados")
		//FIXME hacer que esto tire la excepción apropiada para cada situacion!! recibirla por parámetro? hmmmmmm
	}
	
}