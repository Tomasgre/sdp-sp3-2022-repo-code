package command;

public class Main {

    public static void main(String[] args) {

        Invoker invoker = new Invoker();

        File file = new File("file.txt");
        String destination = "/Users/jimmy/";
        String destination2 = "/Users/frank/";

        invoker.doNewCommand(new Copy(file, destination));
        invoker.doNewCommand(new Copy(file, destination2));
        invoker.doNewCommand(new Delete(file));
        // i.undoPreviousCommand();
        // i.undoPreviousCommand();
        // i.redoCommand();

    }

}
