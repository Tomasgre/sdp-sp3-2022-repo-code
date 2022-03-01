package command;

public class Invoker {

    // private List<Command> doneCommands;
    // private List<Command> undoneCommands;

    public void doNewCommand(Command c) {
        try {
            c.execute();
            // doneCommands.add(c);
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }

    }

    // public void undoPreviousCommand() {...}
    // public void redoCommand() {...}

}
