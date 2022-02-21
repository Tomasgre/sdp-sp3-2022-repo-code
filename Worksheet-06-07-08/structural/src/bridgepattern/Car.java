package bridgepattern;

public abstract class Car {

  //protected scope would nullify need for getters
  private final Product product;
  private final String carType;

  public Car(Product product, String carType) {
    this.product = product;
    this.carType = carType;
  }

  public abstract void assemble();

  public abstract void produceProduct();

  public Product getProduct(){
    return product;
  }

  public String getCarType() {
      return carType;
  }

  public void printDetails() {
    System.out.println("Car: " + carType + ", Product:" + product.productName());
  }
}