package ui;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
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
  }
}
