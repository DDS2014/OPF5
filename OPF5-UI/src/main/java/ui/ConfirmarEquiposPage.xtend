package ui

import applicationModel.GeneradorDeEquipos
import dao.SessionManager
import domain.Jugador
import java.util.ArrayList
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.commons.model.UserException
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import org.uqbar.wicket.xtend.XListView

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
		this.agregarFeedbackPanel(confirmarForm)
		this.addChild(confirmarForm)

		
	}
	
	
	def agregarGrilla(Form<GeneradorDeEquipos> form) //FIXME la misma consigna dice que no hay que repetir código acá
	{
		var equipos = new ArrayList<XListView<Jugador>>
		equipos.add (new XListView("primerEquipo"))
		equipos.add (new XListView("segundoEquipo"))
		
		for(XListView<Jugador> grilla : equipos)
		{
			grilla.populateItem = [ item | 
				item.model = item.modelObject.asCompoundModel
				item.addChild = new LinkJugador("link", item.modelObject as Jugador, this)]
	//			item.addChild = new XLink("link1").add(new Label("nombre"))]			
			form.addChild(grilla)
		}
	}
	
	def agregarAcciones(Form<GeneradorDeEquipos> form) {
		val generarBtn = new XButton("btnConfirmar")
		generarBtn.onClick = [| this.confirmar() 
								SessionManager::session.merge(generador.partido)
								SessionManager::commit()
		]
		form.addChild(generarBtn)
		
		val volverBtn = new XButton("btnVolver")
		volverBtn.onClick = [| this.volver() ]
		form.addChild(volverBtn)
	}
	
	def confirmar()
	{
		try{
			this.generador.confirmar()
			//SessionManager::commit
			volver()
		} catch (UserException e) {
			info(e.getMessage())
		} catch (RuntimeException e) {
			error("Ocurrió un error al intentar confirmar el equipo. Error: " + e.message)
		}
	}
	
	def volver()
	{
		responsePage = parentPage
	}
	

	def agregarFeedbackPanel(Form<GeneradorDeEquipos> form) {
		form.addChild(new FeedbackPanel("feedbackPanel"))
	}	

	
}