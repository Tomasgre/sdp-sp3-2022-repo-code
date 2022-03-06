package state;

import java.util.Scanner;

/* Map of game:
            Black Room
                |
            White Room
                |
            Gold Room
 */

public class Main {
    public static void main(String[] args) {

        System.out.println("Exciting Text Adventure!!!");
        System.out.println("==========================");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println(Context.currentRoom.description);

            System.out.println("Enter N to go North, S to go South, Q to quit:");
            String str = sc.nextLine();

            switch (str) {
                case "N" -> Context.theContext.goNorth();
                case "S" -> Context.theContext.goSouth();
                case "Q" -> {
                    System.out.println("Thanks for playing!"); return;
                }
                default -> System.out.println("I didn't understand that.");
            };

        }
    }
}
