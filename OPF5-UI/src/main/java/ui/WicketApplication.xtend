package ui

import org.apache.wicket.protocol.http.WebApplication
import org.uqbar.commons.utils.ApplicationContext
import domain.Jugador
import home.HomeJugadores
import domain.Partido
import home.HomePartido

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see ui.Start#main(String[])
 */
class WicketApplication extends WebApplication {
	
	override getHomePage() {
		HomePage
	}
	
	override init() {
		super.init()
		ApplicationContext.instance.configureSingleton(Jugador, new HomeJugadores)
		ApplicationContext.instance.configureSingleton(Partido, new HomePartido)
		// add your configuration here
	}
	
}