package hello;

import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Hello {
  public String sayHello() {
    return InputOutput.<String>println("Hello world!");
  }
}
