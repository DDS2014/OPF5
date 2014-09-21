package ui

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton

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
		val generarBtn = new XButton("btnGenerarPage")
		generarBtn.onClick = [| this.generar ]
		this.addChild(generarBtn)
//		
//		val buscarBtn = new XButton("btnBuscarPage")
//		buscarBtn.onClick = [| this.buscar ]
//		this.addChild(buscarBtn)
	}
	
	def buscar() {
	}
	
	def generar() {
		responsePage = new GenerarEquiposPage()
	}
	
}
