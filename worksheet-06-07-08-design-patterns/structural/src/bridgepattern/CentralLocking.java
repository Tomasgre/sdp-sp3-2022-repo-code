package bridgepattern;

public class CentralLocking implements Product {
    private String productName;

    public CentralLocking(String central_locking_system) {
        productName = central_locking_system;
    }

    @Override
    public String productName() {
        return productName;
    }

    @Override
    public void produce() {
        System.out.println("Producing Central Locking System");
    }
}
