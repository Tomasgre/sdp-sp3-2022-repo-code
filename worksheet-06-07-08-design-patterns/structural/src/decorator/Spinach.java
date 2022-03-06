package decorator;

public class Spinach extends PizzaDecorator {
    public Spinach(Pizza pizza) {
        this.pizza = pizza;
        price = 7.92;
    }

    @Override
    public String getDesc() {
        return pizza.getDesc() + ", Spinach (" + price + ")";
    }
}
