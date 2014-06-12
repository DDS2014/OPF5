package test


import org.junit.Assert
import org.junit.Before
import org.junit.Test
import domain.Jugador
import domain.sugerencias.Comunidad
import domain.inscripcion.InscripcionEstandar
import java.util.Calendar
import domain.Partido
import java.util.Date

class PruebasDeGenerarEquipos 
{
	Jugador martin = new Jugador("Martin", 31, new InscripcionEstandar());
	Jugador francisco = new Jugador("Francisco", 22, new InscripcionEstandar());
	Jugador federico = new Jugador("Federico", 25, new InscripcionEstandar());
	Comunidad losMuchachos = new Comunidad();
	
	Partido primerPartido;	
	Partido segundoPartido;
	
	Calendar cal = Calendar.getInstance();
	
	
	@Before
	def void setup()
	{
		losMuchachos.agregar(martin);
		losMuchachos.agregar(francisco);
		losMuchachos.agregar(federico);
		
		martin.setHandicap(6);
		francisco.setHandicap(7);
		federico.setHandicap(9);
		
		cal.setTime(new Date());
		primerPartido = new Partido(cal.getTime());
		cal.add(Calendar.DATE, 5);
		segundoPartido = new Partido(cal.getTime());
		//esto me debería haber creado un partido hoy y uno en 5 días. lo importante es saber que el segundo es después	
		
		losMuchachos.organizarPartido(primerPartido);
		losMuchachos.organizarPartido(segundoPartido);
		
		martin.inscribirse(primerPartido);
		francisco.inscribirse(primerPartido);
		federico.inscribirse(primerPartido);
		martin.inscribirse(segundoPartido);
		francisco.inscribirse(segundoPartido);
		federico.inscribirse(segundoPartido);
		
		federico.calificar(9, "Dejó todo, sólo faltó el gol", segundoPartido, francisco);
		federico.calificar(8, "Gran actuación, es fundamental para el equipo", segundoPartido, martin);
		federico.calificar(6, "Buenos arranques pero no terminó bien las jugadas", primerPartido, martin);
		//un promedio de las últimas dos calificaciones debería dar 7
		//un promedio de la última una calificación debería dar 6
		//un promedio de las últimas tres calificaciones debería dar aprox 7.67 (recordar el AssertEquals tiene un margen)
		//un promedio de las calificaciones del último partido debería dar 8.50
		//una evaluación por handicap debería dar 9
		//un mix de los criterios: [handicap, últimas dos calificaciones] debería dar 8
	}
	
	@Test
	def dummy() //para evitar los warnings por ahora 8D
	{
		Assert.assertTrue(true);
	}
}