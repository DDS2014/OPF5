package ui

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import domain.Jugador
import org.apache.wicket.markup.html.form.Form
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.XListView
import home.HomeComunidad
import org.uqbar.commons.utils.ApplicationContext
import domain.sugerencias.Comunidad

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
		this.agregarGrillaInfracciones(infoJugadorForm)
		this.addChild(infoJugadorForm)
	}
	
	def agregarGrillaInfracciones(Form<Jugador> form) {
		var listInfracciones = new XListView("infracciones")
		
		listInfracciones.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("fecha"))
			item.addChild(new Label("motivo"))
		]	
		form.addChild(listInfracciones)		
	}
	
	def agregarGrillaDatos(Form<Jugador> form) {
		form.addChild(new Label("nombre"))
		form.addChild(new Label("apodo"))
		form.addChild(new Label("handicap"))
		form.addChild(new Label("promedioUltimoPartido", getHomeComunidad().promedioUltimoPartido(jugador).toString() as String))
		form.addChild(new Label("promedioGlobal"))
		form.addChild(new Label("edad"))
	
	}
	
	def agregarAcciones(Form<Jugador> form) {
		val volverBtn = new XButton("btnVolver")
		volverBtn.onClick = [| this.volver() ]
		form.addChild(volverBtn)
	}
	
	def agregarGrillaAmigos(Form<Jugador> form) 
	{
		var listAmigos = new XListView("amigos")
		
		listAmigos.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new LinkJugador("link", item.modelObject, this))
			item.addChild(new Label("apodo"))
			item.addChild(new Label("handicap"))
			item.addChild(new Label("promedioGlobal"))
		]	
		form.addChild(listAmigos)		
	}
	
	def volver() {
		responsePage = parentPage
	}
	
	def HomeComunidad getHomeComunidad() 
	{
		ApplicationContext::instance.getSingleton(typeof(Comunidad))
	}
	
	
}