package test

import domain.Jugador
import org.junit.Test

import static dao.SessionManager.*

class TestHibernate 
{	
	@Test
	def public void levantarAplicacion()
	{
		startApplication
		openSession
		
		val j = new Jugador
		j.nombre = "Un Jugador"
		j.apellido = "Un Apellido"
		
		session.save(j)
		
		commit
		closeSession
		closeApplication
	}
		
}