package hola_mundo

class Test {
	def static void main(String[] args){
		var Recepcionista recepcionista
		recepcionista = new Recepcionista
		
		var Mundo mundo
		mundo = new Mundo
		
		recepcionista.saludar(mundo)
	}
}