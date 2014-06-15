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
import domain.generacionDeEquipos.CriterioDelHandicap

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
		//tests para federico:
		//un promedio de las últimas dos calificaciones debería dar 7
		//un promedio de la última una calificación debería dar 6
		//un promedio de las últimas tres calificaciones debería dar aprox 7.67 (recordar el AssertEquals tiene un margen)
		//un promedio de las últimas cuatro calificaciones debería tirar una excepción apropiada
		//un promedio de las calificaciones del último partido debería dar 8.50
		//una evaluación por handicap debería dar 9
		//un mix de los criterios: [handicap, últimas dos calificaciones] debería dar 8
	}
	

	
	@Test
	def evaluarPorHandicapDevuelveResultadoCorrecto()
	{
		var criterio = new CriterioDelHandicap()
		Assert.assertEquals("", criterio.evaluarJugador(federico), 9.0, 0.05);
	}
	
//	@Test
//	def evaluarPorNUltimasCalificacionesDevuelveResultadoCorrecto()
//	{
//		var criterio1UltimaCalificacion = new CriterioDeLasUltimasCalificaciones(1);
//		var criterio2UltimasCalificaciones = new CriterioDeLasUltimasCalificaciones(2);
//		var criterio3UltimasCalificaciones = new CriterioDeLasUltimasCalificaciones(3); 
//		
//		Assert.assertEquals("", criterio1UltimaCalificacion.evaluarJugador(federico), 6.0, 0.05);
//		Assert.assertEquals("", criterio2UltimasCalificaciones.evaluarJugador(federico), 7.0, 0.05);
//		Assert.assertEquals("", criterio3UltimasCalificaciones.evaluarJugador(federico), 7.67, 0.05);
//	}
//	
//	@Test (expected = ImposibleEvaluarException)
//	def evaluarPorMasCalificacionesDeLasQueHayRompe()
//	{
//		var criterio = new CriterioDeLasUltimasCalificaciones(4);
//		criterio.evaluarJugador(federico); //esto debería romper porque federico no tiene cargadas cuatro excepciones
//	}
//	
//	@Test
//	def evaluarPorPromedioDelUltimoPartidoDevuelveResultadoCorrecto()
//	{
//		var criterio = new CriterioDelUltimoPartido();
//		Assert.assertEquals("", criterio.evaluarJugador(federico), 8.50, 0.05); //recordar que en segundoPartido se le dio un 9 y un 8
//	}
//	
//	@Test
//	def evaluarPorCriterioCompuestoDevuelveResultadoCorrecto() //criterio COMPUESTO guiño guiño
//	{
//		var criterio = new CriterioCompuesto();
//		var subCriterioHandicap = new CriterioDelHandicap();
//		var subCriterioUltimasDosCriticas = new CriterioDeLasUltimasCalificaciones(2);
//		
//		criterio.agregarSubcriterio(subCriterioHandicap);
//		criterio.agregarSubcriterio(subCriterioUltimasDosCriticas);
//		
//		Assert.assertEquals("", criterio.evaluarJugador(federico), 8, 0,05);
//	}
	
}