package mvc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
        Controller c = new Controller();

        m.view = v; // Model tells View to update...

        v.model = m; // View gets data from model...
        v.controller = c; // View sends activity to controller...

        c.model = m; // Controller updates model as appropriate...
        c.view = v; // Controller can also tell view to show success/failures
        // (note, this status information could be kept in the Model, so that Controller doesn't talk to View directly...
        // ... but I think that's a bad idea, because the Model should be independent from the view.)

        System.out.println("Boolean Storage Wonderful UI");
        System.out.println("============================");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        v.init();
        while (true) {
            v.render();
            System.out.println("Enter T to click 'true', F to click 'false', anything else to quit:");
            switch (sc.nextLine()) {
                case "T" -> v.clickedTrue();
                case "F" -> v.clickedFalse();
                default -> {return;}
            };
        }

    }
}
