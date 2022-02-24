package factory2;

public class CheapVehicleShop extends VehicleShop {
    @Override
    public Vehicle create(String name) {
        Vehicle v = switch (name) {
            case "plane" -> new Plane("Cheap Boeing");
            case "car" -> new Car("Cheap Ferrari");
            default -> throw new UnsupportedOperationException();
        };
        return v;
    }
}
