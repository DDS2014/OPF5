package domain.generacionDeEquipos.algoritmosDeGeneracion

import java.util.ArrayList

class GeneracionConcreta extends Generacion{
	ArrayList<Integer> primerEquipoPos=newArrayList(1,4,5,8,9)
	ArrayList<Integer> segundoEquipoPos=newArrayList(2,3,6,7,10)
	
	def override designarJugadores(){
		for(i:0 .. this.partido.jugadoresConfirmados.size){
			if(primerEquipoPos.contains(i+1)){
				this.partido.agregarJugadorAEquipo(1,i)
			}
			else if(segundoEquipoPos.contains(i+1)){
				this.partido.agregarJugadorAEquipo(2,i)
			}
		}
	}
}