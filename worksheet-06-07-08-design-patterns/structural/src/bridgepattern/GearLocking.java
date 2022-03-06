package bridgepattern;

public class GearLocking implements Product {
    private String productName;

    public GearLocking(String gear_locking_system) {
        productName = gear_locking_system;
    }

    @Override
    public String productName() {
        return productName;
    }

    @Override
    public void produce() {
        System.out.println("Producing Gear Locking System");
    }
}
