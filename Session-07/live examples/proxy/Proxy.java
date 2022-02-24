package proxy;

public class Proxy implements TheAction {

    private BigThing b;

    @Override
    public void doIt() {
        // Check if some condition holds, only then...
        b.doIt();
    }
}
