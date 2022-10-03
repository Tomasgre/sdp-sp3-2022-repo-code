package spy;

public class SpyMain {
  public static void main(String[] args) {
    try {
      var thisClassPrinter = Spy.getSpy("spy.Spy");
      thisClassPrinter.printAll(args);
    } catch (ClassNotFoundException ex) {
      System.err.println("It broke!");
    }
  }
}

class Person {
  private int x;
}
