package ui;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.settings.IFrameworkSettings;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;

/**
 * @author ?
 */
@SuppressWarnings("all")
public class HomePage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  public HomePage() {
    Application _application = this.getApplication();
    IFrameworkSettings _frameworkSettings = _application.getFrameworkSettings();
    String _version = _frameworkSettings.getVersion();
    final Label label = new Label("version", _version);
    this._wicketExtensionFactoryMethods.addChild(this, label);
  }
}
