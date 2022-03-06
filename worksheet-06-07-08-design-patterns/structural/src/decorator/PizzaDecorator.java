package decorator;

public abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;
    protected double price;

    @Override
    public double getPrice() {
        return pizza.getPrice() + price;
    }
}
