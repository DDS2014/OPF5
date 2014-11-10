package domain

import org.uqbar.commons.model.UserException
import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorValue
import javax.persistence.InheritanceType
import javax.persistence.DiscriminatorType
import javax.persistence.Embeddable

@Entity
@Embeddable
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="OBJECT_TYPE", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("MyClass")
class PartidoConEquiposConfirmados_State extends PartidoState
{
	
	override validarCambios() 
	{
		throw new UserException("Esta operación no puede hacerse para un partido que tiene los equipos confirmados")
		//FIXME hacer que esto tire la excepción apropiada para cada situacion!! recibirla por parámetro? hmmmmmm
		//....y ahora uso UserException para que no me rompa wicket
	}
	
}