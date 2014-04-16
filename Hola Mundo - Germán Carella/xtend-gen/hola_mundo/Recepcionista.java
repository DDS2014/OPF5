package hola_mundo;

import hola_mundo.Mundo;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Recepcionista {
  public String saludar(final Mundo unMundo) {
    String _nombre = unMundo.getNombre();
    String _plus = ("Hola " + _nombre);
    String _plus_1 = (_plus + "!");
    String _println = InputOutput.<String>println(_plus_1);
    return _println;
  }
}
