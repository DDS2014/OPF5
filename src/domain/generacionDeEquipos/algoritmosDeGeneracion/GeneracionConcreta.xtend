package domain.generacionDeEquipos.algoritmosDeGeneracion


import domain.Jugador
import java.util.List
import java.util.ArrayList

class GeneracionConcreta extends Generacion{
	ArrayList<Integer> primerEquipoPos=newArrayList(1,4,5,8,9)
	ArrayList<Integer> segundoEquipoPos=newArrayList(2,3,6,7,10)
	
	def override designarJugadores(List<Jugador> jugadoresARepartir){
		for(i:0 .. jugadoresARepartir.size-1){
			if(primerEquipoPos.contains(i+1))
			{
				this.enviarAlEquipoUno(jugadoresARepartir.get(i));
			}
			else if(segundoEquipoPos.contains(i+1)){
				this.enviarAlEquipoDos(jugadoresARepartir.get(i));
			}
		}
	}
}