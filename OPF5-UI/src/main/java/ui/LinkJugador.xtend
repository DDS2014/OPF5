package ui

import org.uqbar.wicket.xtend.XLink
import org.apache.wicket.behavior.SimpleAttributeModifier
import domain.Jugador
import org.apache.wicket.markup.html.basic.Label

class LinkJugador extends XLink<Jugador> //????????????
{
	
	new(String ID, Jugador jugador) 
	{
		super(ID)
		this.add(new Label("nombre"))
		if (jugador.handicap > 8)
		{
			this.add(new SimpleAttributeModifier("style", "color:white; background-color: blue"))
		}

		
		//this.onClick = [| responsePage = new DatosJugadorPage(jugador)]
	}
	
}