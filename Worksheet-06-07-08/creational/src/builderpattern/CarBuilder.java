package builderpattern;

public interface CarBuilder {

    void buildBody();
    void buildPower();
    void buildEngine();
    void buildBreaks();
    void buildSeats();
    void buildWindows();
    void buildFuel();
    Car getCar();
}
