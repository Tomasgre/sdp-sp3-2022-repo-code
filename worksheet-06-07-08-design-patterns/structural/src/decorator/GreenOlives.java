package decorator;

public class GreenOlives extends PizzaDecorator {
    public GreenOlives(Pizza pizza) {
        this.pizza = pizza;
        this.price = 5.47;
    }

    @Override
    public String getDesc() {
        return pizza.getDesc() + ", Green Olives (" + price + ")";
    }

}
