package builderpattern;

public class TestBuilderPattern {
  public static void main(String[] args) {

    CarBuilder carBuilder = new EstateCarBuilder();
    CarDirector director = new CarDirector(carBuilder);
    director.build();
    Car car = carBuilder.getCar();
    //Car car = director.getCar();
    System.out.println(car);

    carBuilder = new SportsCarBuilder();
    director = new CarDirector(carBuilder);
    director.build();
    car = carBuilder.getCar();
    System.out.println(car);


  }
}
