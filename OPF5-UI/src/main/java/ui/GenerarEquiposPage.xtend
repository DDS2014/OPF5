package ui

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import applicationModel.GeneradorDeEquipos
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.markup.html.form.DropDownChoice
import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio
import java.util.ArrayList
import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDelHandicap
import domain.generacionDeEquipos.algoritmosDeGeneracion.Generacion
import domain.generacionDeEquipos.algoritmosDeGeneracion.GeneracionConcreta
import domain.generacionDeEquipos.algoritmosDeGeneracion.GeneracionParImpar
import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDeLasUltimasCalificaciones
import org.apache.wicket.markup.html.form.TextField
import java.math.BigDecimal

//import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDeLasUltimasCalificaciones
//import domain.generacionDeEquipos.criteriosDeEvaluacion.CriterioDelUltimoPartido

class GenerarEquiposPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	var GeneradorDeEquipos generador
	var HomePage parentPage;
	
	
	new(HomePage parentPage){
		this.generador = new GeneradorDeEquipos
		this.parentPage = parentPage;
		val Form<GeneradorDeEquipos> generarForm = new Form<GeneradorDeEquipos>("generarEquiposForm", new CompoundPropertyModel<GeneradorDeEquipos>(this.generador))
		this.agregarOpciones(generarForm)
		this.agregarAcciones(generarForm)
		this.agregarGrilla(generarForm)
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
		this.generador.generar()
		responsePage = new ConfirmarEquiposPage(this.generador, this)
	}
	
	
	
	
	
}