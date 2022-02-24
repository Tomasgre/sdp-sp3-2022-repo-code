package adapter;

public class Adapter implements EuropeanSocket {

    private UKSocket s;

    @Override
    public void connectEuroStyle() {
        s.changeVoltage(230);
        s.connectUKStyle();
    }
}
