package ui;

import applicationModel.BuscadorDeJugadores;
import com.google.common.base.Objects;
import domain.Jugador;
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
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.model.UserException;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import org.uqbar.wicket.xtend.XListView;
import ui.HomePage;
import ui.LinkJugador;

@SuppressWarnings("all")
public class BuscadorJugadoresPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private BuscadorDeJugadores buscador;
  
  private HomePage parentPage;
  
  private WebMarkupContainer selectorDiv;
  
  private WebMarkupContainer inputDivs;
  
  private WebMarkupContainer nombreDiv;
  
  private WebMarkupContainer apodoDiv;
  
  private WebMarkupContainer fechaDiv;
  
  private WebMarkupContainer handicapDivs;
  
  private WebMarkupContainer promedioDiv;
  
  private WebMarkupContainer infraccionesDiv;
  
  public BuscadorJugadoresPage(final HomePage parentPage) {
    BuscadorDeJugadores _buscadorDeJugadores = new BuscadorDeJugadores();
    this.buscador = _buscadorDeJugadores;
    this.parentPage = parentPage;
    CompoundPropertyModel<BuscadorDeJugadores> _compoundPropertyModel = new CompoundPropertyModel<BuscadorDeJugadores>(this.buscador);
    final Form<BuscadorDeJugadores> buscarForm = new Form<BuscadorDeJugadores>("buscarJugadoresForm", _compoundPropertyModel);
    this.agregarSelectorBusqueda(buscarForm);
    this.agregarCamposBusqueda(buscarForm);
    this.agregarGrillaResultados(buscarForm);
    this.agregarFeedbackPanel(buscarForm);
    this.agregarBotonVolver(buscarForm);
    this._wicketExtensionFactoryMethods.addChild(this, buscarForm);
    this.buscarJugadores();
  }
  
  public MarkupContainer agregarBotonVolver(final Form<BuscadorDeJugadores> form) {
    MarkupContainer _xblockexpression = null;
    {
      final XButton volverBtn = new XButton("btnVolver");
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          BuscadorJugadoresPage.this.volver();
        }
      };
      volverBtn.setOnClick(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, volverBtn);
    }
    return _xblockexpression;
  }
  
  public void volver() {
    this.setResponsePage(this.parentPage);
  }
  
  public MarkupContainer agregarFeedbackPanel(final Form<BuscadorDeJugadores> form) {
    FeedbackPanel _feedbackPanel = new FeedbackPanel("feedbackPanel");
    return this._wicketExtensionFactoryMethods.addChild(form, _feedbackPanel);
  }
  
  public WebMarkupContainer agregarSelectorBusqueda(final Form<BuscadorDeJugadores> parent) {
    WebMarkupContainer _xblockexpression = null;
    {
      WebMarkupContainer div = new WebMarkupContainer("selectorDiv");
      final XButton selectButton = new XButton("seleccionar");
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
      _xblockexpression = this.selectorDiv = div;
    }
    return _xblockexpression;
  }
  
  public Component agregarCamposBusqueda(final Form<BuscadorDeJugadores> parent) {
    Component _xblockexpression = null;
    {
      WebMarkupContainer div = new WebMarkupContainer("inputDivs");
      WebMarkupContainer divNombre = new WebMarkupContainer("nombreDiv");
      TextField<String> _textField = new TextField<String>("criterioNombre.nombre");
      this._wicketExtensionFactoryMethods.addChild(divNombre, _textField);
      this._wicketExtensionFactoryMethods.addChild(div, divNombre);
      this.nombreDiv = divNombre;
      WebMarkupContainer divApodo = new WebMarkupContainer("apodoDiv");
      TextField<String> _textField_1 = new TextField<String>("criterioApodo.apodo");
      this._wicketExtensionFactoryMethods.addChild(divApodo, _textField_1);
      this._wicketExtensionFactoryMethods.addChild(div, divApodo);
      this.apodoDiv = divApodo;
      WebMarkupContainer divFecha = new WebMarkupContainer("fechaDiv");
      TextField<Date> _textField_2 = new TextField<Date>("criterioEdad.fecha");
      this._wicketExtensionFactoryMethods.addChild(divFecha, _textField_2);
      this._wicketExtensionFactoryMethods.addChild(div, divFecha);
      this.fechaDiv = divFecha;
      WebMarkupContainer divHandicap = new WebMarkupContainer("handicapDiv");
      TextField<Double> _textField_3 = new TextField<Double>("criterioHandicap.desde");
      this._wicketExtensionFactoryMethods.addChild(divHandicap, _textField_3);
      TextField<Double> _textField_4 = new TextField<Double>("criterioHandicap.hasta");
      this._wicketExtensionFactoryMethods.addChild(divHandicap, _textField_4);
      this._wicketExtensionFactoryMethods.addChild(div, divHandicap);
      this.handicapDivs = divHandicap;
      WebMarkupContainer divPromedio = new WebMarkupContainer("promedioDiv");
      TextField<Double> _textField_5 = new TextField<Double>("criterioPromedio.desde");
      this._wicketExtensionFactoryMethods.addChild(divPromedio, _textField_5);
      TextField<Double> _textField_6 = new TextField<Double>("criterioPromedio.hasta");
      this._wicketExtensionFactoryMethods.addChild(divPromedio, _textField_6);
      this._wicketExtensionFactoryMethods.addChild(div, divPromedio);
      this.promedioDiv = divPromedio;
      WebMarkupContainer divInfracciones = new WebMarkupContainer("infraccionesDiv");
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
      _xblockexpression = this.inputDivs.setVisible(false);
    }
    return _xblockexpression;
  }
  
  public Component limpiar() {
    Component _xblockexpression = null;
    {
      this.buscador.clear();
      this.selectorDiv.setVisible(true);
      _xblockexpression = this.inputDivs.setVisible(false);
    }
    return _xblockexpression;
  }
  
  public void buscarJugadores() {
    try {
      this.buscador.search();
    } catch (final Throwable _t) {
      if (_t instanceof UserException) {
        final UserException e = (UserException)_t;
        String _message = e.getMessage();
        this.info(_message);
      } else if (_t instanceof RuntimeException) {
        final RuntimeException e_1 = (RuntimeException)_t;
        this.error("Ocurrió un error al realizar la búsqueda solicitada.");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
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
          _xifexpression_1 = this.nombreDiv.setVisible(true);
        } else {
          Component _xifexpression_2 = null;
          CriterioBusqueda _criterio_2 = this.buscador.getCriterio();
          Class<? extends CriterioBusqueda> _class_1 = _criterio_2.getClass();
          boolean _equals_1 = Objects.equal(_class_1, BusquedaApodo.class);
          if (_equals_1) {
            _xifexpression_2 = this.apodoDiv.setVisible(true);
          } else {
            Component _xifexpression_3 = null;
            CriterioBusqueda _criterio_3 = this.buscador.getCriterio();
            Class<? extends CriterioBusqueda> _class_2 = _criterio_3.getClass();
            boolean _equals_2 = Objects.equal(_class_2, BusquedaEdad.class);
            if (_equals_2) {
              _xifexpression_3 = this.fechaDiv.setVisible(true);
            } else {
              Component _xifexpression_4 = null;
              CriterioBusqueda _criterio_4 = this.buscador.getCriterio();
              Class<? extends CriterioBusqueda> _class_3 = _criterio_4.getClass();
              boolean _equals_3 = Objects.equal(_class_3, BusquedaHandicap.class);
              if (_equals_3) {
                _xifexpression_4 = this.handicapDivs.setVisible(true);
              } else {
                Component _xifexpression_5 = null;
                CriterioBusqueda _criterio_5 = this.buscador.getCriterio();
                Class<? extends CriterioBusqueda> _class_4 = _criterio_5.getClass();
                boolean _equals_4 = Objects.equal(_class_4, BusquedaPromedio.class);
                if (_equals_4) {
                  _xifexpression_5 = this.promedioDiv.setVisible(true);
                } else {
                  Component _xifexpression_6 = null;
                  CriterioBusqueda _criterio_6 = this.buscador.getCriterio();
                  Class<? extends CriterioBusqueda> _class_5 = _criterio_6.getClass();
                  boolean _equals_5 = Objects.equal(_class_5, BusquedaCompuesta.class);
                  if (_equals_5) {
                    _xifexpression_6 = this.infraccionesDiv.setVisible(true);
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
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    } else {
      this.info("Debe seleccionar un criterio de búsqueda.");
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
      _xblockexpression = this.infraccionesDiv.setVisible(false);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer agregarGrillaResultados(final Form<BuscadorDeJugadores> parent) {
    MarkupContainer _xblockexpression = null;
    {
      final XListView<Jugador> listView = new XListView<Jugador>("resultados");
      final Procedure1<ListItem<Jugador>> _function = new Procedure1<ListItem<Jugador>>() {
        public void apply(final ListItem<Jugador> item) {
          Jugador _modelObject = item.getModelObject();
          CompoundPropertyModel<Jugador> _asCompoundModel = BuscadorJugadoresPage.this._wicketExtensionFactoryMethods.<Jugador>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Jugador _modelObject_1 = item.getModelObject();
          LinkJugador _linkJugador = new LinkJugador("link", _modelObject_1, BuscadorJugadoresPage.this);
          BuscadorJugadoresPage.this._wicketExtensionFactoryMethods.addChild(item, _linkJugador);
          Label _label = new Label("apodo");
          BuscadorJugadoresPage.this._wicketExtensionFactoryMethods.addChild(item, _label);
          Label _label_1 = new Label("handicap");
          BuscadorJugadoresPage.this._wicketExtensionFactoryMethods.addChild(item, _label_1);
          Label _label_2 = new Label("promedioUltimoPartido");
          BuscadorJugadoresPage.this._wicketExtensionFactoryMethods.addChild(item, _label_2);
        }
      };
      listView.setPopulateItem(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, listView);
    }
    return _xblockexpression;
  }
}
