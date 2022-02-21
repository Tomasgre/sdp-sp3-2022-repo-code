package factorymethod;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        // default factoryMethod
        Product p = new Creator().factoryMethod("a");
        System.out.println(p);

        // one line creation
        Product p2 = new ConcreteCreator().factoryMethod("v");
        System.out.println(p2);

        // mutliple creations in response to user interaction
        ConcreteCreator cFactory = new ConcreteCreator();
        Scanner sc = new Scanner(System.in);
        String mes = "Product: Bowl, Cup or Vase (b / c / v)? x to end.";

        System.out.println(mes);
        while (sc.hasNext()) {
            String type = sc.next().toLowerCase();
            if (type.equals("x")) break;

            Product p3 = cFactory.factoryMethod(type);
            if (p3 != null) System.out.println(p3);

            System.out.println("\n" + mes);
        }

    }
}
