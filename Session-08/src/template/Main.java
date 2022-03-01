package template;

public class Main {
    public static void main(String[] args) {

        System.out.println("Running process with implementation A...");
        new ImplementationA().runProcess();

        System.out.println("Running process with implementation B...");
        new ImplementationB().runProcess();

    }
}
