package factory2;

public class Plane extends Vehicle {

    public Plane(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(name + " goes: Whoooooosh!");
    }
}

