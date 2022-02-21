package decorator;

public class Meat extends PizzaDecorator {
  public Meat(Pizza pizza) {
    this.pizza = pizza;
    this.price = 14.25;
  }

  @Override
  public String getDesc() {
    return pizza.getDesc() + ", Meat (" + price + ")";
  }
}
