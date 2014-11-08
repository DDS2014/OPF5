//package home 
//import org.uqbar.commons.utils.Observable
//import domain.Partido
//import java.util.Date
//import org.uqbar.commons.utils.ApplicationContext
//import domain.Jugador
//import org.uqbar.commons.model.CollectionBasedHome
//
//@Observable
//class HomePartido extends CollectionBasedHome<Partido> {
//	new(){
//		this.init()
//	}
//	
//	def void init(){
//		this.create(new Date)
//	}
//	
//	def create(Date date){
//		var partido = new Partido(date)
//		this.create(partido)
//	}
//		
//	override protected getCriterio(Partido example) {
//		null
//	}
//	
//	override createExample() {
//		new Partido(new Date)
//	}
//	
//	override getEntityType() {
//		typeof(Partido)
//	}
//	
//}