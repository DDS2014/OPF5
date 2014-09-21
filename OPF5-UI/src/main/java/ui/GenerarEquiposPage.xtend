package ui

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import applicationModel.GeneradorDeEquipos
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.XButton
import org.uqbar.wicket.xtend.XListView
import org.apache.wicket.markup.html.basic.Label

class GenerarEquiposPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	var GeneradorDeEquipos generador
	
	new(){
		this.generador = new GeneradorDeEquipos
		val Form<GeneradorDeEquipos> generarForm = new Form<GeneradorDeEquipos>("generarEquiposForm", new CompoundPropertyModel<GeneradorDeEquipos>(this.generador))
		this.agregarAcciones(generarForm)
		this.agregarGrilla(generarForm)
		this.addChild(generarForm)
	}
	
	def agregarGrilla(Form<GeneradorDeEquipos> form) {
		
	}
	
	def agregarAcciones(Form<GeneradorDeEquipos> form) {
		val generarBtn = new XButton("btnGenerar")
		generarBtn.onClick = [| this.generar ]
		form.addChild(generarBtn)
	}
	
	def generar(){
		this.generador.generar()
	}
}