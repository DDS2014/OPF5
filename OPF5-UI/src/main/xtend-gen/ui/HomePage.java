package ui;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
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
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(this, mainForm);
    }
    return _xblockexpression;
  }
  
  public Object buscar() {
    return null;
  }
  
  public void generar() {
    GenerarEquiposPage _generarEquiposPage = new GenerarEquiposPage(this);
    this.setResponsePage(_generarEquiposPage);
  }
}
