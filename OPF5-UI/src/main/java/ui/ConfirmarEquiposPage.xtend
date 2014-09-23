package ui

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import applicationModel.GeneradorDeEquipos
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.XButton
import org.uqbar.wicket.xtend.XListView
import domain.Jugador


//import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDeLasUltimasCalificaciones
//import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDelUltimoPartido

class ConfirmarEquiposPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	var GeneradorDeEquipos generador
	var GenerarEquiposPage parentPage;

	
	
	new(GeneradorDeEquipos generador, GenerarEquiposPage parentPage){
		this.generador = generador
		this.parentPage = parentPage
		val Form<GeneradorDeEquipos> confirmarForm = new Form<GeneradorDeEquipos>("confirmarEquiposForm", new CompoundPropertyModel<GeneradorDeEquipos>(this.generador))
		this.agregarAcciones(confirmarForm)
		this.agregarGrilla(confirmarForm)
		this.addChild(confirmarForm)

		
	}
	
	
	def agregarGrilla(Form<GeneradorDeEquipos> form) //FIXME la misma consigna dice que no hay que repetir código acá
	{
		var listaEquipo1 = new XListView("primerEquipo")
		var listaEquipo2 = new XListView("segundoEquipo")
		
		listaEquipo1.populateItem = [ item | 
			item.model = item.modelObject.asCompoundModel
			item.addChild = new LinkJugador("link1", item.modelObject as Jugador)]
//			item.addChild = new XLink("link1").add(new Label("nombre"))]
		//codigo repetido, usar foreach?
		listaEquipo2.populateItem = [ item | 
			item.model = item.modelObject.asCompoundModel
			item.addChild = new LinkJugador("link2", item.modelObject as Jugador)]
//			item.addChild = new XLink("link2").add(new Label("nombre"))]
		
		form.addChild(listaEquipo1)
		form.addChild(listaEquipo2)
		
	}
	
	def agregarAcciones(Form<GeneradorDeEquipos> form) {
		val generarBtn = new XButton("btnConfirmar")
		generarBtn.onClick = [| this.confirmar() ]
		form.addChild(generarBtn)
		
		val volverBtn = new XButton("btnVolver")
		volverBtn.onClick = [| this.volver() ]
		form.addChild(volverBtn)
	}
	
	def confirmar()
	{
		this.generador.confirmar()
		volver()
	}
	
	def volver()
	{
		responsePage = parentPage
	}
	

	

	
}