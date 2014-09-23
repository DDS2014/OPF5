package ui

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.markup.html.form.Form

/**
 * 
 * @author ?
 */
class HomePage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods

	new() {
		this.agregarAcciones()
    }
	
	def agregarAcciones() {
		var mainForm = new Form("mainForm")
		
		val generarBtn = new XButton("btnGenerarPage")
		generarBtn.onClick = [| this.generar ]
		mainForm.addChild(generarBtn)

		val buscarBtn = new XButton("btnBuscarPage")
		buscarBtn.onClick = [| this.buscar ]
		mainForm.addChild(buscarBtn)

		this.addChild(mainForm)
	}
	
	def buscar() {
		responsePage = new BuscadorJugadoresPage(this)
	}
	
	def generar() {
		responsePage = new GenerarEquiposPage(this)
	}
	
}
