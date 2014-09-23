package ui;

import applicationModel.BuscadorDeJugadores;
import com.google.common.base.Objects;
import domain.busqueda.BusquedaApodo;
import domain.busqueda.BusquedaCompuesta;
import domain.busqueda.BusquedaEdad;
import domain.busqueda.BusquedaHandicap;
import domain.busqueda.BusquedaNombre;
import domain.busqueda.BusquedaPromedio;
import domain.busqueda.CriterioBusqueda;
import java.util.Date;
import java.util.List;
import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import org.uqbar.wicket.xtend.XListView;

@SuppressWarnings("all")
public class BuscadorJugadoresPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new Function0<WicketExtensionFactoryMethods>() {
    public WicketExtensionFactoryMethods apply() {
      WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
      return _wicketExtensionFactoryMethods;
    }
  }.apply();
  
  private BuscadorDeJugadores buscador;
  
  private WebMarkupContainer selectorDiv;
  
  private WebMarkupContainer inputDivs;
  
  private WebMarkupContainer nombreDiv;
  
  private WebMarkupContainer apodoDiv;
  
  private WebMarkupContainer fechaDiv;
  
  private WebMarkupContainer handicapDivs;
  
  private WebMarkupContainer promedioDiv;
  
  private WebMarkupContainer infraccionesDiv;
  
  public BuscadorJugadoresPage() {
    BuscadorDeJugadores _buscadorDeJugadores = new BuscadorDeJugadores();
    this.buscador = _buscadorDeJugadores;
    CompoundPropertyModel<BuscadorDeJugadores> _compoundPropertyModel = new CompoundPropertyModel<BuscadorDeJugadores>(this.buscador);
    Form<BuscadorDeJugadores> _form = new Form<BuscadorDeJugadores>("buscarJugadoresForm", _compoundPropertyModel);
    final Form<BuscadorDeJugadores> buscarForm = _form;
    this.agregarSelectorBusqueda(buscarForm);
    this.agregarCamposBusqueda(buscarForm);
    this.agregarGrillaResultados(buscarForm);
    this._wicketExtensionFactoryMethods.addChild(this, buscarForm);
    this.buscarJugadores();
  }
  
  public WebMarkupContainer agregarSelectorBusqueda(final Form<BuscadorDeJugadores> parent) {
    WebMarkupContainer _xblockexpression = null;
    {
      WebMarkupContainer _webMarkupContainer = new WebMarkupContainer("selectorDiv");
      WebMarkupContainer div = _webMarkupContainer;
      XButton _xButton = new XButton("seleccionar");
      final XButton selectButton = _xButton;
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          BuscadorJugadoresPage.this.seleccionarCriterio();
        }
      };
      selectButton.setOnClick(_function);
      this._wicketExtensionFactoryMethods.addChild(div, selectButton);
      DropDownChoice<CriterioBusqueda> _dropDownChoice = new DropDownChoice<CriterioBusqueda>("criterio");
      final Procedure1<DropDownChoice<CriterioBusqueda>> _function_1 = new Procedure1<DropDownChoice<CriterioBusqueda>>() {
        public void apply(final DropDownChoice<CriterioBusqueda> it) {
          List<CriterioBusqueda> _criteriosDisponibles = BuscadorJugadoresPage.this.buscador.getCriteriosDisponibles();
          it.setChoices(_criteriosDisponibles);
        }
      };
      DropDownChoice<CriterioBusqueda> _doubleArrow = ObjectExtensions.<DropDownChoice<CriterioBusqueda>>operator_doubleArrow(_dropDownChoice, _function_1);
      this._wicketExtensionFactoryMethods.addChild(div, _doubleArrow);
      this._wicketExtensionFactoryMethods.addChild(parent, div);
      WebMarkupContainer _selectorDiv = this.selectorDiv = div;
      _xblockexpression = (_selectorDiv);
    }
    return _xblockexpression;
  }
  
  public Component agregarCamposBusqueda(final Form<BuscadorDeJugadores> parent) {
    Component _xblockexpression = null;
    {
      WebMarkupContainer _webMarkupContainer = new WebMarkupContainer("inputDivs");
      WebMarkupContainer div = _webMarkupContainer;
      WebMarkupContainer _webMarkupContainer_1 = new WebMarkupContainer("nombreDiv");
      WebMarkupContainer divNombre = _webMarkupContainer_1;
      TextField<String> _textField = new TextField<String>("criterioNombre.nombre");
      this._wicketExtensionFactoryMethods.addChild(divNombre, _textField);
      this._wicketExtensionFactoryMethods.addChild(div, divNombre);
      this.nombreDiv = divNombre;
      WebMarkupContainer _webMarkupContainer_2 = new WebMarkupContainer("apodoDiv");
      WebMarkupContainer divApodo = _webMarkupContainer_2;
      TextField<String> _textField_1 = new TextField<String>("criterioApodo.apodo");
      this._wicketExtensionFactoryMethods.addChild(divApodo, _textField_1);
      this._wicketExtensionFactoryMethods.addChild(div, divApodo);
      this.apodoDiv = divApodo;
      WebMarkupContainer _webMarkupContainer_3 = new WebMarkupContainer("fechaDiv");
      WebMarkupContainer divFecha = _webMarkupContainer_3;
      TextField<Date> _textField_2 = new TextField<Date>("criterioEdad.fecha");
      this._wicketExtensionFactoryMethods.addChild(divFecha, _textField_2);
      this._wicketExtensionFactoryMethods.addChild(div, divFecha);
      this.fechaDiv = divFecha;
      WebMarkupContainer _webMarkupContainer_4 = new WebMarkupContainer("handicapDiv");
      WebMarkupContainer divHandicap = _webMarkupContainer_4;
      TextField<Double> _textField_3 = new TextField<Double>("criterioHandicap.desde");
      this._wicketExtensionFactoryMethods.addChild(divHandicap, _textField_3);
      TextField<Double> _textField_4 = new TextField<Double>("criterioHandicap.hasta");
      this._wicketExtensionFactoryMethods.addChild(divHandicap, _textField_4);
      this._wicketExtensionFactoryMethods.addChild(div, divHandicap);
      this.handicapDivs = divHandicap;
      WebMarkupContainer _webMarkupContainer_5 = new WebMarkupContainer("promedioDiv");
      WebMarkupContainer divPromedio = _webMarkupContainer_5;
      TextField<Double> _textField_5 = new TextField<Double>("criterioPromedio.desde");
      this._wicketExtensionFactoryMethods.addChild(divPromedio, _textField_5);
      TextField<Double> _textField_6 = new TextField<Double>("criterioPromedio.hasta");
      this._wicketExtensionFactoryMethods.addChild(divPromedio, _textField_6);
      this._wicketExtensionFactoryMethods.addChild(div, divPromedio);
      this.promedioDiv = divPromedio;
      WebMarkupContainer _webMarkupContainer_6 = new WebMarkupContainer("infraccionesDiv");
      WebMarkupContainer divInfracciones = _webMarkupContainer_6;
      DropDownChoice<CriterioBusqueda> _dropDownChoice = new DropDownChoice<CriterioBusqueda>("criterio");
      final Procedure1<DropDownChoice<CriterioBusqueda>> _function = new Procedure1<DropDownChoice<CriterioBusqueda>>() {
        public void apply(final DropDownChoice<CriterioBusqueda> it) {
          BusquedaCompuesta _criterioInfracciones = BuscadorJugadoresPage.this.buscador.getCriterioInfracciones();
          List<CriterioBusqueda> _criterios = _criterioInfracciones.getCriterios();
          it.setChoices(_criterios);
        }
      };
      DropDownChoice<CriterioBusqueda> _doubleArrow = ObjectExtensions.<DropDownChoice<CriterioBusqueda>>operator_doubleArrow(_dropDownChoice, _function);
      this._wicketExtensionFactoryMethods.addChild(divInfracciones, _doubleArrow);
      this._wicketExtensionFactoryMethods.addChild(div, divInfracciones);
      this.infraccionesDiv = divInfracciones;
      XButton _xButton = new XButton("buscar");
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          BuscadorJugadoresPage.this.buscarJugadores();
        }
      };
      XButton _setOnClick = _xButton.setOnClick(_function_1);
      this._wicketExtensionFactoryMethods.addChild(div, _setOnClick);
      XButton _xButton_1 = new XButton("limpiar");
      final Procedure0 _function_2 = new Procedure0() {
        public void apply() {
          BuscadorJugadoresPage.this.limpiar();
        }
      };
      XButton _setOnClick_1 = _xButton_1.setOnClick(_function_2);
      this._wicketExtensionFactoryMethods.addChild(div, _setOnClick_1);
      this._wicketExtensionFactoryMethods.addChild(parent, div);
      this.inputDivs = div;
      Component _setVisible = this.inputDivs.setVisible(false);
      _xblockexpression = (_setVisible);
    }
    return _xblockexpression;
  }
  
  public Component limpiar() {
    Component _xblockexpression = null;
    {
      this.buscador.clear();
      this.selectorDiv.setVisible(true);
      Component _setVisible = this.inputDivs.setVisible(false);
      _xblockexpression = (_setVisible);
    }
    return _xblockexpression;
  }
  
  public void buscarJugadores() {
    this.buscador.search();
  }
  
  public Component seleccionarCriterio() {
    Component _xifexpression = null;
    CriterioBusqueda _criterio = this.buscador.getCriterio();
    boolean _notEquals = (!Objects.equal(_criterio, null));
    if (_notEquals) {
      Component _xblockexpression = null;
      {
        this.selectorDiv.setVisible(false);
        this.inputDivs.setVisible(true);
        this.ocultarDivs();
        Component _xifexpression_1 = null;
        CriterioBusqueda _criterio_1 = this.buscador.getCriterio();
        Class<? extends CriterioBusqueda> _class = _criterio_1.getClass();
        boolean _equals = Objects.equal(_class, BusquedaNombre.class);
        if (_equals) {
          Component _setVisible = this.nombreDiv.setVisible(true);
          _xifexpression_1 = _setVisible;
        } else {
          Component _xifexpression_2 = null;
          CriterioBusqueda _criterio_2 = this.buscador.getCriterio();
          Class<? extends CriterioBusqueda> _class_1 = _criterio_2.getClass();
          boolean _equals_1 = Objects.equal(_class_1, BusquedaApodo.class);
          if (_equals_1) {
            Component _setVisible_1 = this.apodoDiv.setVisible(true);
            _xifexpression_2 = _setVisible_1;
          } else {
            Component _xifexpression_3 = null;
            CriterioBusqueda _criterio_3 = this.buscador.getCriterio();
            Class<? extends CriterioBusqueda> _class_2 = _criterio_3.getClass();
            boolean _equals_2 = Objects.equal(_class_2, BusquedaEdad.class);
            if (_equals_2) {
              Component _setVisible_2 = this.fechaDiv.setVisible(true);
              _xifexpression_3 = _setVisible_2;
            } else {
              Component _xifexpression_4 = null;
              CriterioBusqueda _criterio_4 = this.buscador.getCriterio();
              Class<? extends CriterioBusqueda> _class_3 = _criterio_4.getClass();
              boolean _equals_3 = Objects.equal(_class_3, BusquedaHandicap.class);
              if (_equals_3) {
                Component _setVisible_3 = this.handicapDivs.setVisible(true);
                _xifexpression_4 = _setVisible_3;
              } else {
                Component _xifexpression_5 = null;
                CriterioBusqueda _criterio_5 = this.buscador.getCriterio();
                Class<? extends CriterioBusqueda> _class_4 = _criterio_5.getClass();
                boolean _equals_4 = Objects.equal(_class_4, BusquedaPromedio.class);
                if (_equals_4) {
                  Component _setVisible_4 = this.promedioDiv.setVisible(true);
                  _xifexpression_5 = _setVisible_4;
                } else {
                  Component _xifexpression_6 = null;
                  CriterioBusqueda _criterio_6 = this.buscador.getCriterio();
                  Class<? extends CriterioBusqueda> _class_5 = _criterio_6.getClass();
                  boolean _equals_5 = Objects.equal(_class_5, BusquedaCompuesta.class);
                  if (_equals_5) {
                    Component _setVisible_5 = this.infraccionesDiv.setVisible(true);
                    _xifexpression_6 = _setVisible_5;
                  }
                  _xifexpression_5 = _xifexpression_6;
                }
                _xifexpression_4 = _xifexpression_5;
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xblockexpression = (_xifexpression_1);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public Component ocultarDivs() {
    Component _xblockexpression = null;
    {
      this.nombreDiv.setVisible(false);
      this.apodoDiv.setVisible(false);
      this.fechaDiv.setVisible(false);
      this.handicapDivs.setVisible(false);
      this.promedioDiv.setVisible(false);
      Component _setVisible = this.infraccionesDiv.setVisible(false);
      _xblockexpression = (_setVisible);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer agregarGrillaResultados(final Form<BuscadorDeJugadores> parent) {
    MarkupContainer _xblockexpression = null;
    {
      XListView<Object> _xListView = new XListView<Object>("resultados");
      final XListView<Object> listView = _xListView;
      final Procedure1<ListItem<Object>> _function = new Procedure1<ListItem<Object>>() {
        public void apply(final ListItem<Object> item) {
          Object _modelObject = item.getModelObject();
          CompoundPropertyModel<Object> _asCompoundModel = BuscadorJugadoresPage.this._wicketExtensionFactoryMethods.<Object>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("nombre");
          BuscadorJugadoresPage.this._wicketExtensionFactoryMethods.addChild(item, _label);
          Label _label_1 = new Label("apodo");
          BuscadorJugadoresPage.this._wicketExtensionFactoryMethods.addChild(item, _label_1);
          Label _label_2 = new Label("handicap");
          BuscadorJugadoresPage.this._wicketExtensionFactoryMethods.addChild(item, _label_2);
          Label _label_3 = new Label("promedioUltimoPartido");
          BuscadorJugadoresPage.this._wicketExtensionFactoryMethods.addChild(item, _label_3);
        }
      };
      listView.setPopulateItem(_function);
      MarkupContainer _addChild = this._wicketExtensionFactoryMethods.addChild(parent, listView);
      _xblockexpression = (_addChild);
    }
    return _xblockexpression;
  }
}
