package ui;

import domain.Jugador;
import domain.sugerencias.Comunidad;
import home.HomeComunidad;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import org.uqbar.wicket.xtend.XListView;
import ui.LinkJugador;

@SuppressWarnings("all")
public class InfoJugadorPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private Jugador jugador;
  
  private WebPage parentPage;
  
  public InfoJugadorPage(final Jugador jugador, final WebPage parentPage) {
    this.parentPage = parentPage;
    this.jugador = jugador;
    CompoundPropertyModel<Jugador> _asCompoundModel = this._wicketExtensionFactoryMethods.<Jugador>asCompoundModel(this.jugador);
    final Form<Jugador> infoJugadorForm = new Form<Jugador>("infoJugadorForm", _asCompoundModel);
    this.agregarAcciones(infoJugadorForm);
    this.agregarGrillaDatos(infoJugadorForm);
    this.agregarGrillaAmigos(infoJugadorForm);
    this.agregarGrillaInfracciones(infoJugadorForm);
    this._wicketExtensionFactoryMethods.addChild(this, infoJugadorForm);
  }
  
  public MarkupContainer agregarGrillaInfracciones(final Form<Jugador> form) {
    MarkupContainer _xblockexpression = null;
    {
      XListView<Object> listInfracciones = new XListView<Object>("infracciones");
      final Procedure1<ListItem<Object>> _function = new Procedure1<ListItem<Object>>() {
        public void apply(final ListItem<Object> item) {
          Object _modelObject = item.getModelObject();
          CompoundPropertyModel<Object> _asCompoundModel = InfoJugadorPage.this._wicketExtensionFactoryMethods.<Object>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("fecha");
          InfoJugadorPage.this._wicketExtensionFactoryMethods.addChild(item, _label);
          Label _label_1 = new Label("motivo");
          InfoJugadorPage.this._wicketExtensionFactoryMethods.addChild(item, _label_1);
        }
      };
      listInfracciones.setPopulateItem(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, listInfracciones);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer agregarGrillaDatos(final Form<Jugador> form) {
    MarkupContainer _xblockexpression = null;
    {
      Label _label = new Label("nombre");
      this._wicketExtensionFactoryMethods.addChild(form, _label);
      Label _label_1 = new Label("apodo");
      this._wicketExtensionFactoryMethods.addChild(form, _label_1);
      Label _label_2 = new Label("handicap");
      this._wicketExtensionFactoryMethods.addChild(form, _label_2);
      HomeComunidad _homeComunidad = this.getHomeComunidad();
      double _promedioUltimoPartido = _homeComunidad.promedioUltimoPartido(this.jugador);
      String _string = Double.valueOf(_promedioUltimoPartido).toString();
      Label _label_3 = new Label("promedioUltimoPartido", ((String) _string));
      this._wicketExtensionFactoryMethods.addChild(form, _label_3);
      Label _label_4 = new Label("promedioGlobal");
      this._wicketExtensionFactoryMethods.addChild(form, _label_4);
      Label _label_5 = new Label("edad");
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, _label_5);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer agregarAcciones(final Form<Jugador> form) {
    MarkupContainer _xblockexpression = null;
    {
      final XButton volverBtn = new XButton("btnVolver");
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          InfoJugadorPage.this.volver();
        }
      };
      volverBtn.setOnClick(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, volverBtn);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer agregarGrillaAmigos(final Form<Jugador> form) {
    MarkupContainer _xblockexpression = null;
    {
      XListView<Jugador> listAmigos = new XListView<Jugador>("amigos");
      final Procedure1<ListItem<Jugador>> _function = new Procedure1<ListItem<Jugador>>() {
        public void apply(final ListItem<Jugador> item) {
          Jugador _modelObject = item.getModelObject();
          CompoundPropertyModel<Jugador> _asCompoundModel = InfoJugadorPage.this._wicketExtensionFactoryMethods.<Jugador>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Jugador _modelObject_1 = item.getModelObject();
          LinkJugador _linkJugador = new LinkJugador("link", _modelObject_1, InfoJugadorPage.this);
          InfoJugadorPage.this._wicketExtensionFactoryMethods.addChild(item, _linkJugador);
          Label _label = new Label("apodo");
          InfoJugadorPage.this._wicketExtensionFactoryMethods.addChild(item, _label);
          Label _label_1 = new Label("handicap");
          InfoJugadorPage.this._wicketExtensionFactoryMethods.addChild(item, _label_1);
          Label _label_2 = new Label("promedioGlobal");
          InfoJugadorPage.this._wicketExtensionFactoryMethods.addChild(item, _label_2);
        }
      };
      listAmigos.setPopulateItem(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, listAmigos);
    }
    return _xblockexpression;
  }
  
  public void volver() {
    this.setResponsePage(this.parentPage);
  }
  
  public HomeComunidad getHomeComunidad() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeComunidad>getSingleton(Comunidad.class);
  }
}
