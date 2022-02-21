package decorator;

public class RomaTomatoes extends PizzaDecorator {
  public RomaTomatoes(Pizza pizza) {
    this.pizza = pizza;
    this.price = 5.20;
  }

  @Override
  public String getDesc() {
    return pizza.getDesc() + ", Roma Tomatoes (" + price + ")";
  }
}
