package domain

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
@DiscriminatorValue("A")
class PartidoAbierto_State extends PartidoState
{
	
	override validarCambios()
	{
	}
	
}