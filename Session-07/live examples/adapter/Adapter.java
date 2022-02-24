package adapter;

public class Adapter implements EuropeanSocket {

    private UKSocket s;

    @Override
    public void connectEuroStyle() {
        // ...internal wiring... goes out to the UK plug.
        s.connectToUKSocket();
    }
}
