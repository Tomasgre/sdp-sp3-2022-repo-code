package factory2;

public abstract class Vehicle {

    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public abstract void run();

    public String getName() {
        return name;
    }
}
