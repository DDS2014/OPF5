package ui

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods


/**
 * 
 * @author ?
 */
class HomePage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods

	new() {
		val label = new Label("version", application.frameworkSettings.version)
		
		this.addChild(label);

		// TODO Add your page's components here
    }
}
