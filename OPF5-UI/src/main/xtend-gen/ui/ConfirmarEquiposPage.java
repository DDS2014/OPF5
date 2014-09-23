package ui;

import applicationModel.GeneradorDeEquipos;
import domain.Jugador;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import org.uqbar.wicket.xtend.XListView;
import ui.GenerarEquiposPage;
import ui.LinkJugador;

@SuppressWarnings("all")
public class ConfirmarEquiposPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private GeneradorDeEquipos generador;
  
  private GenerarEquiposPage parentPage;
  
  public ConfirmarEquiposPage(final GeneradorDeEquipos generador, final GenerarEquiposPage parentPage) {
    this.generador = generador;
    this.parentPage = parentPage;
    CompoundPropertyModel<GeneradorDeEquipos> _compoundPropertyModel = new CompoundPropertyModel<GeneradorDeEquipos>(this.generador);
    final Form<GeneradorDeEquipos> confirmarForm = new Form<GeneradorDeEquipos>("confirmarEquiposForm", _compoundPropertyModel);
    this.agregarAcciones(confirmarForm);
    this.agregarGrilla(confirmarForm);
    this._wicketExtensionFactoryMethods.addChild(this, confirmarForm);
  }
  
  public MarkupContainer agregarGrilla(final Form<GeneradorDeEquipos> form) {
    MarkupContainer _xblockexpression = null;
    {
      XListView<Object> listaEquipo1 = new XListView<Object>("primerEquipo");
      XListView<Object> listaEquipo2 = new XListView<Object>("segundoEquipo");
      final Procedure1<ListItem<Object>> _function = new Procedure1<ListItem<Object>>() {
        public void apply(final ListItem<Object> item) {
          Object _modelObject = item.getModelObject();
          CompoundPropertyModel<Object> _asCompoundModel = ConfirmarEquiposPage.this._wicketExtensionFactoryMethods.<Object>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Object _modelObject_1 = item.getModelObject();
          LinkJugador _linkJugador = new LinkJugador("link1", ((Jugador) _modelObject_1), ConfirmarEquiposPage.this);
          ConfirmarEquiposPage.this._wicketExtensionFactoryMethods.addChild(item, _linkJugador);
        }
      };
      listaEquipo1.setPopulateItem(_function);
      final Procedure1<ListItem<Object>> _function_1 = new Procedure1<ListItem<Object>>() {
        public void apply(final ListItem<Object> item) {
          Object _modelObject = item.getModelObject();
          CompoundPropertyModel<Object> _asCompoundModel = ConfirmarEquiposPage.this._wicketExtensionFactoryMethods.<Object>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Object _modelObject_1 = item.getModelObject();
          LinkJugador _linkJugador = new LinkJugador("link2", ((Jugador) _modelObject_1), ConfirmarEquiposPage.this);
          ConfirmarEquiposPage.this._wicketExtensionFactoryMethods.addChild(item, _linkJugador);
        }
      };
      listaEquipo2.setPopulateItem(_function_1);
      this._wicketExtensionFactoryMethods.addChild(form, listaEquipo1);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, listaEquipo2);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer agregarAcciones(final Form<GeneradorDeEquipos> form) {
    MarkupContainer _xblockexpression = null;
    {
      final XButton generarBtn = new XButton("btnConfirmar");
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          ConfirmarEquiposPage.this.confirmar();
        }
      };
      generarBtn.setOnClick(_function);
      this._wicketExtensionFactoryMethods.addChild(form, generarBtn);
      final XButton volverBtn = new XButton("btnVolver");
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          ConfirmarEquiposPage.this.volver();
        }
      };
      volverBtn.setOnClick(_function_1);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, volverBtn);
    }
    return _xblockexpression;
  }
  
  public void confirmar() {
    this.generador.confirmar();
    this.volver();
  }
  
  public void volver() {
    this.setResponsePage(this.parentPage);
  }
}
