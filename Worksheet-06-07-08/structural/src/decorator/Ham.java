package decorator;

public class Ham extends PizzaDecorator {
    public Ham(Pizza pizza) {
        this.pizza = pizza;
        this.price = 18.12;
    }

    @Override
    public String getDesc() {
        return pizza.getDesc() + ", Ham (" + price + ")";
    }
}
