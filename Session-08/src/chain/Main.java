package chain;

public class Main {
    public static void main(String[] args) {
        Handler hA = new HandlerA("Handler A");
        Handler hB = new HandlerB("Handler B");
        Handler hC = new HandlerC("Handler C");

        System.out.println("******** Handler A by itself:");
        System.out.println();

        hA.handle("A");
        System.out.println();
        hA.handle("B");
        System.out.println();

        System.out.println("******** Handler A followed by Handlers B and C:");
        System.out.println("(Note: they are joined together at runtime!)");
        System.out.println();

        hA.setNextHandler(hB);
        hB.setNextHandler(hC);

        hA.handle("A");
        System.out.println();
        hA.handle("B");
        System.out.println();
        hA.handle("C");
        System.out.println();
        hA.handle("D");
    }
}
