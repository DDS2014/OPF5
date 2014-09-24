package ui;

import domain.Jugador;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import org.uqbar.wicket.xtend.XListView;

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
    this._wicketExtensionFactoryMethods.addChild(this, infoJugadorForm);
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
      Label _label_3 = new Label("edad");
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, _label_3);
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
      XListView<Object> listAmigos = new XListView<Object>("amigos");
      final Procedure1<ListItem<Object>> _function = new Procedure1<ListItem<Object>>() {
        public void apply(final ListItem<Object> item) {
          Object _modelObject = item.getModelObject();
          CompoundPropertyModel<Object> _asCompoundModel = InfoJugadorPage.this._wicketExtensionFactoryMethods.<Object>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("nombre");
          InfoJugadorPage.this._wicketExtensionFactoryMethods.addChild(item, _label);
          Label _label_1 = new Label("apodo");
          InfoJugadorPage.this._wicketExtensionFactoryMethods.addChild(item, _label_1);
          Label _label_2 = new Label("handicap");
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
}
