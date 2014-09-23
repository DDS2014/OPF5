package ui

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import domain.Jugador
import org.apache.wicket.markup.html.form.Form
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.XListView

class InfoJugadorPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	var Jugador jugador
	var WebPage parentPage
	
	new(Jugador jugador,WebPage parentPage){
		
		this.parentPage = parentPage
		this.jugador = jugador
		val Form<Jugador> infoJugadorForm = new Form<Jugador>("infoJugadorForm",this.jugador.asCompoundModel)
		this.agregarAcciones(infoJugadorForm)
		this.agregarGrillaDatos(infoJugadorForm)
		this.agregarGrillaAmigos(infoJugadorForm)
		this.addChild(infoJugadorForm)
	}
	
	def agregarGrillaDatos(Form<Jugador> form) {
		form.addChild(new Label("jugador.nombre"))
		form.addChild(new Label("jugador.apodo"))
		form.addChild(new Label("jugador.handicap"))
		//form.addChild(new Label("jugador.nombre"))
		//form.addChild(new Label("jugador.nombre"))
		form.addChild(new Label("jugador.edad"))
		
	
	}
	
	def agregarAcciones(Form<Jugador> form) {
		val volverBtn = new XButton("btnVolver")
		volverBtn.onClick = [| this.volver() ]
		form.addChild(volverBtn)
	}
	
	def agregarGrillaAmigos(Form<Jugador> form) 
	{
		var listAmigos = new XListView("jugador.amigos")
		
		listAmigos.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			item.addChild(new Label("apodo"))
			item.addChild(new Label("handicap"))
			//item.addChild(new Label("promedio"))
		]	
		form.addChild(listAmigos)		
	}
	
	def volver() {
		responsePage = parentPage
	}
	
}