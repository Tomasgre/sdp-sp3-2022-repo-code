package facade;

public class Facade implements SimpleInterface {
    private BigThing b;

    @Override
    public void doOneThing() {
        b.a();
        b.b();
        b.c();
        b.d();
        b.e();
    }
}
