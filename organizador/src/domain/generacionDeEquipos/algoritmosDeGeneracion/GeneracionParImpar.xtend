package domain.generacionDeEquipos.algoritmosDeGeneracion


import domain.Jugador
import java.util.Listimport java.io.Serializable

class GeneracionParImpar extends Generacion implements Serializable{
	
	new()
	{
		nombreDelAlgoritmo="Par - Impar"
	}
	
	def override designarJugadores(List<Jugador> jugadoresARepartir){
		for(i:0 .. jugadoresARepartir.size-1){
			if((i % 2) != 0){
				this.enviarAlEquipoUno(jugadoresARepartir.get(i))
			}
			else{
				this.enviarAlEquipoDos(jugadoresARepartir.get(i))
			}
		}
	}
}