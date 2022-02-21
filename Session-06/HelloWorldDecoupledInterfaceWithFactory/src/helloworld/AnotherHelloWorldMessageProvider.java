package helloworld;

public class AnotherHelloWorldMessageProvider implements MessageProvider {

  @Override
  public String getMessage() {
    return "Hello thing!";
  }

}