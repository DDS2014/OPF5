package domain.generacionDeEquipos.algoritmosDeGeneracion

class GeneracionParImpar extends Generacion{
	
	def override designarJugadores(){
		for(i:0 .. this.partido.jugadoresConfirmados.size-1){
			if((i % 2) != 0){
				this.partido.agregarJugadorAEquipo(1,i)
			}
			else{
				this.partido.agregarJugadorAEquipo(2,i)
			}
		}
	}
}