package bridgepattern;

public class Motoren extends Car {
    public Motoren(Product product, String carType) {
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
