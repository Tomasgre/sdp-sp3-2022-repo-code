package command;

public class Copy implements Command {

    private File file;
    private String destination;

    public Copy(File file, String destination) {
        this.file = file;
        this.destination = destination;
    }

    @Override
    public void execute() {
        System.out.println("Executing command: copy " + file.getName() + " to " + destination + "...");
        file.copyTo(destination);
    }
}
