package ui;

import domain.Jugador;
import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.uqbar.wicket.xtend.XLink;

@SuppressWarnings("all")
public class LinkJugador extends XLink<Jugador> {
  public LinkJugador(final String ID, final Jugador jugador) {
    super(ID);
    Label _label = new Label("nombre");
    this.add(_label);
    double _handicap = jugador.getHandicap();
    boolean _greaterThan = (_handicap > 8);
    if (_greaterThan) {
      SimpleAttributeModifier _simpleAttributeModifier = new SimpleAttributeModifier("style", "color:white; background-color: blue");
      this.add(_simpleAttributeModifier);
    }
  }
}
