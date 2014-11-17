package ui

import domain.sugerencias.Comunidad
import home.HomeComunidad
import org.apache.wicket.protocol.http.WebApplication
import org.uqbar.commons.utils.ApplicationContext
import dao.SessionManager

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
		SessionManager::startApplication
//		ApplicationContext.instance.configureSingleton(Jugador, new HomeJugadores)
//		ApplicationContext.instance.configureSingleton(Partido, new HomePartido)
//		*********
		ApplicationContext.instance.configureSingleton(Comunidad, new HomeComunidad) //esto se tiene que cambiar por la home comunidad SQL
//		*********
		// add your configuration here
	}
	
}