package factory2;

public class Main {
    public static void main(String[] args) {
        new CheapVehicleShop().order("car").run();
        new CheapVehicleShop().order("plane").run();
        new ExpensiveVehicleShop().order("my_factorymethod.Car").run();
        new ExpensiveVehicleShop().order("my_factorymethod.Plane").run();

    }
}
