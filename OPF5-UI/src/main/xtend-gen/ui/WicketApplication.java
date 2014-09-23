package ui;

import domain.Jugador;
import domain.Partido;
import home.HomeJugadores;
import home.HomePartido;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.uqbar.commons.utils.ApplicationContext;
import ui.HomePage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see ui.Start#main(String[])
 */
@SuppressWarnings("all")
public class WicketApplication extends WebApplication {
  public Class<? extends Page> getHomePage() {
    return HomePage.class;
  }
  
  public void init() {
    super.init();
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomeJugadores _homeJugadores = new HomeJugadores();
    _instance.<HomeJugadores>configureSingleton(Jugador.class, _homeJugadores);
    ApplicationContext _instance_1 = ApplicationContext.getInstance();
    HomePartido _homePartido = new HomePartido();
    _instance_1.<HomePartido>configureSingleton(Partido.class, _homePartido);
  }
}
