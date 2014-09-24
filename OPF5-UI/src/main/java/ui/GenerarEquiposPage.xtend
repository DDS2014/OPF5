package ui

import applicationModel.GeneradorDeEquipos
import domain.generacionDeEquipos.algoritmosDeGeneracion.Generacion
import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.DropDownChoice
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.commons.model.UserException
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import org.uqbar.wicket.xtend.XForm

//import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDeLasUltimasCalificaciones
//import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDelUltimoPartido

class GenerarEquiposPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	var GeneradorDeEquipos generador
	var HomePage parentPage;
	
	
	new(HomePage parentPage){
		this.generador = new GeneradorDeEquipos
		this.parentPage = parentPage;
		val XForm<GeneradorDeEquipos> generarForm = new XForm<GeneradorDeEquipos>("generarEquiposForm", new CompoundPropertyModel<GeneradorDeEquipos>(this.generador))
		this.agregarOpciones(generarForm)
		this.agregarAcciones(generarForm)
		this.agregarGrilla(generarForm)
		this.agregarFeedbackPanel(generarForm)
		this.addChild(generarForm)

		
	}
	
	def agregarOpciones(Form<GeneradorDeEquipos> form) 
	{
		form.addChild( new DropDownChoice<Criterio>("criterioDeOrdenamiento") => 
		[choices = this.generador.criteriosDeOrdenamiento 
		 choiceRenderer = choiceRenderer([Criterio cr | cr.nombreDelCriterio])]) 
		 
		 form.addChild(new TextField<Integer>("criterioDeLasUltimasCalificaciones.cantidadDeCalificaciones"))

		form.addChild( new DropDownChoice<Generacion>("criterioDeSeleccion") => 
		[choices = this.generador.criteriosDeSeleccion
		 choiceRenderer = choiceRenderer([Generacion gen | gen.nombreDelAlgoritmo])]) 
	}
	
	def agregarGrilla(Form<GeneradorDeEquipos> form) 
	{
		
	}
	
	def agregarAcciones(Form<GeneradorDeEquipos> form) {
		val generarBtn = new XButton("btnGenerar")
		generarBtn.onClick = [| this.generar() ]
		form.addChild(generarBtn)
		
		val volverBtn = new XButton("btnVolver")
		volverBtn.onClick = [| this.volver() ]
		form.addChild(volverBtn)
		
	}
	
	def volver()
	{
		responsePage = parentPage
	}
	
	def generar()
	{
		try
		{
			this.generador.generar()
			responsePage = new ConfirmarEquiposPage(this.generador, this)
		} catch (UserException e) {
			info(e.getMessage())
		} catch (RuntimeException e) {
			error("Ocurrió un error al intentar generar el equipo. Error: " + e.message)
		}
	}
	
	def agregarFeedbackPanel(Form<GeneradorDeEquipos> form) {
		form.addChild(new FeedbackPanel("feedbackPanel"))
	}	
	
	
	
}