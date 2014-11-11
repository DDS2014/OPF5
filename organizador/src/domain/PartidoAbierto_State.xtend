package domain

import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorValue
import javax.persistence.InheritanceType
import javax.persistence.DiscriminatorType
import javax.persistence.Embeddable
import java.io.Serializable

//@Entity
//
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="OBJECT_TYPE", discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue("A")
class PartidoAbierto_State extends PartidoState implements Serializable
{
	String estado_char = "A"; //fiesta, vamos a acoplar todo al pedo
	override validarCambios()
	{
	}
	
}