package domain

import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.DiscriminatorColumn
import javax.persistence.InheritanceType
import javax.persistence.DiscriminatorType
import javax.persistence.Embeddable
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@Embeddable
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="OBJECT_TYPE", discriminatorType=DiscriminatorType.STRING)

abstract class PartidoState 
{	
	@Id
	@GeneratedValue
	int id; //esto es lo que NO quiero
	
	def getId() { id }
	def setId(int i){id=i}
	
	
	def void validarCambios();
		
}