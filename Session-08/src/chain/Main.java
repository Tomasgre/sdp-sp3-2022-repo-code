package chain;

public class Main {
    public static void main(String[] args) {
        Handler hA = new HandlerA();
        Handler hB = new HandlerB();
        Handler hC = new HandlerC();

        hA.setNextHandler(hB);
        hB.setNextHandler(hC);

        hA.handle("A");
        hA.handle("B");
        hA.handle("C");
        hA.handle("D");
    }
}
