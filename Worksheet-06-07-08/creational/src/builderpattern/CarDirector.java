package builderpattern;

public class CarDirector {

    private CarBuilder builder;

    CarDirector(CarBuilder builder) {
        this.builder = builder;
    }

    public void build (){
        this.builder.buildBody();
        this.builder.buildBreaks();
        this.builder.buildEngine();
        this.builder.buildFuel();
        this.builder.buildPower();
        this.builder.buildSeats();
        this.builder.buildWindows();
    }

    public Car getCar(){
        return this.builder.getCar();
    }
}
