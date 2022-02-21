package decorator;

public class SimplyVegPizza implements Pizza {
  @Override
  public String getDesc() {
    return "SimplyVegPizza (" + getPrice() + ")";
  }

  @Override
  public double getPrice() {
    return 230;
  }
}
