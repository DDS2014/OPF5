package domain

import java.util.Date

class Tester {
	def static void main(String[] args) {
  		//Partido
  		val partido = new Partido(new Date)
  		
  		//Jugadores
  		val j1 = new Jugador("Jugador1",25)
  		val j2 = new Jugador("Jugador2",25)
  		val j3 = new Jugador("Jugador3",25)
  		val j4 = new Jugador("Jugador4",25)
  		val j5 = new Jugador("Jugador5",25)
  		val j6 = new Jugador("Jugador6",20)
  		val j7 = new Jugador("Jugador7",20)
  		val j8 = new Jugador("Jugador8",20)
  		val j9 = new Jugador("Jugador9",20)
  		val j10 = new Jugador("Jugador10",20)
  		val j11 = new Jugador("Jugador11",20)
  		
  		//Modalidades
  		val tEstandar=new InscripcionEstandar
  		val tSolidaria=new InscripcionSolidaria
  		val condicion = new Condicion_LimiteDeEdad(23,5,true,true)
  		val tCondicional = new InscripcionCondicional(condicion)
  		
  		
  		
  		  		
  		partido.inscribir(j1,tEstandar)
  		partido.inscribir(j2,tEstandar)
  		partido.inscribir(j3,tEstandar)
  		partido.inscribir(j4,tSolidaria)
  		partido.inscribir(j5,tEstandar)
  		partido.inscribir(j6,tEstandar)
  		partido.inscribir(j7,tEstandar)
  		partido.inscribir(j8,tSolidaria)
  		partido.inscribir(j9,tSolidaria)
  		partido.inscribir(j10,tEstandar)
  		
		for(int i:0..partido.participantesConfirmados.size-1){
			var j = partido.jugadoresConfirmados().get(i)
			var p = partido.participantesConfirmados.get(i)
			println(j.nombre + " ;Fecha: " + p.fechaInscripcion + " ;Prioridad: " + p.modalidad.prioridad )
		}
		
		//no debe entrar
		//println()
		//println(partido.inscribir(j11,tCondicional))
		//partido.inscribir(j11,tEstandar)
		
		//val List<Jugador> jugadores=partido.participantesConfirmados.map[p|p.jugador].toList
		//println(jugadores.contains(j8) + " J08")
		//println(jugadores.contains(j9) + " J09")
		//println(jugadores.contains(j10) + " J10")
		//println(jugadores.contains(j11) + " J11")
		
		//println()
		//println(partido.participantesConfirmados.size)
	}
}