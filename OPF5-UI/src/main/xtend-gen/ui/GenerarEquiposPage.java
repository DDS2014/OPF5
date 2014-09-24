package ui;

import applicationModel.GeneradorDeEquipos;
import domain.generacionDeEquipos.algoritmosDeGeneracion.Generacion;
import domain.generacionDeEquipos.criteriosDeEvaluacion.Criterio;
import java.util.ArrayList;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import ui.ConfirmarEquiposPage;
import ui.HomePage;

@SuppressWarnings("all")
public class GenerarEquiposPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private GeneradorDeEquipos generador;
  
  private HomePage parentPage;
  
  public GenerarEquiposPage(final HomePage parentPage) {
    GeneradorDeEquipos _generadorDeEquipos = new GeneradorDeEquipos();
    this.generador = _generadorDeEquipos;
    this.parentPage = parentPage;
    CompoundPropertyModel<GeneradorDeEquipos> _compoundPropertyModel = new CompoundPropertyModel<GeneradorDeEquipos>(this.generador);
    final Form<GeneradorDeEquipos> generarForm = new Form<GeneradorDeEquipos>("generarEquiposForm", _compoundPropertyModel);
    this.agregarOpciones(generarForm);
    this.agregarAcciones(generarForm);
    this.agregarGrilla(generarForm);
    this._wicketExtensionFactoryMethods.addChild(this, generarForm);
  }
  
  public MarkupContainer agregarOpciones(final Form<GeneradorDeEquipos> form) {
    MarkupContainer _xblockexpression = null;
    {
      DropDownChoice<Criterio> _dropDownChoice = new DropDownChoice<Criterio>("criterioDeOrdenamiento");
      final Procedure1<DropDownChoice<Criterio>> _function = new Procedure1<DropDownChoice<Criterio>>() {
        public void apply(final DropDownChoice<Criterio> it) {
          ArrayList<Criterio> _criteriosDeOrdenamiento = GenerarEquiposPage.this.generador.getCriteriosDeOrdenamiento();
          it.setChoices(_criteriosDeOrdenamiento);
          final Function1<Criterio, String> _function = new Function1<Criterio, String>() {
            public String apply(final Criterio cr) {
              return cr.getNombreDelCriterio();
            }
          };
          ChoiceRenderer<Criterio> _choiceRenderer = GenerarEquiposPage.this._wicketExtensionFactoryMethods.<Criterio>choiceRenderer(_function);
          it.setChoiceRenderer(_choiceRenderer);
        }
      };
      DropDownChoice<Criterio> _doubleArrow = ObjectExtensions.<DropDownChoice<Criterio>>operator_doubleArrow(_dropDownChoice, _function);
      this._wicketExtensionFactoryMethods.addChild(form, _doubleArrow);
      TextField<Integer> _textField = new TextField<Integer>("criterioDeLasUltimasCalificaciones.cantidadDeCalificaciones");
      this._wicketExtensionFactoryMethods.addChild(form, _textField);
      DropDownChoice<Generacion> _dropDownChoice_1 = new DropDownChoice<Generacion>("criterioDeSeleccion");
      final Procedure1<DropDownChoice<Generacion>> _function_1 = new Procedure1<DropDownChoice<Generacion>>() {
        public void apply(final DropDownChoice<Generacion> it) {
          ArrayList<Generacion> _criteriosDeSeleccion = GenerarEquiposPage.this.generador.getCriteriosDeSeleccion();
          it.setChoices(_criteriosDeSeleccion);
          final Function1<Generacion, String> _function = new Function1<Generacion, String>() {
            public String apply(final Generacion gen) {
              return gen.getNombreDelAlgoritmo();
            }
          };
          ChoiceRenderer<Generacion> _choiceRenderer = GenerarEquiposPage.this._wicketExtensionFactoryMethods.<Generacion>choiceRenderer(_function);
          it.setChoiceRenderer(_choiceRenderer);
        }
      };
      DropDownChoice<Generacion> _doubleArrow_1 = ObjectExtensions.<DropDownChoice<Generacion>>operator_doubleArrow(_dropDownChoice_1, _function_1);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, _doubleArrow_1);
    }
    return _xblockexpression;
  }
  
  public Object agregarGrilla(final Form<GeneradorDeEquipos> form) {
    return null;
  }
  
  public MarkupContainer agregarAcciones(final Form<GeneradorDeEquipos> form) {
    MarkupContainer _xblockexpression = null;
    {
      final XButton generarBtn = new XButton("btnGenerar");
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          GenerarEquiposPage.this.generar();
        }
      };
      generarBtn.setOnClick(_function);
      this._wicketExtensionFactoryMethods.addChild(form, generarBtn);
      final XButton volverBtn = new XButton("btnVolver");
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          GenerarEquiposPage.this.volver();
        }
      };
      volverBtn.setOnClick(_function_1);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, volverBtn);
    }
    return _xblockexpression;
  }
  
  public void volver() {
    this.setResponsePage(this.parentPage);
  }
  
  public void generar() {
    this.generador.generar();
    ConfirmarEquiposPage _confirmarEquiposPage = new ConfirmarEquiposPage(this.generador, this);
    this.setResponsePage(_confirmarEquiposPage);
  }
}
