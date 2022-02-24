package decorator;

public class Cheese extends PizzaDecorator {

    public Cheese(Pizza pizza) {
        this.pizza = pizza;
        this.price = 20.72;
    }

    @Override
    public String getDesc() {
        return pizza.getDesc() + ", Cheese (" + price + ")";
    }
}
