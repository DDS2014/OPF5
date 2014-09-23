package ui;

import applicationModel.GeneradorDeEquipos;
import domain.Jugador;
import java.util.ArrayList;
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
  
  public void agregarGrilla(final Form<GeneradorDeEquipos> form) {
    ArrayList<XListView<Jugador>> equipos = new ArrayList<XListView<Jugador>>();
    XListView<Jugador> _xListView = new XListView<Jugador>("primerEquipo");
    equipos.add(_xListView);
    XListView<Jugador> _xListView_1 = new XListView<Jugador>("segundoEquipo");
    equipos.add(_xListView_1);
    for (final XListView<Jugador> grilla : equipos) {
      {
        final Procedure1<ListItem<Jugador>> _function = new Procedure1<ListItem<Jugador>>() {
          public void apply(final ListItem<Jugador> item) {
            Jugador _modelObject = item.getModelObject();
            CompoundPropertyModel<Jugador> _asCompoundModel = ConfirmarEquiposPage.this._wicketExtensionFactoryMethods.<Jugador>asCompoundModel(_modelObject);
            item.setModel(_asCompoundModel);
            Jugador _modelObject_1 = item.getModelObject();
            LinkJugador _linkJugador = new LinkJugador("link", ((Jugador) _modelObject_1), ConfirmarEquiposPage.this);
            ConfirmarEquiposPage.this._wicketExtensionFactoryMethods.addChild(item, _linkJugador);
          }
        };
        grilla.setPopulateItem(_function);
        this._wicketExtensionFactoryMethods.addChild(form, grilla);
      }
    }
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
