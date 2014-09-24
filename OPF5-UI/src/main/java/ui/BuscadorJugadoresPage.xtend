package ui

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import applicationModel.BuscadorDeJugadores
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.markup.html.form.TextField
import org.uqbar.wicket.xtend.XButton
import org.uqbar.wicket.xtend.XListView
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.form.DropDownChoice
import domain.busqueda.CriterioBusqueda
import domain.busqueda.*
import java.util.Date
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.uqbar.commons.model.UserException

class BuscadorJugadoresPage  extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	var BuscadorDeJugadores buscador
	var HomePage parentPage;
	
	var WebMarkupContainer selectorDiv;
	var WebMarkupContainer inputDivs
	var WebMarkupContainer nombreDiv
	var WebMarkupContainer apodoDiv
	var WebMarkupContainer fechaDiv
	var WebMarkupContainer handicapDivs
	var WebMarkupContainer promedioDiv
	var WebMarkupContainer infraccionesDiv
	
	new(HomePage parentPage){
		this.buscador = new BuscadorDeJugadores
		this.parentPage = parentPage
		val Form<BuscadorDeJugadores> buscarForm = new Form<BuscadorDeJugadores>("buscarJugadoresForm", new CompoundPropertyModel<BuscadorDeJugadores>(this.buscador))
		this.agregarSelectorBusqueda(buscarForm)
		this.agregarCamposBusqueda(buscarForm)
		this.agregarGrillaResultados(buscarForm)
		this.agregarFeedbackPanel(buscarForm)
		this.agregarBotonVolver(buscarForm)
		this.addChild(buscarForm)
		this.buscarJugadores()
	}
	
	def agregarBotonVolver(Form<BuscadorDeJugadores> form) {
		val volverBtn = new XButton("btnVolver")
		volverBtn.onClick = [| volver() ]
		form.addChild(volverBtn)
	}
	
	def volver()
	{
		responsePage = parentPage
	}
	
	def agregarFeedbackPanel(Form<BuscadorDeJugadores> form) {
		form.addChild(new FeedbackPanel("feedbackPanel"))
	}
	
	def agregarSelectorBusqueda(Form<BuscadorDeJugadores> parent) {
		var div = new WebMarkupContainer("selectorDiv")
		
		val selectButton = new XButton("seleccionar")
		selectButton.onClick = [| this.seleccionarCriterio ]
		div.addChild(selectButton)
		
		div.addChild(new DropDownChoice<CriterioBusqueda>("criterio") =>
			[choices = buscador.criteriosDisponibles])
		
		parent.addChild(div)
		this.selectorDiv = div
	}

	def agregarCamposBusqueda(Form<BuscadorDeJugadores> parent) {
		var div = new WebMarkupContainer("inputDivs")
		
		//INPUTS
		//Nombre
		var divNombre = new WebMarkupContainer("nombreDiv")
		divNombre.addChild(new TextField<String>("criterioNombre.nombre"))
		div.addChild(divNombre)
		this.nombreDiv = divNombre
		//Apodo
		var divApodo = new WebMarkupContainer("apodoDiv")
		divApodo.addChild(new TextField<String>("criterioApodo.apodo"))
		div.addChild(divApodo)
		this.apodoDiv = divApodo
		//Fecha de nacimiento
		var divFecha = new WebMarkupContainer("fechaDiv")
		divFecha.addChild(new TextField<Date>("criterioEdad.fecha"))
		div.addChild(divFecha)
		this.fechaDiv = divFecha
		//Handicap
		var divHandicap = new WebMarkupContainer("handicapDiv")
		divHandicap.addChild(new TextField<Double>("criterioHandicap.desde"))
		divHandicap.addChild(new TextField<Double>("criterioHandicap.hasta"))
		div.addChild(divHandicap)
		this.handicapDivs = divHandicap
		//Promedio
		var divPromedio = new WebMarkupContainer("promedioDiv")
		divPromedio.addChild(new TextField<Double>("criterioPromedio.desde"))
		divPromedio.addChild(new TextField<Double>("criterioPromedio.hasta"))
		div.addChild(divPromedio)
		this.promedioDiv = divPromedio
		//Infracciones
		var divInfracciones = new WebMarkupContainer("infraccionesDiv")
		divInfracciones.addChild(new DropDownChoice<CriterioBusqueda>("criterio") =>
			[choices = buscador.criterioInfracciones.criterios])
		div.addChild(divInfracciones)
		this.infraccionesDiv = divInfracciones
		
		//ACTIONS
		div.addChild(new XButton("buscar")
			.onClick = [| buscarJugadores ]
		)
		div.addChild(new XButton("limpiar")
			.onClick = [| limpiar ]
		)
		
		parent.addChild(div)
		this.inputDivs = div
		this.inputDivs.setVisible(false)
	}
	
	def limpiar(){
		buscador.clear
		selectorDiv.setVisible(true)
		inputDivs.setVisible(false)
	}
	
	def buscarJugadores() {
		try{
			this.buscador.search()
		} catch (UserException e) {
			info(e.getMessage())
		} catch (RuntimeException e) {
			error("Ocurrió un error al realizar la búsqueda solicitada. Error: " + e.message)
		}
	}

	def seleccionarCriterio(){
		if(buscador.criterio!=null)
		{
			selectorDiv.setVisible(false)
			inputDivs.setVisible(true)
			ocultarDivs()
			if(buscador.criterio.class == BusquedaNombre)
				this.nombreDiv.setVisible(true)
			else if(buscador.criterio.class == BusquedaApodo)
				this.apodoDiv.setVisible(true)
			else if(buscador.criterio.class == BusquedaEdad)
				this.fechaDiv.setVisible(true)
			else if(buscador.criterio.class == BusquedaHandicap)
				this.handicapDivs.setVisible(true)
			else if(buscador.criterio.class == BusquedaPromedio)
				this.promedioDiv.setVisible(true)
			else if(buscador.criterio.class == BusquedaCompuesta)
				this.infraccionesDiv.setVisible(true)
		}
		else
			info("Debe seleccionar un criterio de búsqueda.")
	}
	
	def ocultarDivs(){
		this.nombreDiv.setVisible(false)
		this.apodoDiv.setVisible(false)
		this.fechaDiv.setVisible(false)
		this.handicapDivs.setVisible(false)
		this.promedioDiv.setVisible(false)
		this.infraccionesDiv.setVisible(false)
	}
	
	def agregarGrillaResultados(Form<BuscadorDeJugadores> parent) {
		val listView = new XListView("resultados")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new LinkJugador("link", item.modelObject, this))
			item.addChild(new Label("apodo"))
			item.addChild(new Label("handicap"))
			item.addChild(new Label("promedioUltimoPartido"))
		]
		parent.addChild(listView)
	}
}