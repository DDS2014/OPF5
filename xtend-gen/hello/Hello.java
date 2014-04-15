package hello;

import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Hello {
  public String sayHello() {
    String _println = InputOutput.<String>println("Hello world!");
    return _println;
  }
}
