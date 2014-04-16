package hola_mundo;

import hola_mundo.Mundo;
import hola_mundo.Recepcionista;

@SuppressWarnings("all")
public class Test {
  public static void main(final String[] args) {
    Recepcionista recepcionista = null;
    Recepcionista _recepcionista = new Recepcionista();
    recepcionista = _recepcionista;
    Mundo mundo = null;
    Mundo _mundo = new Mundo();
    mundo = _mundo;
    recepcionista.saludar(mundo);
  }
}
