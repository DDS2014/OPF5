package domain;

import org.uqbar.commons.model.UserException;

public enum PartidoState {
	ABIERTO{
		@Override
		public void validarCambios() {
			
		}
		
	}, CONFIRMADO{
		@Override
		public void validarCambios() {
			throw new UserException("Esta operación no puede hacerse para un partido que tiene los equipos confirmados");			
		}
	};
	
	public abstract void validarCambios();
}
