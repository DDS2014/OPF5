package ui;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import ui.BuscadorJugadoresPage;
import ui.GenerarEquiposPage;

/**
 * @author ?
 */
@SuppressWarnings("all")
public class HomePage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  public HomePage() {
    this.agregarAcciones();
  }
  
  public MarkupContainer agregarAcciones() {
    MarkupContainer _xblockexpression = null;
    {
      Form<Object> mainForm = new Form<Object>("mainForm");
      final XButton generarBtn = new XButton("btnGenerarPage");
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          HomePage.this.generar();
        }
      };
      generarBtn.setOnClick(_function);
      this._wicketExtensionFactoryMethods.addChild(mainForm, generarBtn);
      final XButton buscarBtn = new XButton("btnBuscarPage");
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          HomePage.this.buscar();
        }
      };
      buscarBtn.setOnClick(_function_1);
      this._wicketExtensionFactoryMethods.addChild(mainForm, buscarBtn);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(this, mainForm);
    }
    return _xblockexpression;
  }
  
  public void buscar() {
    BuscadorJugadoresPage _buscadorJugadoresPage = new BuscadorJugadoresPage(this);
    this.setResponsePage(_buscadorJugadoresPage);
  }
  
  public void generar() {
    GenerarEquiposPage _generarEquiposPage = new GenerarEquiposPage(this);
    this.setResponsePage(_generarEquiposPage);
  }
}
