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
		[choices = this.getCriteriosOrdenamiento()
		 choiceRenderer = choiceRenderer([Criterio cr | cr.nombreDelCriterio])]) //alguien dijo refactor?
		
		form.addChild( new DropDownChoice<Generacion>("criterioDeSeleccion") => 
		[choices = this.getCriteriosSeleccion()
		 choiceRenderer = choiceRenderer([Generacion gen | gen.nombreDelAlgoritmo])]) //alguien dijo refactor?
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
	

	
	def getCriteriosOrdenamiento()
	{
		var criterios = new ArrayList<Criterio>
		criterios.add(new CriterioDelHandicap)
		criterios.add(new CriterioDeLasUltimasCalificaciones(3)) //ese 3 hardcodeado so strong. FIXME ver cómo podemos hacer para pedirle ese número al usuario
		// criterios.add(new CriterioDelUltimoPartido) este no sirve, necesito la comunidad
		//y el criterio compuesto?
		//obviamente necesitamos una interfaz para definir el criterio compuesto y la cantidad de calificaciones
		return criterios
	}
	
	
	def getCriteriosSeleccion()
	{
		var criterios = new ArrayList<Generacion>
		criterios.add(new GeneracionConcreta())
		criterios.add(new GeneracionParImpar())
		return criterios
	}
	
}