package mvc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
        Controller c = new Controller();

        v.model = m; // View gets data from model...
        v.controller = c; // View sends activity to controller...

        c.model = m; // Controller updates model as appropriate...
        c.view = v; // Controller can notify view about success/failures

        System.out.println("Boolean storage version 2.0");
        System.out.println("===========================");
        System.out.println();

        v.init();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter T to click 'true', F to click 'false', anything else to quit:");
            switch (sc.nextLine()) {
                case "T" -> v.clickedTrue();
                case "F" -> v.clickedFalse();
                default -> {return;}
            };
        }

    }
}
