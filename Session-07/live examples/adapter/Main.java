package adapter;

public class Main {
    public static void main(String[] args) {
        EuropeanPlug e = new EuropeanPlug();
        Adapter a = new Adapter();
        e.connect(a);
    }
}
