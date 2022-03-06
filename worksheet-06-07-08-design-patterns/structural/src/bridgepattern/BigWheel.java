package bridgepattern;

public class BigWheel extends Car {
    public BigWheel(Product product, String carType) {
        super(product, carType);
    }

    @Override
    public void assemble() {
        System.out.println("Assembling " + getProduct().productName() +
            " for " + getCarType());
    }

    @Override
    public void produceProduct() {
        getProduct().produce();
        System.out.println("Modifing product " + getProduct().productName() +
            " according to " + getCarType());
    }

}
