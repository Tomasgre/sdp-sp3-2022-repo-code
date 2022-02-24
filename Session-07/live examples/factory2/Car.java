package factory2;

public class Car extends Vehicle {

    public Car(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(name + " goes: vrrrrrooooommm!");
    }
}
