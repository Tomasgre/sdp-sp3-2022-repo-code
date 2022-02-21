package factorymethod;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConcreteProduct implements Product {

    private String name;
    private Type type;
    private double cost;
    private LocalDate dateMade;

    ConcreteProduct(String name, Type type, double cost, LocalDate dateMade) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.dateMade = dateMade;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("£###.##");
        DateTimeFormatter datef = DateTimeFormatter.ofPattern("EEE, MMM d, yyyy");
        return getName() + " (" + getType().toString() + "), "
                + df.format(getPrice()) + ", date made: " + datef.format(getDateMade());
    }

    @Override
    public double getPrice() {
        return this.cost;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public LocalDate getDateMade() {
        return this.dateMade;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
