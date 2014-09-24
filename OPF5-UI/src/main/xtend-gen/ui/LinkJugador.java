package ui;

import domain.Jugador;
import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.uqbar.wicket.xtend.XLink;
import ui.InfoJugadorPage;

@SuppressWarnings("all")
public class LinkJugador extends XLink<Jugador> {
  public LinkJugador(final String ID, final Jugador jugador, final WebPage parentPage) {
    super(ID);
    Label _label = new Label("nombre");
    this.add(_label);
    double _handicap = jugador.getHandicap();
    boolean _greaterThan = (_handicap > 8);
    if (_greaterThan) {
      SimpleAttributeModifier _simpleAttributeModifier = new SimpleAttributeModifier("style", "color:white; background-color: blue");
      this.add(_simpleAttributeModifier);
    }
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        InfoJugadorPage _infoJugadorPage = new InfoJugadorPage(jugador, parentPage);
        LinkJugador.this.setResponsePage(_infoJugadorPage);
      }
    };
    this.setOnClick(_function);
  }
}
