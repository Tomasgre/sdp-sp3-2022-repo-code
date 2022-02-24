package factory2;

public abstract class VehicleShop {

    public abstract Vehicle create(String name);

    // Some implementation that uses the create method
    public Vehicle order(String name) {
        System.out.println("Processing order...");
        Vehicle v = create(name);
        System.out.println("Shipping your vehicle: " + v.getName());
        return v;
    }
}
