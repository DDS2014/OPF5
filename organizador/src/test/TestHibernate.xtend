package test

import domain.Jugador
import org.junit.Test

import static dao.SessionManager.*
import domain.inscripcion.InscripcionEstandar
import java.util.Date
import domain.Partido

class TestHibernate 
{	
	@Test
	def public void levantarAplicacion()
	{
		startApplication
		openSession
		
		val j = new Jugador("josue", 18, new InscripcionEstandar())

		j.apellido = "Un Apellido"
		j.apodo = "tucu"
		j.documento = "32531284"
		j.email = "elmaskpo@hotmail.com"
		j.fechaNacimiento = new Date()
		
		session.save(j)
		
		
		var p = new Partido(new Date())
	
		j.inscribirse(p)
		p.agregarAlPrimerEquipo(j)
		
		session.save(p)
		
		commit
		closeSession
		closeApplication
	}
		
}